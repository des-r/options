#!/usr/bin/env bash

DOCKER_PATH=/u01/app/oracle/product/11.2.0/xe/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games

docker run --name ora1 -e "ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe" -e "PATH=$DOCKER_PATH" -e "ORACLE_SID=XE" -d -p 49170:1521 oracleinanutshell/oracle-xe-11g
docker cp base.sql ora1:/base.sql

docker run --name ora2 -e "ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe" -e "PATH=$DOCKER_PATH" -e "ORACLE_SID=XE" -d -p 49162:1521 oracleinanutshell/oracle-xe-11g
docker cp base.sql ora2:/base.sql

docker run --name ora3 -e "ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe" -e "PATH=$DOCKER_PATH" -e "ORACLE_SID=XE" -d -p 49163:1521 oracleinanutshell/oracle-xe-11g
docker cp base.sql ora3:/base.sql

docker run --name ora4 -e "ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe" -e "PATH=$DOCKER_PATH" -e "ORACLE_SID=XE" -d -p 49164:1521 oracleinanutshell/oracle-xe-11g
docker cp base.sql ora4:/base.sql

docker run --name ora5 -e "ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe" -e "PATH=$DOCKER_PATH" -e "ORACLE_SID=XE" -d -p 49169:1521 oracleinanutshell/oracle-xe-11g
docker cp base.sql ora5:/base.sql

docker run --name ora6 -e "ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe" -e "PATH=$DOCKER_PATH" -e "ORACLE_SID=XE" -d -p 49166:1521 oracleinanutshell/oracle-xe-11g
docker cp base.sql ora6:/base.sql

docker run --name ora7 -e "ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe" -e "PATH=$DOCKER_PATH" -e "ORACLE_SID=XE" -d -p 49167:1521 oracleinanutshell/oracle-xe-11g
docker cp base.sql ora7:/base.sql

docker run --name ora8 -e "ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe" -e "PATH=$DOCKER_PATH" -e "ORACLE_SID=XE" -d -p 49168:1521 oracleinanutshell/oracle-xe-11g
docker cp base.sql ora8:/base.sql
