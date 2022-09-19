#!/bin/bash

mkdir -p {redis-0}

echo "protected-mode no \n port 6379 \n #authentication \n masterauth redispw \n requirepass redispw" > ${PWD}/redis-0/redis.conf

docker run -d -p 55005:6379 --rm --name redis-0 \
    --net redis -v ${PWD}/redis-0:/etc/redis/ \
    redis:6.0-alpine redis-server /etc/redis/redis.conf
