CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB

CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB

CREATE TABLE `genre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB

CREATE TABLE `film` (
  `id` varchar(124) NOT NULL,
  `name` varchar(100) NOT NULL,
  `genre_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `genre_id` (`genre_id`),
  CONSTRAINT `film_ibfk_1` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB

CREATE TABLE `student_course` (
  `student_id` varchar(100) NOT NULL,
  `course_id` int NOT NULL
) ENGINE=InnoDB

CREATE TABLE `student` (
  `id` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB
