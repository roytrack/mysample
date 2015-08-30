'''
create at :2015-5-22 10:30:23
@Summary:this is a timer to remind you something
@author:roytrack
'''
import time ,easygui,datetime

'''' 

i +=1
time.sleep(10)
time14=
print(time14)
'''

timeNow=datetime.datetime.now()
time10=datetime.datetime.strptime("2015-8-19 9:58:00","%Y-%m-%d %H:%M:%S")
time12=datetime.datetime.strptime("2015-8-19 11:58:00","%Y-%m-%d %H:%M:%S")
time14=datetime.datetime.strptime("2015-8-19 13:58:00","%Y-%m-%d %H:%M:%S")
time15=datetime.datetime.strptime("2015-8-19 14:58:00","%Y-%m-%d %H:%M:%S")
time16=datetime.datetime.strptime("2015-8-19 15:58:00","%Y-%m-%d %H:%M:%S")
time18=datetime.datetime.strptime("2015-8-19 17:58:00","%Y-%m-%d %H:%M:%S")
time20=datetime.datetime.strptime("2015-8-19 19:57:00","%Y-%m-%d %H:%M:%S")
#time18=datetime.datetime.strptime("2015-7-24 17:58:00","%Y-%m-%d %H:%M:%S")；

while (time10-timeNow).total_seconds() >0 :
    print("10 remain seconds" ,(time10-timeNow).total_seconds())
    if (time10-timeNow).total_seconds() <10 :
        easygui.msgbox('中文支付宝红包口令：三生有幸闺蜜同行',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()



while (time12-timeNow).total_seconds() >0 :
    print("12 remain seconds" ,(time12-timeNow).total_seconds())
    if (time12-timeNow).total_seconds() <10 :
        easygui.msgbox('中文支付宝红包口令：赤果果的示爱',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()


while (time14-timeNow).total_seconds() >0 :
    print("14 remain seconds" ,(time14-timeNow).total_seconds())
    if (time14-timeNow).total_seconds() <10 :
        easygui.msgbox('中文支付宝红包口令：喝美赞臣不担心上火',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()

while (time15-timeNow).total_seconds() >0 :
    print("15 remain seconds" ,(time15-timeNow).total_seconds())
    if (time15-timeNow).total_seconds() <10 :
        easygui.msgbox('中文支付宝红包口令：放心飞',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()

while (time16-timeNow).total_seconds() >0 :
    print("16 remain seconds" ,(time16-timeNow).total_seconds())
    if (time16-timeNow).total_seconds() <10 :
        easygui.msgbox('中文支付宝红包口令：美高积木大有玩头',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()

while (time18-timeNow).total_seconds() >0 :
    print("18 remain seconds" ,(time18-timeNow).total_seconds())
    if (time18-timeNow).total_seconds() <10 :
        easygui.msgbox('中文支付宝红包口令：至柔极净',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()


while (time20-timeNow).total_seconds() >0 :
    print("20 remain seconds" ,(time20-timeNow).total_seconds())
    if (time20-timeNow).total_seconds() <10 :
        easygui.msgbox('中文支付宝红包口令：聚划算抢杜杜',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()