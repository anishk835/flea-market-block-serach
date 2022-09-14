#!/bin/bash

set -e

function post_req_get_block_parties() {
  curl --location --request POST 'http://localhost:8080/parties' \
  --header 'Accept: application/json' \
  --header 'Content-Type: application/json' \
  --data-raw "$1"
}

function get_req_for_given_block_id() {
  curl --location --request GET "http://localhost:8080/client/party/query?id=$1"
}

