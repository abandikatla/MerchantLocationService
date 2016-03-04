# MerchantLocationService

You are given a dataset containing Merchant IDs and their corresponding addresses. 
Expose an API which takes a location name and a range as input parameters and returns the merchant ids which are located in that range. 

Softwares Used :
jdk 7
apache cxf
maven

The merchants data is provided as a csv file. The location of the file is provided in src/main/resources/config.properties

To run : Run the Server class in this project which starts the server.


Example :
URL : http://localhost:9011/merchants
Request Payload : { "query" :{"locationName": "Rajouri Garden", "range": 10 }}
Request Headers :
  Content-Type: application/json
  Accept: application/json

Response :
{"response":
  {"merchantIds":[2014018263,2015020606,2015020607,2015023228,2015023534,2015022707,2015022710,2014016412,2015022707,2015022710,2014016412,2015023166,2015023172,2014013468,2015022707,2015022710,2014012180,2015017496,2015023166,2015023172,2015019939,2015023522,2015023522,2011002889,2015015992,2015016090,2015016093,2011041292,2011002417,2013026806,2010027699,2011007563,2013022937,2013018642,2013025571,2013025572,2011001545,2013019696,2013017196,2013021326,2012000766,2010001374]}
}


