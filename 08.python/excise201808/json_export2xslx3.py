#!/usr/bin/python
# -*-coding:utf-8 -*-

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
        sheet.write(0, col_count, key)
        col_count += 1

    row_count = 1;
    for row in data:
        for i in range(len(key_list)):
            key = key_list[i];
            value = row[key]
            sheet.write(row, i, value)
        row += 1

    filename = time.strftime("available_%Y-%m-%d_%H_%M_%S.xls", time.localtime())

    wb.save(filename)
    print(filename)


def avc():
    url = 'https://support.huawei.com/enterpriseproduct/DocTypeNewOfferingAction!getLangAll.action'
    data = {'tid': '6691579', 'lang': 'zh', 'requestType': 'ajax.json'}
    result = requests.post(url, data)
    print(result.text)

    for i in result.json():
        print(i['vid'])

    write_xls(result.json())


avc()
