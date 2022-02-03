#! /bin/sh

#cli
psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

# # of args
if [ $# -ne  5 ]; then
  echo 'USAGE: ./scripts/host_usage.sh <psql_host> <psql_port> <db_name> <psql_user> <psql_password>';
  exit 1
fi

#Retrieve hardware specification variables
vmstat_mb=$(vmstat --unit M)
hostname=$(hostname -f)

memory_free=$(echo "$vmstat_mb" | awk '{print $4}'| tail -n1 | xargs)
cpu_idle=$(top -bn1 | grep '%Cpu(s)' | awk -F',' '{printf "%.0f", $4}')
cpu_kernel=$(vmstat -t | awk 'NR == 3 {print $14}'| xargs)
disk_io=$(vmstat -d | awk 'NR == 3 {print $10}'| xargs)
disk_available=$(df -BM | awk 'NR == 6 {print substr($4,1,length($4)-1)}' | xargs)
timestamp=$(vmstat -t | awk 'NR == 3 {print $18" "$19}' | xargs)

#set up env var for pql cmd
export PGPASSWORD=$psql_password

#Subquery to find matching id in host_info table
host_id_query="(SELECT id FROM host_info WHERE hostname='$hostname');";
host_id=$(psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -t -c "$host_id_query")

#PSQL command: Inserts server usage data into host_usage table
insert_stmt="INSERT INTO host_usage(\"timestamp\", host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available) VALUES('$timestamp', '$host_id', '$memory_free', '$cpu_idle', '$cpu_kernel', '$disk_io', '$disk_available')"
psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit $?