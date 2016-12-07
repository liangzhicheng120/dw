/*��������Դ*/
CREATE SCHEMA `mydemo` DEFAULT CHARACTER SET utf8 ; 

/*�������Ӱ�Ӿ���Ϣ�����������������ݡ����ݡ����͡�����*/
CREATE TABLE `mydemo`.`recsys` (
  `filmId` INT NOT NULL AUTO_INCREMENT COMMENT 'Ӱ�Ӿ�id',
  `filmName` VARCHAR(50) NULL COMMENT 'Ӱ�Ӿ�����',
  `direct` VARCHAR(50) NULL COMMENT '����',
  `protagonist` VARCHAR(50) NULL COMMENT '����',
  `type` VARCHAR(25) NULL COMMENT 'Ӱ�Ӿ�����',
  `district` VARCHAR(45) NULL COMMENT '����',
  PRIMARY KEY (`filmId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '���Ӱ�Ӿ���Ϣ�����������������ݡ����ݡ����͡�����';


ALTER TABLE `mydemo`.`recsys` 
CHANGE COLUMN `protagonist` `protagonist` VARCHAR(200) NULL DEFAULT NULL COMMENT '����' ,
CHANGE COLUMN `type` `type` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Ӱ�Ӿ�����' ,
CHANGE COLUMN `district` `district` VARCHAR(100) NULL DEFAULT NULL COMMENT '����' ,
ADD COLUMN `language` VARCHAR(50) NULL AFTER `district`;


/*-----------------------------CRUD---------------------------------*/
SELECT filmId,filmName,direct,protagonist,type,district FROM mydemo.recsys limit 100;

INSERT INTO `mydemo`.`recsys` (`filmId`, `filmName`, `direct`, `protagonist`, `type`, `district`) VALUES ('1', '�����', '���� / ��ѩ', '���� / ���� / ���� / ��ά�� / ���� / ����� / ������ / ���� / ���Ⱦ� / ������ / ������ / ���� / ���� / ����Ȼ / ���� / ����Ȫ / ������ / ��Ÿ / �ŗ��� / ����ͮ / ������ / ������ / ̷ϣ�� / ����ǫ', '��ʷ�� / ��װ�� / ż��� / ��͢��', ' �ڵ�');
INSERT INTO `mydemo`.`recsys` (`filmId`, `filmName`, `direct`, `protagonist`, `type`, `district`, `language`) VALUES ('2', '����δ��', '�����', '����/ �޽�/ �⽨��/ ë��ͮ/ ���İ�', '��װ/����', '�й���½', '����');
INSERT INTO `mydemo`.`recsys` (`filmId`, `filmName`, `direct`, `protagonist`, `type`, `district`, `language`) VALUES ('3', '��Ů�ж�', '�����', '����/ �޽�/ �⽨��/ ë��ͮ/ ���İ�', '��װ/����', '�й���½', '����');
INSERT INTO `mydemo`.`recsys` (`filmId`, `filmName`, `direct`, `protagonist`, `type`, `district`) VALUES ('4', '�����', '���� / ��ѩ', '���� / ���� / ���� / ��ά�� / ���� / ������ / ���� / ���Ⱦ� /����� / ������ / ������ / ���� / ���� / ����Ȼ / ���� / ����Ȫ / ������ / ��Ÿ / �ŗ��� / ����ͮ / ������ / ������ / ̷ϣ�� / ����ǫ', '��ʷ�� / ��װ�� / ż��� / ��͢��', ' �ڵ�');


UPDATE `mydemo`.`recsys` SET `language`='����' WHERE `filmId`='1';
