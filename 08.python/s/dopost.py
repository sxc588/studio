# -*- coding:utf-8 -*-
import requests

# 以下为POST请求
url = 'https://xxxxx.com/login'
postdatas = {'key': 'value'}
requests = requests.post(url, data=postdatas)
print (requests.content ) # 返回字节形式