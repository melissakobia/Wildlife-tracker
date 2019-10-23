CREATE DATABASE wildlife_tracker;
\c wildlife_tracker;
CREATE TABLE animals (id serial PRIMARY KEY, name varchar, age varchar, type varchar);
CREATE TABLE sightings(id serial PRIMARY KEY, animalId int, location varchar, rangerName varchar, sightingDate timestamp);
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;