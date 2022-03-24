--Functions--

--Rounds timestamp to the nearest 5 minute
CREATE FUNCTION round5(ts timestamp) RETURNS timestamp AS $$
BEGIN
    RETURN date_trunc('hour', ts) + date_part('minute', ts):: int / 5 * interval '5 min';
END;
$$ LANGUAGE PLPGSQL;

--Finds the percentage of memory used
CREATE FUNCTION memoryPercentageUsed(tm int, mf int) RETURNS int as $$
BEGIN
    RETURN cast(((((tm - (mf * 1024)) * 1.0) / tm) * 100.00) as int);
END;
$$ LANGUAGE PLPGSQL;

--Queries--

--Group hosts by hardware info
SELECT
    cpu_number,
    id AS host_id,
    total_mem
FROM
    host_info
ORDER BY
    cpu_number,
    total_mem DESC;

--Average memory usage
SELECT
    host_usage.host_id as host_id,
    host_info.hostname as host_name,
    round5(host_usage.timestamp) as timestamp,
   AVG(memoryPercentageUsed(host_info.total_mem, host_usage.memory_free)) as avg_used_mem_percentage
FROM
    host_usage
    INNER JOIN
        host_info
        ON host_usage.host_id = host_info.id
GROUP BY
    host_id,
    hostname,
    round5(host_usage.timestamp)
ORDER BY
    host_id,
    hostname;

--Detect host failure
SELECT
    host_id,
    round5(timestamp) as ts,
    count(timestamp) as num_data_points
FROM
    host_usage
GROUP BY
    host_id,
    ts
HAVING
    count(timestamp) < 3
ORDER BY
    host_id,
    ts;