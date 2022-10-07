#!/bin/bash

mkdir -p {"sentinel-0","sentinel-1","sentinel-2"}

SENTINEL_CONFIG="port 5000
sentinel resolve-hostnames yes
sentinel monitor mymaster redis-0 6379 2
sentinel down-after-milliseconds mymaster 5000
sentinel failover-timeout mymaster 60000
sentinel parallel-syncs mymaster 1
sentinel auth-pass mymaster redispw"

echo "$SENTINEL_CONFIG" > ${PWD}/sentinel-0/sentinel.conf
echo "$SENTINEL_CONFIG" > ${PWD}/sentinel-1/sentinel.conf
echo "$SENTINEL_CONFIG" > ${PWD}/sentinel-2/sentinel.conf

docker run -d -p 55005:6379 --rm --name redis-0 --net redis -v ${PWD}/redis-0:/etc/redis/ redis:7.0-alpine redis-server /etc/redis/redis.conf
docker run -d -p 55006:6379 --rm --name redis-1 --net redis -v ${PWD}/redis-1:/etc/redis/ redis:7.0-alpine redis-server /etc/redis/redis.conf
docker run -d -p 55007:6379 --rm --name redis-2 --net redis -v ${PWD}/redis-2:/etc/redis/ redis:7.0-alpine redis-server /etc/redis/redis.conf

docker run -d --rm --name sentinel-0 --net redis -v ${PWD}/sentinel-0:/etc/redis/ redis:7.0-alpine redis-sentinel /etc/redis/sentinel.conf
docker run -d --rm --name sentinel-1 --net redis -v ${PWD}/sentinel-1:/etc/redis/ redis:7.0-alpine redis-sentinel /etc/redis/sentinel.conf
docker run -d --rm --name sentinel-2 --net redis -v ${PWD}/sentinel-2:/etc/redis/ redis:7.0-alpine redis-sentinel /etc/redis/sentinel.conf