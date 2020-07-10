# -*- coding:utf-8 -*-
import requests

# 以下为GET请求
url = 'https://www.csdn.net/'
ret = requests.get(url);
print(ret.status_code);
