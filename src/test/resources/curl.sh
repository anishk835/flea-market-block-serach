#!/bin/bash

set -e

echo -e "USAGES: \nProvide post url to get all the flea market result with body
      e.g. 
      http://localhost:8080/parties (Rest Template) body {} 
      http://localhost:8080/client/parties (Web Client) body {}
      
      To get info by ID example :
      http://localhost:8080/party/query?id=321 (Rest Template)
      http://localhost:8080/client/party/query?id=321 (Web Client).
      
      Order of passing parameter is
      1. Url for all Flea market result
      2. Reuqest body
      3. Url to fetch info for a given ID";
      
URL_GET_ALL="$1"
BODY="$2"
URL_GET_BY_ID="$3"


function _post_req_get_block_parties() {
  curl --location --request POST "$1" \
  --header 'Accept: application/json' \
  --header 'Content-Type: application/json' \
  --data-raw "$2"
}

function _get_req_for_given_block_id() {
  curl --location --request GET "$1"
}

if [ -z "$URL_GET_ALL" ] || [ -z "$BODY" ] || [ "$URL_GET_ALL" == "null" ] || [ "$BODY" == "null" ]; then 
  echo -e "\nMissing base url and body";
else
  echo -e "\nRun request to get all the flea market result for given request body: $BODY";
  _post_req_get_block_parties "$URL_GET_ALL" "$BODY"
  echo -e "\nFinished all result request...."
fi

if [ -z "$URL_GET_BY_ID" ] || [ "$URL_GET_BY_ID" == "null" ]; then
  echo -e "\nUrl to get information for a given ID is null";
else
  echo "Run request to get flea market result by ID: $URL_GET_BY_ID";
  _get_req_for_given_block_id "$URL_GET_BY_ID"
  echo -e "\nFinished request for a given ID...."
fi
