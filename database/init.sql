create database if not exists javafxTest;
use javafxTest;
create database if not exists javafxTest;
use javafxTest;
CREATE TABLE IF NOT EXISTS `user060_db1`.`Types` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `typeName` VARCHAR(20) NULL,
  PRIMARY KEY (`id`));



CREATE TABLE IF NOT EXISTS `user060_db1`.`Users` (
  `UserID` INT NOT NULL AUTO_INCREMENT,
  `fio` TEXT NOT NULL,
  `phone` VARCHAR(20) NULL,
  `login` VARCHAR(30) NOT NULL,
  `password` CHAR(5) NOT NULL,
  `typeID` INT NULL,
  PRIMARY KEY (`UserID`),
  CONSTRAINT `fk_Users_Types1`
    FOREIGN KEY (`typeID`)
    REFERENCES `user060_db1`.`Types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS `user060_db1`.`Tech` (
  `idTech` INT NOT NULL AUTO_INCREMENT,
  `techType` VARCHAR(30) NOT NULL,
  `techModel` VARCHAR(50) NULL,
  PRIMARY KEY (`idTech`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `user060_db1`.`Parts` (
  `idParts` INT NOT NULL AUTO_INCREMENT,
  `nameParts` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`idParts`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `user060_db1`.`Status` (
  `idStatus` INT NOT NULL AUTO_INCREMENT,
  `nameStatus` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idStatus`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `user060_db1`.`Request` (
  `requestID` INT NOT NULL AUTO_INCREMENT,
  `startDate` DATE NULL,
  `TechId` INT NOT NULL,
  `problemDescryption` VARCHAR(50) NULL,
  `completionDate` TINYTEXT NULL,
  `partsId` INT NULL,
  `masterID` INT NOT NULL,
  `clientID` INT NOT NULL,
  `requestStatus` INT NOT NULL,
  PRIMARY KEY (`requestID`),
  CONSTRAINT `fk_Request_Users`
    FOREIGN KEY (`masterID`)
    REFERENCES `user060_db1`.`Users` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Request_Tech1`
    FOREIGN KEY (`TechId`)
    REFERENCES `user060_db1`.`Tech` (`idTech`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Request_Parts1`
    FOREIGN KEY (`partsId`)
    REFERENCES `user060_db1`.`Parts` (`idParts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Request_Status1`
    FOREIGN KEY (`requestStatus`)
    REFERENCES `user060_db1`.`Status` (`idStatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Request_Users1`
    FOREIGN KEY (`clientID`)
    REFERENCES `user060_db1`.`Users` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `user060_db1`.`Comments` (
  `idComments` INT NOT NULL,
  `message` TEXT(100) NULL,
  `masterID` INT NULL,
  `requestID` INT NULL,
  PRIMARY KEY (`idComments`),
  CONSTRAINT `fk_Comments_Users1`
    FOREIGN KEY (`masterID`)
    REFERENCES `user060_db1`.`Users` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comments_Request1`
    FOREIGN KEY (`requestID`)
    REFERENCES `user060_db1`.`Request` (`requestID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
