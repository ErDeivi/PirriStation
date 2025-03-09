-- Backup de la base de datos pirristation
-- Fecha: Sun Mar 09 19:27:16 CET 2025

CREATE DATABASE IF NOT EXISTS `pirristation`;
USE `pirristation`;

-- Estructura de la tabla `bandasonora`
DROP TABLE IF EXISTS `bandasonora`;
CREATE TABLE `bandasonora` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Compositor` varchar(100) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Datos de la tabla `bandasonora`
INSERT INTO `bandasonora` VALUES (1,'The Legend of Zelda: Ocarina of Time Soundtrack','Koji Kondo','https://www.youtube.com/watch?v=Hy0aEj85ifY');
INSERT INTO `bandasonora` VALUES (2,'Final Fantasy VII Soundtrack','Nobuo Uematsu','https://www.youtube.com/watch?v=pCXV8HwB_Zo');
INSERT INTO `bandasonora` VALUES (3,'The Elder Scrolls V: Skyrim Soundtrack','Jeremy Soule','https://www.youtube.com/watch?v=aK_FuZMdwrU');
INSERT INTO `bandasonora` VALUES (4,'Halo: Combat Evolved Soundtrack','Martin O\\'Donnell, Michael Salvatori','https://www.youtube.com/watch?v=Z5yVOFokLVY');
INSERT INTO `bandasonora` VALUES (5,'Minecraft Soundtrack','C418','https://www.youtube.com/watch?v=Dg0IjOzopYU');
INSERT INTO `bandasonora` VALUES (6,'Undertale Soundtrack','Toby Fox','https://www.youtube.com/watch?v=ZcoqR9Bwx1Y');
INSERT INTO `bandasonora` VALUES (7,'Super Mario 64 Soundtrack','Koji Kondo','https://www.youtube.com/watch?v=gEY7-NUIk0E');
INSERT INTO `bandasonora` VALUES (8,'The Witcher 3: Wild Hunt Soundtrack','Marcin Przybyłowicz, Mikolai Stroinski','https://www.youtube.com/watch?v=z4pPZ5BwO-U');
INSERT INTO `bandasonora` VALUES (9,'Red Dead Redemption 2 Soundtrack','Woody Jackson','https://www.youtube.com/watch?v=m96d_0h8G6I');
INSERT INTO `bandasonora` VALUES (10,'Grand Theft Auto V Soundtrack','Various Artists','https://www.youtube.com/watch?v=qWlU3-JPe_U');


-- Estructura de la tabla `programador`
DROP TABLE IF EXISTS `programador`;
CREATE TABLE `programador` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Localidad` varchar(50) DEFAULT NULL,
  `Salario` decimal(10,2) DEFAULT NULL,
  `DNI` varchar(15) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `DNI` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- Datos de la tabla `programador`
INSERT INTO `programador` VALUES (1,'Ada','Lovelace','Londres',60000.00,'12345678A');
INSERT INTO `programador` VALUES (2,'Charles','Babbage','Londres',70000.00,'87654321B');
INSERT INTO `programador` VALUES (3,'Grace','Hopper','Nueva York',65000.00,'23456789C');
INSERT INTO `programador` VALUES (4,'Alan','Turing','Londres',75000.00,'98765432D');
INSERT INTO `programador` VALUES (5,'John','von Neumann','Budapest',80000.00,'34567890E');
INSERT INTO `programador` VALUES (6,'Linus','Torvalds','Helsinki',90000.00,'11223344F');
INSERT INTO `programador` VALUES (7,'Guido','van Rossum','Haarlem',85000.00,'55667788G');
INSERT INTO `programador` VALUES (8,'Bjarne','Stroustrup','Aarhus',88000.00,'99001122H');
INSERT INTO `programador` VALUES (9,'James','Gosling','Calgary',82000.00,'44556677I');
INSERT INTO `programador` VALUES (10,'Dennis','Ritchie','Nueva York',78000.00,'88990011J');


-- Estructura de la tabla `videojuego`
DROP TABLE IF EXISTS `videojuego`;
CREATE TABLE `videojuego` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Plataforma` varchar(50) DEFAULT NULL,
  `Género` varchar(50) DEFAULT NULL,
  `Publicado` date DEFAULT NULL,
  `Precio` decimal(10,2) DEFAULT NULL,
  `Ventas` int(11) DEFAULT NULL,
  `BandaSonoraID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_BandaSonora` (`BandaSonoraID`),
  CONSTRAINT `FK_BandaSonora` FOREIGN KEY (`BandaSonoraID`) REFERENCES `bandasonora` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Datos de la tabla `videojuego`
INSERT INTO `videojuego` VALUES (1,'The Legend of Zelda: Ocarina of Time','Nintendo 64','Action-Adventure','1998-11-21',59.99,7600000,1);
INSERT INTO `videojuego` VALUES (2,'Final Fantasy VII','PlayStation','RPG','1997-01-31',49.99,13250000,2);
INSERT INTO `videojuego` VALUES (3,'The Elder Scrolls V: Skyrim','PC, PlayStation 3, Xbox 360','Action RPG','2011-11-11',39.99,30000000,3);
INSERT INTO `videojuego` VALUES (4,'Halo: Combat Evolved','Xbox','First-Person Shooter','2001-11-15',29.99,8000000,4);
INSERT INTO `videojuego` VALUES (5,'Minecraft','Multiplataforma','Sandbox','2011-11-18',26.95,238000000,5);
INSERT INTO `videojuego` VALUES (6,'Undertale','PC, PlayStation 4, Nintendo Switch','RPG','2015-09-15',9.99,8000000,6);
INSERT INTO `videojuego` VALUES (7,'Super Mario 64','Nintendo 64','Platformer','1996-06-23',49.99,11900000,7);
INSERT INTO `videojuego` VALUES (8,'The Witcher 3: Wild Hunt','PC, PlayStation 4, Xbox One','Action RPG','2015-05-19',39.99,40000000,8);
INSERT INTO `videojuego` VALUES (9,'Red Dead Redemption 2','PlayStation 4, Xbox One, PC','Action-Adventure','2018-10-26',59.99,45000000,9);
INSERT INTO `videojuego` VALUES (10,'Grand Theft Auto V','Multiplataforma','Action-Adventure','2013-09-17',29.99,170000000,10);


-- Estructura de la tabla `videojuego-programador`
DROP TABLE IF EXISTS `videojuego-programador`;
CREATE TABLE `videojuego-programador` (
  `VideojuegoID` int(11) NOT NULL,
  `ProgramadorID` int(11) NOT NULL,
  `Fecha_Inicio` date DEFAULT NULL,
  `Fecha_Fin` date DEFAULT NULL,
  PRIMARY KEY (`VideojuegoID`,`ProgramadorID`),
  KEY `ProgramadorID` (`ProgramadorID`),
  CONSTRAINT `videojuego-programador_ibfk_1` FOREIGN KEY (`VideojuegoID`) REFERENCES `videojuego` (`ID`),
  CONSTRAINT `videojuego-programador_ibfk_2` FOREIGN KEY (`ProgramadorID`) REFERENCES `programador` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Datos de la tabla `videojuego-programador`
INSERT INTO `videojuego-programador` VALUES (1,1,'1997-01-01','1998-11-01');
INSERT INTO `videojuego-programador` VALUES (1,3,'1997-01-01','1998-11-01');
INSERT INTO `videojuego-programador` VALUES (2,2,'1996-03-01','1997-01-01');
INSERT INTO `videojuego-programador` VALUES (2,5,'1996-03-01','1997-01-01');
INSERT INTO `videojuego-programador` VALUES (3,4,'2010-05-01','2011-11-01');
INSERT INTO `videojuego-programador` VALUES (3,6,'2010-05-01','2011-11-01');
INSERT INTO `videojuego-programador` VALUES (4,1,'2000-01-01','2001-11-01');
INSERT INTO `videojuego-programador` VALUES (4,7,'2000-01-01','2001-11-01');
INSERT INTO `videojuego-programador` VALUES (5,8,'2009-05-17','2011-11-18');
INSERT INTO `videojuego-programador` VALUES (6,9,'2013-06-01','2015-09-15');
INSERT INTO `videojuego-programador` VALUES (7,3,'1995-01-01','1996-06-01');
INSERT INTO `videojuego-programador` VALUES (7,5,'1995-01-01','1996-06-01');
INSERT INTO `videojuego-programador` VALUES (8,2,'2013-02-01','2015-05-01');
INSERT INTO `videojuego-programador` VALUES (8,4,'2013-02-01','2015-05-01');
INSERT INTO `videojuego-programador` VALUES (8,6,'2013-02-01','2015-05-01');
INSERT INTO `videojuego-programador` VALUES (9,3,'2017-03-22','2019-03-15');
INSERT INTO `videojuego-programador` VALUES (9,7,'2016-04-01','2018-10-01');
INSERT INTO `videojuego-programador` VALUES (9,8,'2016-04-01','2018-10-01');
INSERT INTO `videojuego-programador` VALUES (9,10,'2016-04-01','2018-10-01');
INSERT INTO `videojuego-programador` VALUES (10,1,'2011-09-01','2013-09-01');
INSERT INTO `videojuego-programador` VALUES (10,5,'2011-09-01','2013-09-01');
INSERT INTO `videojuego-programador` VALUES (10,9,'2011-09-01','2013-09-01');

