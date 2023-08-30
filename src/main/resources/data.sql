create schema meal;

CREATE TABLE `meal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `meal`.`meal` ( `description`, `name`, `price`)
VALUES
('Eba is made from Gari', 'Eba', 29.99),
('Jollof originated from China', 'Jollof', 59.99),
('Suya is the best thing to ever exists', 'Suya', 19.99),
('How can you say no to Egusi', 'Egusi', 29.99);