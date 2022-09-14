# Block party search rest API
Block search party is implemented with the Rest Template and Web Client. For reference data set are coming from [Berlin.de](https://www.berlin.de/sen/web/service/maerkte-feste/wochen-troedelmaerkte/index.php/)

# Description about rest end point
1. For the Rest Template implementation -

   a. GET /party/query?id={id}
   
   b. POST /parties, body : {}
   
2. For the Web Client implementation -

   a. GET /client/party/query?id={id}
   
   b. POST /client/parties, body : {}
   
# API Test
Postman API test using postman and curl.sh script is added to run these request from the bash terminal. Both the files exists in the /src/test/resources folder.