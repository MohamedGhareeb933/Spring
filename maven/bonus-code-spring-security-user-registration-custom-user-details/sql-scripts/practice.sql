CREATE SCHEMA IF NOT EXISTS `spring_security_custom_user_demo`;

USE `spring_security_custom_user_demo`;

CREATE TABLE IF NOT EXISTS `user` (
	`id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` varchar(50) NOT NULL , 
    `password` varchar(80) NOT NULL,
    `first_name` varchar(50) NOT NULL,
    `last_name` varchar(50) NOT NULL,
    `email` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `role`(
	`id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS`users_roles`(
	`user_id` int(11) NOT NULL,
    `role_id` int(11) NOT NULL,
    PRIMARY KEY(`user_id`, `role_id`),
    
    FOREIGN KEY(`user_id`) REFERENCES `users`(`id`)
    ON UPDATE NO ACTION ON DELETE NO ACTION,
    
    FOREIGN KEY(`role_id`) REFERENCES `role`(`id`)
    ON UPDATE NO ACTION ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;