/*创建数据源*/
CREATE SCHEMA `mydemo` DEFAULT CHARACTER SET utf8 ; 

/*建表，存放影视剧信息，包括：剧名、导演、主演、类型、地区*/
CREATE TABLE `mydemo`.`recsys` (
  `filmId` INT NOT NULL AUTO_INCREMENT COMMENT '影视剧id',
  `filmName` VARCHAR(50) NULL COMMENT '影视剧名称',
  `direct` VARCHAR(50) NULL COMMENT '导演',
  `protagonist` VARCHAR(50) NULL COMMENT '主演',
  `type` VARCHAR(25) NULL COMMENT '影视剧类型',
  `district` VARCHAR(45) NULL COMMENT '地区',
  PRIMARY KEY (`filmId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '存放影视剧信息，包括：剧名、导演、主演、类型、地区';


ALTER TABLE `mydemo`.`recsys` 
CHANGE COLUMN `protagonist` `protagonist` VARCHAR(200) NULL DEFAULT NULL COMMENT '主演' ,
CHANGE COLUMN `type` `type` VARCHAR(100) NULL DEFAULT NULL COMMENT '影视剧类型' ,
CHANGE COLUMN `district` `district` VARCHAR(100) NULL DEFAULT NULL COMMENT '地区' ,
ADD COLUMN `language` VARCHAR(50) NULL AFTER `district`;


/*-----------------------------CRUD---------------------------------*/
SELECT filmId,filmName,direct,protagonist,type,district FROM mydemo.recsys limit 100;

INSERT INTO `mydemo`.`recsys` (`filmId`, `filmName`, `direct`, `protagonist`, `type`, `district`) VALUES ('1', '琅琊榜', '孔笙 / 李雪', '胡歌 / 刘涛 / 王凯 / 黄维德 / 陈龙 / 丁勇岱 / 刘敏涛 / 靳东 / 刘奕君 / 王劲松 / 张龄心 / 吴磊 / 程皓枫 / 郭晓然 / 高鑫 / 王永泉 / 周奇奇 / 王鸥 / 张棪琰 / 宁文彤 / 方晓莉 / 杨雨婷 / 谭希和 / 张晓谦', '历史剧 / 古装剧 / 偶像剧 / 宫廷剧', ' 内地');
INSERT INTO `mydemo`.`recsys` (`filmId`, `filmName`, `direct`, `protagonist`, `type`, `district`, `language`) VALUES ('2', '锦绣未央', '李慧珠', '唐嫣/ 罗晋/ 吴建豪/ 毛晓彤/ 李心艾', '古装/爱情', '中国大陆', '国语');
INSERT INTO `mydemo`.`recsys` (`filmId`, `filmName`, `direct`, `protagonist`, `type`, `district`, `language`) VALUES ('3', '庶女有毒', '李慧珠', '唐嫣/ 罗晋/ 吴建豪/ 毛晓彤/ 李心艾', '古装/爱情', '中国大陆', '国语');
INSERT INTO `mydemo`.`recsys` (`filmId`, `filmName`, `direct`, `protagonist`, `type`, `district`) VALUES ('4', '琅琊榜', '孔笙 / 李雪', '胡歌 / 刘涛 / 王凯 / 黄维德 / 陈龙 / 刘敏涛 / 靳东 / 刘奕君 /丁勇岱 / 王劲松 / 张龄心 / 吴磊 / 程皓枫 / 郭晓然 / 高鑫 / 王永泉 / 周奇奇 / 王鸥 / 张棪琰 / 宁文彤 / 方晓莉 / 杨雨婷 / 谭希和 / 张晓谦', '历史剧 / 古装剧 / 偶像剧 / 宫廷剧', ' 内地');


UPDATE `mydemo`.`recsys` SET `language`='国语' WHERE `filmId`='1';
