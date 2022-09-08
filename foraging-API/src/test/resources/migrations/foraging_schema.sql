DROP TABLE IF EXISTS foragedItemLocation;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS foragedItem;


CREATE TABLE foragedItem(
item_ID int NOT NULL AUTO_INCREMENT,
item_name VARCHAR(50), 
item_type VARCHAR(50),
species_name VARCHAR(50),
PRIMARY KEY(item_id)
);

CREATE TABLE reviews(
review_ID INT NOT NULL AUTO_INCREMENT,
item_ID INT,
description VARCHAR(150),
edibility VARCHAR(50),
availability VARCHAR(50),
PRIMARY KEY(review_ID),
FOREIGN KEY(item_ID) REFERENCES foragedItem(item_ID) 
);

CREATE TABLE location(
Location_ID INT NOT NULL AUTO_INCREMENT,
Country varchar(50),
Region varchar(50),
Season VARCHAR(10),
PRIMARY KEY(location_ID)
);

CREATE TABLE foragedItemLocation(
item_ID INT NOT NULL,
location_ID INT NOT NULL,
PRIMARY KEY (item_ID, location_ID),
FOREIGN KEY(item_ID) REFERENCES foragedItem(item_ID),
FOREIGN KEY(location_ID) REFERENCES location(location_ID)

);
