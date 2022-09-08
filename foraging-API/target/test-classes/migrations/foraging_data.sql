INSERT INTO forageditem (item_name, item_type, species_name)  VALUES('persimmon', 'fruit', 'Diospyros Virginiana');
INSERT INTO forageditem (item_name, item_type, species_name)  VALUES('morel', 'mushroom', 'Morchella Esculenta');
INSERT INTO forageditem (item_name, item_type, species_name)  VALUES('Oyster', 'mushroom', 'Pleurotus Ostereatus');
INSERT INTO forageditem (item_name, item_type, species_name)  VALUES('Nettles', 'herb', 'Dioica');
INSERT INTO forageditem (item_name, item_type, species_name)  VALUES('Deadly Nightshade', 'berry', 'Atropa belladonna');

INSERT INTO location (Country, Region, Season) VALUES('United States', 'Eastern and southern US', 'fall');
INSERT INTO location (Country, Region, Season) VALUES('United States', 'forests and wooded areas', 'spring');
INSERT INTO location (Country, Region, Season) VALUES('United States', 'forests and wooded areas', 'fall');
INSERT INTO location (Country, Region, Season) VALUES('United States', 'wide spread', 'spring');
INSERT INTO location (Country, Region, Season) VALUES('United States', 'Northeast and the Pacific Northwest', 'summer');

INSERT INTO reviews (item_ID, description, edibility, availability) VALUES(1, 'small round fruit that Is orange or red with crisp skin and soft sweet flesh', 'yes', 'plentiful does not affect tree');
INSERT INTO reviews (item_ID, description, edibility, availability) VALUES(2, 'identifiers include the narrow wrinkled pitted caps and hollow stems', 'yes', 'smaller patches that are hard to find' );
INSERT INTO reviews (item_ID, description, edibility, availability) VALUES(3, 'broad thin oyster or fan shaped caps that are white gray or tan found on dead trees', 'yes', 'one of the easier mushrooms to find');
INSERT INTO reviews (item_ID, description, edibility, availability) VALUES(4, 'upright plant with one central shoot and numerous side branches with white flowers and jagged edged leaves', 'edible once cooked', 'fast growing and plentiful');
INSERT INTO reviews (item_ID, description, edibility, availability) VALUES(5, 'not native to the states more prevalent in Europe has oval shaped leaves with a shiny black berry when ripe', 'this variety is poisonous', 'plentiful in select regions');

