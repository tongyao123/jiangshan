drop TABLE if exists `group`;
CREATE TABLE `group` (
  `group_id` char(32) NOT NULL,
  `group_no` varchar(32) DEFAULT NULL,
  `group_name` varchar(64) DEFAULT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
);

drop TABLE if exists `device`;
CREATE TABLE `device` (
  `device_id` char(32) NOT NULL,
  `device_serial` varchar(16) DEFAULT NULL,
  `device_model` varchar(64) DEFAULT NULL,
  `device_status` varchar(16) DEFAULT NULL,
  `device_name` varchar(64) DEFAULT NULL,
  `validate_code` varchar(32) DEFAULT NULL,
  `group_id` char(32) NOT NULL,
  `create_time` datetime DEFAULT NUll,
  PRIMARY KEY (`device_id`)
);
drop TABLE if exists device_channel;
CREATE TABLE `device_channel` (
  `channel_id` char(32) NOT NULL,
  `channel_name` varchar(128) DEFAULT NULL,
  `channel_type` varchar(16) DEFAULT NULL,
  `channel_no` int(11) DEFAULT NULL,
  `channel_status` varchar(16) DEFAULT NULL,
  `device_serial` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`channel_id`)
);

drop TABLE if exists person;
CREATE TABLE `person` (
  `id` char(32) NOT NULL,
  `employee_no` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `face_url` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
);

drop TABLE if exists person_card;
CREATE TABLE `person_card` (
  `id` char(32) NOT NULL,
  `person_id` char(32) NOT NULL,
  `employee_no` varchar(32) NOT NULL,
  `card_no` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
);

drop TABLE if exists access_permission_group;
CREATE TABLE `access_permission_group` (
  `id` char(32) NOT NULL,
  `hik_permission_group_id` char(32) NOT NULL DEFAULT '',
  `permission_group_name` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);

drop TABLE if exists device_permission_group_rel;
CREATE TABLE `device_permission_group_rel` (
  `id` char(32) NOT NULL,
  `permission_group_id` varchar(32) NOT NULL DEFAULT '',
  `device_serial` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);

drop TABLE if exists person_permission_group_rel;
CREATE TABLE `person_permission_group_rel` (
  `id` char(32) NOT NULL,
  `permission_group_id` varchar(32) NOT NULL DEFAULT '',
  `employee_no` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);

drop TABLE if exists message;
CREATE TABLE `message` (
  `msg_id` char(32) NOT NULL,
  `msg_type` varchar(100) NULL,
  `content` TINYTEXT NULL,
  PRIMARY KEY (`msg_id`)
);