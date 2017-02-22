-- set the schema
--use tnt_utilities;

-- Inventory table
create table `Inventory` (
  `id` int not null auto_increment,
  `buy_date` date,
  `assigned_to_id` int not null,
  `renting` tinyint(1) not null default 0 comment 'Do renting (1) or no (0)',
  `cost` decimal(10,2),
  `amortizable` tinyint(1) not null default 0 comment 'Amortizable (1) o no (0)consumible',
  `serial_number` varchar(30) not null,
  `type` varchar(16) not null,
  `provider` varchar(128),
  `trademark` varchar(128),
  `model` varchar(128),
  `speed` varchar(10),
  `storage` varchar(10),
  `ram` varchar(10),
  `location` varchar(128),
  `description` varchar(256),
  `owner_id` int,
  `department_id` int,
  `insert_date` date, 
  `update_date` date,
  primary key (`id`),
  index `ndx_invetory_userId` (`assigned_to_id`)
  ) engine=innodb default charset=utf8 comment='Inventory';

  
-- Book table
CREATE TABLE  `Book` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `author` varchar(255) default NULL,
  `ISBN` varchar(13) default NULL,
  `URL` varchar(255) default NULL,
  `price` decimal(10,2) default NULL,
  `purchase_date` datetime default NULL,
  `user_id` int default NULL,
  `owner_id` int,
  `department_id` int,
  `insert_date` date, 
  `update_date` date,
  PRIMARY KEY  (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;