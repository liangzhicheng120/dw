#!/usr/bin/python
# -*- coding: utf-8 -*-

import time
import re
import jieba.analyse
import util as u
import traceback
import json
import MySQLdb
import sys
reload(sys)
sys.setdefaultencoding('utf-8')

####################参数说明##############################
TOPKET = 3  # 抽取作为唯一某类标示符的词个数(建议设置3-4)
COLUMN = 1  # 要聚类的内容所在列
#########################################################

"""
读取原始文件，抽取每段话的关键词，将关键词排序后最后这段话的key
将相同key的段落判断为一个cluster
将结果按照每个cluster的大小排序，大的在前面
性能:
行数----1000----10000----100000----1000000--
耗时-----2s------11s------129s------1432s---
内存----0.3mb----3mb------33mb------400mb---
"""
__author__ = "liangzhicheng"

SOURCENAME, SOURCEPATH = u.getFirstFile('csv')
cluster = {}
result_file_body = []
pattern = re.compile("\w|[/.,/#@$%^& ]")
count_file_dict = {}

if __name__ == '__main__':

    try:
        source_file_body = u.create_file_body(SOURCEPATH)
        for num, line in enumerate(source_file_body):
            content = re.sub(pattern, '', line.strip())
            if len(content) <= 20:
                keywords = jieba.analyse.extract_tags(content, topK=2)
            else:
                keywords = jieba.analyse.extract_tags(content, topK=TOPKET)
            keywords.sort()
            key = ','.join(keywords)
            cluster[key] = str(cluster.get(key, 0)) + "," + str(num + 1)
        for num, value in enumerate(cluster.itervalues()):
            cluster_list = value[2:].split(',')
            count_file_dict[num] = len(cluster_list)
            for n in cluster_list:
                result_file_body.append(str(num) + ',' + source_file_body[int(n) - 1])

        conn = MySQLdb.connect(host='localhost', port=3306, user='root', passwd='8532936', db='mydemo',charset='utf8')
        cur = conn.cursor()

        insterSql = 'INSERT INTO clustertab (clustertype, filmId, filmName, direct, protagonist, type, district, language) VALUES '

        for line in result_file_body:
            clustertype, filmId, filmName, direct, protagonist, type, district, language = u.gbk_2_utf8(line.strip().replace('#', '')).split(',')
            insterSql += '(' + clustertype + ',' + filmId + ',' + "'" + filmName + "'" \
                         + ',' + "'" + direct + "'" + ',' + "'" + protagonist + "'" + ',' + "'" + type + "'" \
                         + ',' + "'" + district + "'" + ',' + "'" + language + "'" + ')' + ','
                         
        cur.execute(insterSql[:-1])
        cur.close()
        conn.commit()
        conn.close()
        print 1

    except:
        print 0
        traceback.print_exc()
