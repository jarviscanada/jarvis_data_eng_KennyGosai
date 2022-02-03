#! /bin/sh

#- assign CLI arguments to variables
psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

# # of args
if [ $# -ne  5 ]; then
  echo 'USAGE: ./scripts/host_info.sh <psql_host> <psql_port> <db_name> <psql_user> <psql_password>';
  exit 1
fi

#- parse host hardware specifications using bash cmds
lscpu_out=`lscpu`

#hardware
hostname=$(hostname -f)
cpu_number=$(echo "$lscpu_out"  | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture=$(echo "$lscpu_out"  | egrep "^Architecture:" | awk '{print $2}' | xargs)
cpu_model=$(echo "$lscpu_out"  | egrep "^Model name:" | awk -F: '{print $2}' | xargs)
cpu_mhz=$(echo "$lscpu_out"  | egrep "^CPU MHz:" | awk '{print $3}' | xargs)
l2_cache=$(echo "$lscpu_out"  | egrep "^L2 cache:" | awk '{print $3}' | xargs | sed 's/.$//')
total_mem=$(grep MemTotal /proc/meminfo | awk '{print $2}' | xargs)
timestamp=$(vmstat -t | awk 'NR == 3 {print $18" "$19}' | xargs)

#- INSERT statement
insert_stmt="INSERT INTO host_info(id, hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, L2_cache, total_mem, \"timestamp\") VALUES(DEFAULT, '$hostname', '$cpu_number', '$cpu_architecture', '$cpu_model', '$cpu_mhz', '$l2_cache', '$total_mem', '$timestamp');"

#set up env var for pql cmd
export PGPASSWORD=$psql_password

#Insert date into a database
psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit $?