CREATE SCHEMA IF NOT EXISTS `inheritance`;

USE `inheritance`;

CREATE TABLE IF NOT EXISTS `notification` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `create_time` DATETIME DEFAULT NULL,
    `first_name` VARCHAR(255) DEFAULT NULL,
    `last_name` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY(`id`)
)Engine=InnoDB Auto_increment=1 charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `sms_notification` (
    `phone_number` VARCHAR(255) NOT NULL,
    `notification_id` BIGINT DEFAULT NULL, 
    PRIMARY KEY(`phone_number`),
    CONSTRAINT `fk_notification_sms` FOREIGN KEY (`notification_id`) REFERENCES `notification`(`id`)
)Engine=InnoDB Auto_increment=1 charset=utf8mb4 collate=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `email_notification` (
    `email` VARCHAR(255) NOT NULL,
    `notification_id` BIGINT DEFAULT NULL, 
    PRIMARY KEY(`email`),
    CONSTRAINT `fk_notification_email` FOREIGN KEY (`notification_id`) REFERENCES `notification`(`id`)
)Engine=InnoDB Auto_increment=1 charset=utf8mb4 collate=utf8mb4_0900_ai_ci;

