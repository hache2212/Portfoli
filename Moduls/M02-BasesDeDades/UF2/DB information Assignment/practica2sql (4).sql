DROP DATABASE IF EXISTS league_teams;
CREATE DATABASE IF NOT EXISTS league_teams;
USE	league_teams;

SHOW TABLES;

CREATE TABLE IF NOT EXISTS agent(
	id_agent INT(4) NOT NULL AUTO_INCREMENT,
	name_agent VARCHAR(20),
    surname VARCHAR(40),
    PRIMARY KEY(id_agent)
);


CREATE TABLE IF NOT EXISTS stadium(
	id_stadium INT(4) NOT NULL AUTO_INCREMENT,
	name_stadium VARCHAR(30),
    city VARCHAR(20),
    country VARCHAR(15),
    capacity INT(7),
    year_of_creation INT (4),
    CONSTRAINT uk_stadium UNIQUE(name_stadium),
    PRIMARY KEY(id_stadium)
);

CREATE TABLE IF NOT EXISTS club(
	id_club INT (4) NOT NULL AUTO_INCREMENT,
	name_club VARCHAR(40),
    country VARCHAR(20),
    city VARCHAR(15),
    awards INT(3) DEFAULT(0),
    stadium_id INT(4),
    date_of_creation DATE,
    position_in_league TINYINT,
    PRIMARY KEY (id_club),
    CONSTRAINT uk_club UNIQUE(name_club),
	CONSTRAINT fk_club_stadium FOREIGN KEY(stadium_id) REFERENCES stadium(id_stadium)
);

CREATE TABLE IF NOT EXISTS president(
	id_president INT(4) NOT NULL AUTO_INCREMENT,
	name_president VARCHAR(20),
    surname VARCHAR(40),
    club_name VARCHAR(40),
    experience INT (2),
    club_id INT(5),
    CONSTRAINT ck_president CHECK (experience>=4),
    PRIMARY KEY(id_president),
    CONSTRAINT fk_president_club FOREIGN KEY(club_id) REFERENCES club(id_club)
);

CREATE TABLE IF NOT EXISTS sports_director(
	id_sports_director INT(4) NOT NULL AUTO_INCREMENT,
	name_sports_director VARCHAR(20),
    surname VARCHAR(40),
    years_in_club INT(2),
    president_id INT(4),
    experience INT(2),
    CONSTRAINT ck_sports_director CHECK (experience>=4),
    PRIMARY KEY(id_sports_director),
    CONSTRAINT fk_sports_director_president FOREIGN KEY(president_id) REFERENCES president(id_president)
);

CREATE TABLE IF NOT EXISTS coach(
	id_coach INT(4) NOT NULL,
	name_coach VARCHAR(40),
    surname VARCHAR(40),
    club VARCHAR(40),
    sports_director_id INT(4) NULL,
    PRIMARY KEY(id_coach),
    CONSTRAINT fk_coach_sports_director FOREIGN KEY(sports_director_id) REFERENCES sports_director(id_sports_director)
);

CREATE TABLE IF NOT EXISTS player(
	id_player INT(4) NOT NULL AUTO_INCREMENT,
	name_player VARCHAR(40),
    country VARCHAR(20),
    age INT(2),
    position VARCHAR(20),
    name_club VARCHAR(40),
    club_id INT(4),
    coach_id INT(4),
    sports_director_id INT(4),
    agent_id INT(4) NULL,
    id_captain INT(4),
    PRIMARY KEY(id_player),
    CONSTRAINT ck_player CHECK (age>=16),
    CONSTRAINT fk_player_sports_director FOREIGN KEY(sports_director_id) REFERENCES sports_director(id_sports_director),
	CONSTRAINT fk_player_agent FOREIGN KEY(agent_id) REFERENCES agent(id_agent),
    CONSTRAINT fk_player_club FOREIGN KEY(club_id) REFERENCES club(id_club),
    CONSTRAINT fk_player_coach FOREIGN KEY(coach_id) REFERENCES coach(id_coach)
);

ALTER TABLE player
  DROP COLUMN id_captain;
  
  
ALTER TABLE club
	DROP COLUMN position_in_league;
  
  
SHOW INDEX FROM player;
CREATE INDEX info_league_player ON player (name_player);
SHOW INDEX FROM player;

SHOW INDEX FROM coach;
CREATE INDEX info_league_coach ON coach (name_coach);
SHOW INDEX FROM coach;

SHOW INDEX FROM president;
CREATE INDEX info_league_president ON president (name_president,surname);
SHOW INDEX FROM president;

SHOW INDEX FROM club;

SHOW INDEX FROM stadium;
ALTER TABLE stadium ADD INDEX info_league_stadium (country,city);
SHOW INDEX FROM stadium;

SHOW INDEX FROM agent;
ALTER TABLE agent ADD INDEX info_league_agent (name_agent,surname);
SHOW INDEX FROM agent;


INSERT INTO coach VALUES (100,'Xavi','Hernandez','FC Barcelona',NULL);
INSERT INTO coach VALUES (101,'Mikel','Arteta','Arsenal FC',NULL);
INSERT INTO coach VALUES (102,'JÃ¼rgen', 'Klopp','Liverpool FC',NULL);
INSERT INTO coach VALUES (103,'Graham', 'Potter','Chelsea FC',NULL);
INSERT INTO coach VALUES (104,'Alessandro', 'Allegri','Juventus FC',NULL);
INSERT INTO coach VALUES (105,'Cristophe', 'Gautier','Paris-Saint-Germain FC',NULL);
INSERT INTO coach VALUES (106,'Julian','Nagelsmann','Bayern Munchen',NULL);
INSERT INTO coach VALUES (107,'Stefano','Pioli','AC Milan',NULL);
INSERT INTO coach VALUES (108,'Simone','Inazghi','Internazionale Milano',NULL);
INSERT INTO coach VALUES (109,'Erik','Ten Haag','Manchester United',NULL);
INSERT INTO coach VALUES (110,'Edin','Terzic','Borussia Dortmund',NULL);
INSERT INTO coach VALUES (111,'Diego','Simeone','Atletico De Madrid',NULL);
INSERT INTO coach VALUES (112,'Pep','Guardiola','Manchester City',NULL);


INSERT INTO agent VALUES (1,'Jorge','Messi');
INSERT INTO agent VALUES (2,'Wagner','Ribeiro');
INSERT INTO agent VALUES (3,'Bakary','Cisse');
INSERT INTO agent VALUES (4,'Fayza','Lamari');
INSERT INTO agent VALUES (5,'Eugenio','Botas');
INSERT INTO agent VALUES (6,'Ramy','Aba Sissa');
INSERT INTO agent VALUES (7,'Abdelkarim','Douis');
INSERT INTO agent VALUES (8,'Donato','Di Campli');
INSERT INTO agent VALUES (9,'Pini','Zahavi');
INSERT INTO agent VALUES (10,'Federico','Pastorello');
INSERT INTO agent VALUES (11,'Jorge','Mendes');
INSERT INTO agent VALUES (12,'Rafaela','Pimienta');
INSERT INTO agent VALUES (13,'Paulo','Tonietto');    
INSERT INTO agent VALUES (14,'Giuliano','Bertolucci');
INSERT INTO agent VALUES (15,'Edmundo','Kabchi');
INSERT INTO agent VALUES (16,'Thassilo','Soares');
INSERT INTO agent VALUES (17,'Hector','Peris');



INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('Parc des Princes','Paris','France',47929,1972);
INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('Camp Nou','Barcelona','Spain',99354,1957);
INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('Santiago Bernabeu','Madrid','Spain',81044,1947);
INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('Etihad Stadium','Manchester','United Kingdom',55097,2002);
INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('Civitas Metropolitano','Madrid','Spain',68456,2017);
INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('Emirates Stadium','London','United Kingdom',60260,2006);
INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('Anfield','Liverpool','United Kingdom',53390,1884);
INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('Stamford Bridge','London','United Kingdom',41837,1877);
INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('Allianz Stadium Juventus','Torino','Italy',41507,2011);
INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('Allianz Arena','Munchen','Germany',75024,2005);
INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('San Siro','Milan','Italy',80018,1926);
INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('Giuseppe Meazza','Milan','Italy',80018,1926);
INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('Old Trafford','Manchester','United Kingdom',74310,1910);
INSERT INTO stadium (name_stadium,city,country,capacity,year_of_creation) VALUES ('Signal Iduna Park','Dortmund','Germany',81365,1974);


INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('FC Barcelona','Barcelona','Spain',2,'1899-11-29');
INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('Real Madrid','Madrid','Spain',3,'1902-03-06');
INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('Manchester City','Manchester','United Kingdom',4,'1880-04-16');
INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('Atletico De Madrid','Madrid','Spain',5,'1903-04-26');
INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('Arsenal FC','London','United Kingdom',6,'1886-10-11');
INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('Liverpool FC','Liverpool','United Kingdom',7,'1892-03-15');
INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('Chelsea FC','London','United Kingdom',8,'1905-03-10');
INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('Juventus FC','Torino','Italy',9,'1897-11-01');
INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('Paris-Saint-Germain FC','Paris','France',1,'1970-08-12');
INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('Bayern Munchen','Munich','Germany',10,'1900-02-27');
INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('AC Milan','Milan','Italy',11,'1899-12-16');
INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('Internazionale Milano','Milan','Italy',12,'1908-03-09');
INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('Manchester United','Manchester','United Kingdom',13,'1878-03-05');
INSERT INTO club(name_club,city,country,stadium_id,date_of_creation) VALUES ('Borussia Dortmund','Dortmund','Germany',14,'1909-12-19');

INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Joan','Laporta','FC Barcelona',1);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Florentino','Perez','Real Madrid',2);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Khaldoon','Al Mubarak','Manchester City',3);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Enrique','Cerezo','Atletico De Madrid',4);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Vinai','Venkatesham','Arsenal FC',5);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Tom','Werner','Liverpool FC',6);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Todd','Boehly','Chelsea FC',7);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Andrea','Agnelly','Juventus FC',8);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Nasser','Al-Khelaifi','Paris-Saint-Germain FC',9);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Herbert','Hainer','Bayern Munchen',10);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Paolo','Scaroni','AC Milan',11);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Steven','Zhang','Internazionale Milano',12);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Joel','Glazer','Manchester United',13);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Avram','Glazer','Manchester United',13);
INSERT INTO president (name_president,surname,club_name,club_id) VALUES ('Reinhold','Lunow','Borussia Dortmund',14);

INSERT INTO sports_director (name_sports_director,surname,years_in_club,president_id,experience) VALUES ('Mateu','Alemany',4,1,12);
INSERT INTO sports_director (name_sports_director,surname,years_in_club,president_id,experience) VALUES ('Jose Angel','Sannchez',5,2,9);
INSERT INTO sports_director (name_sports_director,surname,years_in_club,president_id,experience) VALUES ('Txiki','Begiristain',8,3,15);
INSERT INTO sports_director (name_sports_director,surname,years_in_club,president_id,experience) VALUES ('Andrea ','Berta',6,4,8);
INSERT INTO sports_director (name_sports_director,surname,years_in_club,president_id,experience) VALUES ('Edu','Gaspar',2,5,4);
INSERT INTO sports_director (name_sports_director,surname,years_in_club,president_id,experience) VALUES ('Julian','Ward',1,6,5);
INSERT INTO sports_director (name_sports_director,surname,years_in_club,president_id,experience) VALUES ('Christopher','Vivell',6,7,10);
INSERT INTO sports_director (name_sports_director,surname,years_in_club,president_id,experience) VALUES ('Luis','Campos',3,9,4);
INSERT INTO sports_director (name_sports_director,surname,years_in_club,president_id,experience) VALUES ('Hasan','SalihamidÅ¾iÄ‡',5,10,8);
INSERT INTO sports_director (name_sports_director,surname,years_in_club,president_id,experience) VALUES ('Frederic','Massara',3,11,18);
INSERT INTO sports_director (name_sports_director,surname,years_in_club,president_id,experience) VALUES ('Piero','Auselio',9,12,20);
INSERT INTO sports_director (name_sports_director,surname,years_in_club,president_id,experience) VALUES ('John','Murtough',2,13,6);
INSERT INTO sports_director (name_sports_director,surname,years_in_club,president_id,experience) VALUES ('Sebastian','Kehl',1,14,17);

INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Leo Messi','Argentina',35,'Paris Saint-Germain',9,'Forward',1,105);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Neymar','Brazil',30,'Paris Saint-Germain',9,'Forward',2,105);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES('Sadio Mane','Senegal',30,'Bayern Munchen',10,'Forward',3,106);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES('Kylian Mbappe','France',24,'Paris Saint-Germain',9,'Forward',4,105);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Pierre-Emerick Aubameyang','Gabon',33,'Chelsea FC',7,'Forward',5,103);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Mohamed Salah','Egypt',30,'Liverpool',6,'Forward',6,102);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Ngolo Kante','France',30,'Chelsea FC',7,'Midfielder',7,103);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Marco Verratti','Italy',30,'Paris-Saint-Germain',9,'Midfielder',8,105);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Robert Lewandowski','Poland',34,'FC Barcelona',1,'Forward',9,100);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Zlatan Ibrahimovic','Sweden',41,'AC Milan',11,'Forward',NULL,107);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Romelu Lukaku','Belgium',29,'Internazionale Milano',12,'Forward',10,108);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Bruno Fernandes','Portugal',28,'Manchester United',13,'Midfielder',11,109);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Erling Braut Haaland','Norway',22,'Manchester City',3,'Forward',12,112);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Virgil Van Dijk','Netherlands',31,'Liverpool',6,'Defender',NULL,102);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Thiago Silva','Brazil',38,'Chelsea',7,'Defender',13,103);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Leonardo Bonucci','Italy',35,'Juventus',8,'Defender',NULL,104);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Marquinhos','Brazil',29,'Paris-Saint-Germain',9,'Defender',14,105);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Araujo','Uruguay',23,'FC Barcelona',1,'Defender',15,100);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Vinicius Jr','Brazil',23,'Real Madrid',2,'Forward',16,101);
INSERT INTO player (name_player,country,age,name_club,club_id,position,agent_id,coach_id) VALUES ('Pedri','Spain',20,'FC Barcelona',1,'Midfielder',17,100);


UPDATE president SET experience = 15 WHERE club_id = 1;
UPDATE president SET experience = 10 WHERE club_id = 2;
UPDATE president SET experience = 8 WHERE club_id = 3;
UPDATE president SET experience = 6 WHERE club_id = 4;
UPDATE president SET experience = 5 WHERE club_id = 5;
UPDATE president SET experience = 4 WHERE club_id = 6;
UPDATE president SET experience = 7 WHERE club_id = 7;
UPDATE president SET experience = 12 WHERE club_id = 8;
UPDATE president SET experience = 9 WHERE club_id = 9;
UPDATE president SET experience = 14 WHERE club_id = 10;
UPDATE president SET experience = 11 WHERE club_id = 11;
UPDATE president SET experience = 4 WHERE club_id = 12;
UPDATE president SET experience = 5 WHERE club_id = 13;
UPDATE president SET experience = 5 WHERE club_id = 14;

DELETE FROM coach WHERE sports_director_id;


SELECT name_player, country, age, name_club
FROM player
WHERE agent_id IS NULL AND coach_id='107';

SELECT name_player, country, age, name_club
FROM player
WHERE coach_id LIKE '105%';

SELECT name_player, country, age, name_club, position
FROM player
WHERE age BETWEEN 30 AND 35;

SELECT * FROM player WHERE name_player LIKE '%a%' AND age < 30;

SELECT AVG(age)
FROM player
WHERE club_id = 1 AND (position = 'Forward' OR position = 'Midfielder');

SELECT SUM(capacity)
FROM stadium
WHERE country = 'Italy';

SELECT DISTINCT name_club, TRUNCATE(AVG(age), 0) as average_age
FROM player
WHERE age >= 25
GROUP BY name_club
ORDER BY average_age DESC;

SELECT * 
FROM player
WHERE MOD(id_player, 2) = 1;

SELECT name_player, position, name_club
FROM player
WHERE name_player LIKE 'L%' AND position = 'Forward' AND age >= 25;

SELECT name_player, position, name_club
FROM player
WHERE name_player REGEXP '^[A-Za-z]' AND SUBSTR(id_player,1,1) NOT REGEXP '[A-Za-z]';

SELECT * FROM club
WHERE date_of_creation >= '1900-01-01'
AND date_of_creation < '1910-01-01'
ORDER BY date_of_creation;