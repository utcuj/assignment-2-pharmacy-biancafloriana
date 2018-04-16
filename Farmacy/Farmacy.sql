DROP SCHEMA IF EXISTS `farmacy` ;
CREATE SCHEMA IF NOT EXISTS `farmacy`;

CREATE TABLE `farmacy`.`medication` (
  `id` INT NOT NULL auto_increment,
  `name` VARCHAR(45) NULL,
  `ingredients` VARCHAR(45) NULL,
  `manufacturer` VARCHAR(45) NULL,
  `quantity` INT NULL,
  `price` DECIMAL(5,2) NULL,
  PRIMARY KEY (`id`));
  
 CREATE TABLE `farmacy`.`employee` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`username`));
 