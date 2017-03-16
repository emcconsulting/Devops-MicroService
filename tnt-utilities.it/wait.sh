#!/bin/bash

echo 'waitforitscript>>>>>>>>>>>>>>>>>>>>>>>>>>>'
set -e

host="$1"
port="$2"
shift
shift
cmd="$@"

echo 'commands is $cmd'


echo "waiting for TCP connection to $host:$port...cmd is $cmd"

while ! nc -w 1 $host $port 2>/dev/null
do
  echo "waiting for TCP connection to $host:$port...cmd is $cmd"
  sleep 4
done

java -jar app.jar 
#exec $cmd
