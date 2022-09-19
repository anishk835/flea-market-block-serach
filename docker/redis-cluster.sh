#!/bin/bash

mkdir {redis-0,redis-1,redis-2}

echo "protected-mode no \n port 6379 \n #authentication \n masterauth redispw \n requirepass redispw" > ${PWD}/redis-0/redis.conf
echo "protected-mode no \n port 6379 \n #authentication \n masterauth redispw \n requirepass redispw" > ${PWD}/redis-1/redis.conf
echo "protected-mode no \n port 6379 \n #authentication \n masterauth redispw \n requirepass redispw" > ${PWD}/redis-2/redis.conf

docker run -d -p 55005:6379 --rm --name redis-0 \
    --net redis -v ${PWD}/redis-0:/etc/redis/ \
    redis:6.0-alpine redis-server /etc/redis/redis.conf
docker run -d -p 55006:6379 --rm --name redis-1 \
    --net redis -v ${PWD}/redis-1:/etc/redis/ \
    redis:6.0-alpine redis-server /etc/redis/redis.conf
docker run -d -p 55007:6379 --rm --name redis-2 \
    --net redis -v ${PWD}/redis-2:/etc/redis/ \
    redis:6.0-alpine redis-server /etc/redis/redis.conf