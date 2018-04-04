#REST RegEx service

**_Travis CI Build Satus_**
[![Build Status](https://travis-ci.org/serhii-gbb/HelloCity.svg?branch=master)](https://travis-ci.org/serhii-gbb/HelloCity)

**Technology:** PostgreSQL, Spring (Boot, Data)

**Preparing steps:**

**1.** Install database(additional files located in resources dir.)

1.1 Use "user script" for creating user

1.2 Use "database script" for creating DB

1.3 Use "schema script" for creating schema, table with records


**Launch application:**

You can assemble app with maven and run JAR in the console

**console command:** java -jar hello-filter.jar

**browser URL:** http://localhost:8080/hello/contacts?nameFilter=^RegEx$