# WILDLIFE TRACKER


  This a website application where Rangers can track the animals in an area.

## Versioning

 Wildlife Tracker-V1.0 

## Author

* **Melissa Kobia**

## Features

As a user of the application you will be able to:

1. Add an endangered animal. 
2. Add a non-endangered animal.
3. Adds a sighting.


## Behaviour Driven Development (BDD)
| Behaviour       | Input               | Output              |
| --------------- |:-------------------:| ------------------: |
| Page Loads      | click add endangered animal button   | Endangered Animal form         |
|Clicks submit   | User enters input in form| Displays saved endangered animals   |
| Page Loads      | click add non-endangered animal button    | Non-Endangered Animal form     |
| Clicks submit   | User enters input in form| Displays saved non-endangered animals   |




### Installing

*** To view the app.Visit ->  https://pacific-crag-25979.herokuapp.com/
* Step 1:
Clone this repo: git clone https://github.com/melissakobia/Wildlife-tracker.git
* Step 2:
The repo comes in a zipped or compressed format. Extract to your preferred location and open it.
* Step 3:
open your terminal and navigate to Wildlife-tracker directory.
* Step 4:
Ensure you have imported the necessary dependencies in your build.gradle
* Step 5
To create the necessary databases, launch postgres, then psql, and run the following commands:

* `CREATE DATABASE wildlife_tracker;`
* `\c wildlife_tracker;`
* `CREATE TABLE animals (id serial PRIMARY KEY, name varchar, age varchar,health varchar, type varchar);`
* `CREATE TABLE sightings(id serial PRIMARY KEY, animalId int, location varchar, rangerName varchar, sightingDate timestamp);`
* `CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;`
 
* Step 5
Run your app with -gradle run command on your terminal.
    
## Built With

* Java - For all the logic and functionality
* Spark Web Framework


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENCE.md)  file for details.

## Acknowledgments
This project was created by Melissa Kobia. An upcoming developer.