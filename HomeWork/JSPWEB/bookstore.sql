/*
Navicat MySQL Data Transfer

Source Server         : my145book
Source Server Version : 50016
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50016
File Encoding         : 65001

Date: 2022-02-06 23:03:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `userid` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `firstname` varchar(80) NOT NULL,
  `lastname` varchar(80) NOT NULL,
  `status` varchar(2) default NULL,
  `addr1` varchar(80) NOT NULL,
  `addr2` varchar(40) default NULL,
  `city` varchar(80) NOT NULL,
  `state` varchar(80) NOT NULL,
  `zip` varchar(20) NOT NULL,
  `country` varchar(20) NOT NULL,
  `phone` varchar(80) NOT NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('bookstore', '823160453@qq.com', 'Duo', 'shilin', '1', '河南科技大学', '河南科技大学', '涧西区', '洛阳市', '河南', '中国', '17080035676');
INSERT INTO `account` VALUES ('Burson', 'burson@live.cn', '张', '雅', '1', '1#101', '郑州', '中原区', '郑州市', '河南省', '中国', '12345678');
INSERT INTO `account` VALUES ('Duosl', '823160453@qq.com', '多', '世', '1', '河南科技大学', 'a河南科技大学', '涧西区', '洛阳市', '河南', '中国', '17080035676');
INSERT INTO `account` VALUES ('lisi1', '1', '1', '1', null, '11', '11', '11', '11', '11', '111', '2');

-- ----------------------------
-- Table structure for bannerdata
-- ----------------------------
DROP TABLE IF EXISTS `bannerdata`;
CREATE TABLE `bannerdata` (
  `favcategory` varchar(80) NOT NULL,
  `bannername` varchar(255) default NULL,
  PRIMARY KEY  (`favcategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bannerdata
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `catid` varchar(10) NOT NULL,
  `name` varchar(80) default NULL,
  `descn` varchar(255) default NULL,
  PRIMARY KEY  (`catid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('02', '编程类', '关于编程类的书籍');
INSERT INTO `category` VALUES ('03', '文学类', '关于文学类的书籍');
INSERT INTO `category` VALUES ('04', '艺术类', '关于艺术类的书籍');
INSERT INTO `category` VALUES ('05', '农业技术类', '关于农业技术类的书籍');
INSERT INTO `category` VALUES ('06', '航空航天类', '关于航空航天类的书籍');
INSERT INTO `category` VALUES ('07', '电子图书类', '关于电子图书类的书籍');
INSERT INTO `category` VALUES ('08', '交通运输类', '关于交通运输类的书籍');
INSERT INTO `category` VALUES ('09', '工业技术类', '关于工业技术类的书籍');
INSERT INTO `category` VALUES ('10', '环境科学类', '关于环境科学类的书籍');

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `itemid` varchar(10) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY  (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inventory
-- ----------------------------
INSERT INTO `inventory` VALUES ('1002', '999');
INSERT INTO `inventory` VALUES ('1003', '0');
INSERT INTO `inventory` VALUES ('1004', '922');
INSERT INTO `inventory` VALUES ('1005', '947');
INSERT INTO `inventory` VALUES ('1006', '945');
INSERT INTO `inventory` VALUES ('1007', '933');
INSERT INTO `inventory` VALUES ('1008', '1111');
INSERT INTO `inventory` VALUES ('1009', '945');
INSERT INTO `inventory` VALUES ('1010', '1123');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `itemid` varchar(10) NOT NULL,
  `productid` varchar(10) NOT NULL,
  `listprice` decimal(10,2) default NULL,
  `unitcost` decimal(10,2) default NULL,
  `supplier` int(11) default NULL,
  `status` varchar(2) default NULL,
  `attr1` varchar(80) default NULL,
  `attr2` varchar(80) default NULL,
  `attr3` varchar(80) default NULL,
  `attr4` varchar(80) default NULL,
  `attr5` varchar(80) default NULL,
  PRIMARY KEY  (`itemid`),
  KEY `fk_item_2` (`supplier`),
  KEY `itemProd` (`productid`),
  CONSTRAINT `fk_item_1` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`),
  CONSTRAINT `fk_item_2` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`suppid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1002', '1002', '66.00', '50.00', null, '1', null, null, null, null, null);
INSERT INTO `item` VALUES ('1003', '1003', '58.00', '36.00', null, '1', null, null, null, null, null);
INSERT INTO `item` VALUES ('1004', '1004', '62.00', '40.00', null, '0', null, null, null, null, null);
INSERT INTO `item` VALUES ('1005', '1005', '38.00', '28.00', null, '1', null, null, null, null, null);
INSERT INTO `item` VALUES ('1006', '1006', '123.00', '88.00', null, '0', null, null, null, null, null);
INSERT INTO `item` VALUES ('1007', '1007', '48.00', '35.00', null, '1', null, null, null, null, null);
INSERT INTO `item` VALUES ('1008', '1008', '33.00', '22.00', null, '1', null, null, null, null, null);
INSERT INTO `item` VALUES ('1009', '1009', '160.00', '130.00', null, '1', null, null, null, null, null);
INSERT INTO `item` VALUES ('1010', '1010', '178.00', '99.00', null, '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for lineitem
-- ----------------------------
DROP TABLE IF EXISTS `lineitem`;
CREATE TABLE `lineitem` (
  `orderid` int(11) NOT NULL,
  `linenum` int(11) NOT NULL,
  `itemid` varchar(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unitprice` decimal(10,2) NOT NULL,
  PRIMARY KEY  (`orderid`,`linenum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lineitem
-- ----------------------------
INSERT INTO `lineitem` VALUES ('5001', '1001', '1003', '1', '58.00');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL,
  `userid` varchar(80) NOT NULL,
  `orderdate` date NOT NULL,
  `shipaddr1` varchar(80) NOT NULL,
  `shipaddr2` varchar(80) default NULL,
  `shipcity` varchar(80) NOT NULL,
  `shipstate` varchar(80) NOT NULL,
  `shipzip` varchar(20) NOT NULL,
  `shipcountry` varchar(20) NOT NULL,
  `billaddr1` varchar(80) NOT NULL,
  `billaddr2` varchar(80) default NULL,
  `billcity` varchar(80) NOT NULL,
  `billstate` varchar(80) NOT NULL,
  `billzip` varchar(20) NOT NULL,
  `billcountry` varchar(20) NOT NULL,
  `courier` varchar(80) NOT NULL,
  `totalprice` decimal(10,2) NOT NULL,
  `billtofirstname` varchar(80) NOT NULL,
  `billtolastname` varchar(80) NOT NULL,
  `shiptofirstname` varchar(80) NOT NULL,
  `shiptolastname` varchar(80) NOT NULL,
  `creditcard` varchar(80) NOT NULL,
  `exprdate` varchar(7) NOT NULL,
  `cardtype` varchar(80) NOT NULL,
  `locale` varchar(80) NOT NULL,
  PRIMARY KEY  (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('5001', 'a', '2022-02-06', 'null', 'null', 'null', 'null', 'null', 'null', '11', '11', '11', '11', '11', '111', 'UPS', '12.00', 'null', 'null', 'null', 'null', '111', '111', '建设银行', 'aaa');

-- ----------------------------
-- Table structure for orderstatus
-- ----------------------------
DROP TABLE IF EXISTS `orderstatus`;
CREATE TABLE `orderstatus` (
  `orderid` int(11) NOT NULL,
  `linenum` int(11) NOT NULL,
  `timestamp` date NOT NULL,
  `status` varchar(2) NOT NULL,
  PRIMARY KEY  (`orderid`,`linenum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderstatus
-- ----------------------------
INSERT INTO `orderstatus` VALUES ('5001', '1001', '2022-02-06', 'p');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productid` varchar(10) NOT NULL,
  `category` varchar(10) NOT NULL,
  `name` varchar(80) default NULL,
  `descn` varchar(255) default NULL,
  PRIMARY KEY  (`productid`),
  KEY `productCat` (`category`),
  KEY `productName` (`name`),
  CONSTRAINT `fk_product_1` FOREIGN KEY (`category`) REFERENCES `category` (`catid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1002', '02', 'java web开发', 'null');
INSERT INTO `product` VALUES ('1003', '03', '文学基础课程', 'null');
INSERT INTO `product` VALUES ('1004', '04', '艺术基础课程', 'null');
INSERT INTO `product` VALUES ('1005', '05', '由浅入深的了解农业技术', 'null');
INSERT INTO `product` VALUES ('1006', '06', '如何做一个优秀的宇航员', 'null');
INSERT INTO `product` VALUES ('1007', '07', '大主宰', 'null');
INSERT INTO `product` VALUES ('1008', '08', '驾考宝典', 'null');
INSERT INTO `product` VALUES ('1009', '09', '工业技术基础课程', 'null');
INSERT INTO `product` VALUES ('1010', '10', '环境保护', 'null');
INSERT INTO `product` VALUES ('1011', '03', '中国艺术', 'null');
INSERT INTO `product` VALUES ('1013', '03', '中国艺术', 'null');

-- ----------------------------
-- Table structure for profile
-- ----------------------------
DROP TABLE IF EXISTS `profile`;
CREATE TABLE `profile` (
  `userid` varchar(80) NOT NULL,
  `langpref` varchar(80) NOT NULL,
  `favcategory` varchar(30) default NULL,
  `mylistopt` tinyint(1) default NULL,
  `banneropt` tinyint(1) default NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of profile
-- ----------------------------

-- ----------------------------
-- Table structure for sequence
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `name` varchar(30) NOT NULL,
  `nextid` int(11) NOT NULL,
  PRIMARY KEY  (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sequence
-- ----------------------------

-- ----------------------------
-- Table structure for signon
-- ----------------------------
DROP TABLE IF EXISTS `signon`;
CREATE TABLE `signon` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signon
-- ----------------------------
INSERT INTO `signon` VALUES ('a', '123');
INSERT INTO `signon` VALUES ('bookstore', 'm123');
INSERT INTO `signon` VALUES ('Burson', 'm123');
INSERT INTO `signon` VALUES ('lisi', 'm123');
INSERT INTO `signon` VALUES ('lisi1', '1234');
INSERT INTO `signon` VALUES ('wangwu', 'm123');
INSERT INTO `signon` VALUES ('xiaohong', 'm123');
INSERT INTO `signon` VALUES ('xiaozhang', 'm123');
INSERT INTO `signon` VALUES ('zhangsan', 'm123');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `suppid` int(11) NOT NULL,
  `name` varchar(80) default NULL,
  `status` varchar(2) NOT NULL,
  `addr1` varchar(80) default NULL,
  `addr2` varchar(80) default NULL,
  `city` varchar(80) default NULL,
  `state` varchar(80) default NULL,
  `zip` varchar(5) default NULL,
  `phone` varchar(80) default NULL,
  PRIMARY KEY  (`suppid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
