# -*- coding:utf-8 -*-
# 请求超时， timeout的单位为秒
import requests

url = 'https://support.huawei.com/'
r = requests.get(url)
if r.status_code == requests.codes.ok:
    print('=== status_code === ', r.status_code)  # 响应码
    print('=== headers === （', r.headers)  # 响应头
    print('=== Content-Type === ', r.headers.get('Content-Type'))  # 获取响应头中的Content-
    print(r.content)  # 获取响应头中的Content-Type字段
else:
    r.raise_for_status()  # 抛出异常
