# Block party search rest API
Block search party is implemented with the Rest Template and Web Client. For reference data set are coming from [Berlin.de](https://www.berlin.de/sen/web/service/maerkte-feste/wochen-troedelmaerkte/index.php/)

# Scope
Supported formats are :
1. Json - it is suppored for both items and each item details
2. GeoJson - only supported for items, because the thirdparty endpoint is broken. It doesn't return any response. e.g id = [363](https://www.berlin.de/sen/web/service/maerkte-feste/wochen-troedelmaerkte/index.php/detail/363.geojson)

# Configuration
Config file contains all the necessary [properties](/src/main/resources/application.properties).

# Description about rest end point
1. For the Rest Template implementation with caching mechanism using redis cache -

   a. GET /party/query?id={id}
   
   b. POST /parties, body : {}
   
2. For the Web Client implementation -

   a. GET /client/party/query?id={id}
   
   b. POST /client/parties, body : {}
   
   c. POST /client/parties/geolocation, body : {}
   
   **NOTE:** Body of the post request (if sort order is given in the request body then it must contain type and order both)
   
   ```json
   {
       "searchKeyWord": "",
       "district": "",
       "resultPerPage": 10,
       "sortOrder": {
           "type": "",
           "order": ""
       }
   }
   ```
   Supported type and order are in German -
   ```
   type : bezirk, plz, tage
   order : ASC, DESC
   ```
   
# API Test
Postman API test using postman and curl.sh script is added to run these request from the bash terminal. Both the files exists in the /src/test/resources folder.
