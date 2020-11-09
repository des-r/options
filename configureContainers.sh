#!/usr/bin/env bash

docker exec -d ora1 sqlplus -s "system/oracle" @base.sql
docker exec -d ora2 sqlplus -s "system/oracle" @base.sql
docker exec -d ora3 sqlplus -s "system/oracle" @base.sql
docker exec -d ora4 sqlplus -s "system/oracle" @base.sql
docker exec -d ora5 sqlplus -s "system/oracle" @base.sql
docker exec -d ora6 sqlplus -s "system/oracle" @base.sql
docker exec -d ora7 sqlplus -s "system/oracle" @base.sql
docker exec -d ora8 sqlplus -s "system/oracle" @base.sql

sleep 20

./gradlew flywayMigrate flywayInfo -Penv=ora1
./gradlew flywayMigrate flywayInfo -Penv=ora2
./gradlew flywayMigrate flywayInfo -Penv=ora3
./gradlew flywayMigrate flywayInfo -Penv=ora4
./gradlew flywayMigrate flywayInfo -Penv=ora5
./gradlew flywayMigrate flywayInfo -Penv=ora6
./gradlew flywayMigrate flywayInfo -Penv=ora7
./gradlew flywayMigrate flywayInfo -Penv=ora8
