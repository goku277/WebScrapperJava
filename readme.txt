The json output file is inside the Service package, along with the WebScrapperService class, it can be found.

In order to run this project, Postman can be used and the end point to fetch the scrapped data is "webscrapping/v1/receive/data/"

Running on port is "9090"

This end point should be referred to fetch the scrapped data, and on sending the GET API ACTION

through postman, the program will execute and the json file will be populated with the fetched data from this

url which was given in this assignment "https://www.house.gov/representatives"

jsoup, gson, postgresql have been used in this project.

Postgresql is used to store the scrapped data into the database.

Postman data are also attached here inside this project directory, so it can be imported into the postman.

Reference for this project is taken from "https://stackabuse.com/web-scraping-the-java-way/"