#!/bin/bash
set -e

exec java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=2  -Dspring.config.location=classpath:/application.yml -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.port=9997 -Dcom.sun.management.jmxremote.rmi.port=9997 -jar /home/docker/app/app.jar