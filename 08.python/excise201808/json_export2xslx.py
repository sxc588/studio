#!/usr/bin/python
#-*-coding:utf-8 -*-

import xlwt
import requests
import traceback
import time


def write_xls(data):
    wb = xlwt.Workbook();
    sheet = wb.add_sheet("dddf");
    key_list = data[0].keys()
    col_count = 0;
    for key in key_list:
        sheet.write(0,col_count,key)
        col_count+=1

    row_count=1;
    for row in data:
        for i in range(len(key_list)):
            key= key_list[i];
            value=row[key]
            sheet.write(row,i,value)
        row +=1

    filename = time.strftime("avaiable_%Y-%m-%d_%H_%M_%S.xls",time.localtime())

    wb.save(filename);


def make_data(start_time = 15009180000,end_time= 153305280000):
    tim1=time.strftime("%Y-%m-%d %H:%M:%S",time.localtime(start_time/1000))
    tim2 = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(end_time / 1000))

    print("start_time=" +tim1 +";end_time=" +tim2)

    by_month="y"
    prod=""

    available_url = 'http://support.huawei.com/enterprise/starttime=%s&endtime=%s&bymoth=%s&prod=%s'

    url = available_url %(start_time,end_time,by_month,prod)

    reuqet = requests
