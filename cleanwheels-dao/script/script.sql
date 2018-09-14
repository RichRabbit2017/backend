-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cleanwheels
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cleanwheels
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cleanwheels` DEFAULT CHARACTER SET utf8 ;
USE `cleanwheels` ;

-- -----------------------------------------------------
-- Table `cleanwheels`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`user` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `mobile` INT NULL,
  `society` VARCHAR(45) NULL,
  `sector` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `flat_no` VARCHAR(45) NULL,
  `parking_no` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `cleanwheels`.`vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`vehicle` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `category` VARCHAR(45) NULL,
  `num` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vehicle_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_vehicle_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `cleanwheels`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cleanwheels`.`promotion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`promotion` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cleanwheels`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`location` (
  `id` INT NOT NULL,
  `city` VARCHAR(45) NULL,
  `society` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cleanwheels`.`promotion_location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`promotion_location` (
  `promotion_id` INT NOT NULL,
  `location_id` INT NOT NULL,
  INDEX `fk_promotion_location_promotion1_idx` (`promotion_id` ASC),
  INDEX `fk_promotion_location_location1_idx` (`location_id` ASC),
  CONSTRAINT `fk_promotion_location_promotion1`
    FOREIGN KEY (`promotion_id`)
    REFERENCES `cleanwheels`.`promotion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_promotion_location_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `cleanwheels`.`location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cleanwheels`.`package`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`package` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cleanwheels`.`package_location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`package_location` (
  `package_id` INT NOT NULL,
  `location_id` INT NOT NULL,
  INDEX `fk_package_location_package1_idx` (`package_id` ASC),
  INDEX `fk_package_location_location1_idx` (`location_id` ASC),
  CONSTRAINT `fk_package_location_package1`
    FOREIGN KEY (`package_id`)
    REFERENCES `cleanwheels`.`package` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_package_location_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `cleanwheels`.`location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cleanwheels`.`contractor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`contractor` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `mobile` INT NULL,
  `address` VARCHAR(45) NULL,
  `pan` VARCHAR(45) NULL,
  `bank_account` VARCHAR(45) NULL,
  `bank_ifsc` VARCHAR(45) NULL,
  `bank` VARCHAR(45) NULL,
  `alternate_mobile` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cleanwheels`.`cleaner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`cleaner` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `mobile` INT NULL,
  `address` VARCHAR(45) NULL,
  `alternate_mobile` INT NULL,
  `pan` VARCHAR(45) NULL,
  `adhaar` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cleanwheels`.`vehicle_cleaner_tx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`vehicle_cleaner_tx` (
  `id` INT NOT NULL,
  `vehicle_id` INT NOT NULL,
  `cleaner_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vehicle_cleaner_tx_vehicle1_idx` (`vehicle_id` ASC),
  INDEX `fk_vehicle_cleaner_tx_cleaner1_idx` (`cleaner_id` ASC),
  CONSTRAINT `fk_vehicle_cleaner_tx_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `cleanwheels`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicle_cleaner_tx_cleaner1`
    FOREIGN KEY (`cleaner_id`)
    REFERENCES `cleanwheels`.`cleaner` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `cleanwheels`.`location_contractor_tx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`location_contractor_tx` (
  `id` INT NOT NULL,
  `location_id` INT NOT NULL,
  `contractor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_location_contractor_tx_location1_idx` (`location_id` ASC),
  INDEX `fk_location_contractor_tx_contractor1_idx` (`contractor_id` ASC),
  CONSTRAINT `fk_location_contractor_tx_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `cleanwheels`.`location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_contractor_tx_contractor1`
    FOREIGN KEY (`contractor_id`)
    REFERENCES `cleanwheels`.`contractor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cleanwheels`.`inventory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`inventory` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `qty` INT NULL,
  `price` INT NULL,
  `dealer` VARCHAR(45) NULL,
  `dealer_address` VARCHAR(45) NULL,
  `dealer_mobile` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cleanwheels`.`cleaner_inventory_tx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`cleaner_inventory_tx` (
  `id` INT NOT NULL,
  `item_qty` INT NULL,
  `item_name` VARCHAR(45) NULL,
  `item_status` VARCHAR(45) NULL,
  `comments` VARCHAR(45) NULL,
  `cleaner_id` INT NOT NULL,
  `inventory_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cleaner_inventory_tx_cleaner1_idx` (`cleaner_id` ASC),
  INDEX `fk_cleaner_inventory_tx_inventory1_idx` (`inventory_id` ASC),
  CONSTRAINT `fk_cleaner_inventory_tx_cleaner1`
    FOREIGN KEY (`cleaner_id`)
    REFERENCES `cleanwheels`.`cleaner` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cleaner_inventory_tx_inventory1`
    FOREIGN KEY (`inventory_id`)
    REFERENCES `cleanwheels`.`inventory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cleanwheels`.`helpdesk`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cleanwheels`.`helpdesk` (
  `id` INT NOT NULL,
  `ticket_type` VARCHAR(45) NULL,
  `comment` VARCHAR(45) NULL,
  `resolution` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  `vehicle_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_helpdesk_user1_idx` (`user_id` ASC),
  INDEX `fk_helpdesk_vehicle1_idx` (`vehicle_id` ASC),
  CONSTRAINT `fk_helpdesk_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `cleanwheels`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_helpdesk_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `cleanwheels`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
