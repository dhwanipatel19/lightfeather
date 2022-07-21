# Overview
LightFeather Management System compiled into a functional docker image or standalone gradle project.

# Download the repo as standalone folder in zip file and unzip it

# Running locally with gradle
```
./gradle build or ./gradlew clean build
```
```
./gradle bootRun or ./gradlew bootRun
```
If you have trouble with gradlew make sure the permission for gradlew is set up correct
```
sudo chmod 755 gradlew
sudo chmod 755 gradle
```

# Running with docker-compose
As using openjdk-11, it is slower for the firsttime
```
docker-compose build
```
As using compilation for running, it's slower to get it running
```
docker-compose up
```
When you are done testing, stop the server and remove the container.
```
docker rm -f lightfeather-managementsystem
```

# Utilizing endpoints from project
1. Go to url: http://localhost:8080/api/supervisors - to list all supervisors with Non-numeric jurisdictions in order of jurisdiction, lastname and firstname with format "jurisdiction - lastName, firstName"

2. From command line run below command and watch the tomcat log to see the printing of payload
```
curl -i -H "Accept: application/json" -H "Content-Type:application/json" -X POST --data  '{"firstName": "Dhwani", "lastName": "Patel", "supervisor": "Eliza Arias", "email": "eliza.arias@lightfeathers.com", "phoneNumber": 7708739509}' "localhost:8080/api/submit"
```

