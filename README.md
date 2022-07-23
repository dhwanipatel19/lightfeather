# Overview
LightFeather Management System compiled into a functional docker image using express.js

# Download the repo as standalone folder in zip file and unzip it

# Running with docker-compose
```
docker-compose build
```
```
docker-compose up
```
When you are done testing, stop the server and remove the container.
```
docker rm -f lightfeather_express_lightfeather-managementsystem-express_1
```

# Utilizing endpoints from project
1. Go to url: http://localhost:3000/api/supervisors - to list all supervisors with Non-numeric jurisdictions in order of jurisdiction, lastname and firstname with format "jurisdiction - lastName, firstName"

2. From command line run below command and watch the tomcat log to see the printing of payload
```
curl -i -H "Accept: application/json" -H "Content-Type:application/json" -X POST --data  '{"firstName": "Dhwani", "lastName": "Patel", "supervisor": "Eliza Arias", "email": "eliza.arias@lightfeathers.com", "phoneNumber": 7708739509}' "localhost:3000/api/submit"
```

