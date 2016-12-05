#!/usr/bin/python
# -*- coding: utf-8 -*-

import time
import re
import jieba.analyse
import traceback
import json
from sys import argv

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

info = {}
cluster = {}
result_file_body = []
pattern = re.compile("\w|[/.,/#@$%^& ]")
count_file_dict = {}

str1 = '琅琊榜孔笙/李雪胡歌/刘涛/王凯/黄维德/陈龙/丁勇岱/刘敏涛/靳东/刘奕君/王劲松/张龄心/吴磊/程皓枫/郭晓然/高鑫/王永泉/周奇奇/王鸥/张棪琰/宁文彤/方晓莉/杨雨婷/谭希和/...历史剧/古装剧/偶像剧/宫廷剧内地国语'
str2 = '锦绣未央李慧珠唐嫣/罗晋/吴建豪/毛晓彤/李心艾古装/爱情中国大陆国语'
str3 = '庶女有毒李慧珠唐嫣/吴建豪/罗晋/毛晓彤/李心艾古装/爱情中国大陆国语'
str4 = '琅琊棒孔笙/李雪胡歌/刘涛/王凯/黄维德/陈龙/丁勇岱/刘敏涛/靳东/刘奕君/王劲松/张龄心/吴磊/程皓枫/郭晓然/高鑫/王永泉/周奇奇/王鸥/张棪琰/宁文彤/方晓莉/杨雨婷/谭希和/...历史剧/古装剧/偶像剧/宫廷剧内地国语'

if __name__ == '__main__':
    source_file_body = [str1, str2, str3, str4]
    try:
        for num, line in enumerate(source_file_body):
            content = re.sub(pattern, '', line.strip().split(",")[COLUMN - 1])

            if len(content) <= 20:
                keywords = jieba.analyse.extract_tags(content, topK=2)
            else:
                keywords = jieba.analyse.extract_tags(content, topK=TOPKET)
            keywords.sort()
            key = ','.join(keywords)
            cluster[key] = str(cluster.get(key, 0)) + ',' + str(num + 1)

        for num, value in enumerate(cluster.itervalues()):
            cluster_list = value[2:].split(',')
            count_file_dict[num] = len(cluster_list)
            for n in cluster_list:
                result_file_body.append(str(num) + ',' + source_file_body[int(n) - 1])

        for line in result_file_body:  # 转换成json格式输出
            data = line.split(',')
            info[data[0]] = data[1]

        print json.dumps(info)
        print "args:", argv[1]
    except:
        traceback.print_exc()
