#!/usr/bin/env bash

DOCKER_PATH=/u01/app/oracle/product/11.2.0/xe/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games

docker run --name ora1 -e "ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe" -e "PATH=$DOCKER_PATH" -e "ORACLE_SID=XE" -d -p 49170:1521 oracleinanutshell/oracle-xe-11g
docker cp base.sql ora1:/base.sql

sleep 20

docker exec -d ora1 sqlplus -s "system/oracle" @base.sql
