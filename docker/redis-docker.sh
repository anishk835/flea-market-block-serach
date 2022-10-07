#!/bin/bash

mkdir -p {redis-0}

CONFIG="protected-mode no
port 6379
#authentication
masterauth redispw
requirepass redispw"

echo "$CONFIG" > "${PWD}"/redis-0/redis.conf

docker run -d -p 55005:6379 --rm --name redis-0 \
    --net redis -v ${PWD}/redis-0:/etc/redis/ \
    redis:6.0-alpine redis-server /etc/redis/redis.conf
