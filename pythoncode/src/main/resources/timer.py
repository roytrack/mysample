'''
create at :2015-5-22 10:30:23
@Summary:this is a timer to remind you something
@author:roytrack
'''
import time, easygui, datetime

'''' 

i +=1
time.sleep(10)
time14=
print(time14)
'''

timeNow = datetime.datetime.now()
time10 = datetime.datetime.strptime("2015-7-26 09:58:00", "%Y-%m-%d %H:%M:%S")
time12 = datetime.datetime.strptime("2015-7-26 11:58:00", "%Y-%m-%d %H:%M:%S")
time14 = datetime.datetime.strptime("2015-7-26 13:58:00", "%Y-%m-%d %H:%M:%S")
time16 = datetime.datetime.strptime("2015-7-26 15:58:00", "%Y-%m-%d %H:%M:%S")
time18 = datetime.datetime.strptime("2015-7-26 17:50:00", "%Y-%m-%d %H:%M:%S")
time20 = datetime.datetime.strptime("2015-7-26 19:58:00", "%Y-%m-%d %H:%M:%S")
time22 = datetime.datetime.strptime("2015-7-26 21:58:00", "%Y-%m-%d %H:%M:%S")

while (time10 - timeNow).total_seconds() > 0:
    print("10 remain seconds", (time10 - timeNow).total_seconds())
    if (time10 - timeNow).total_seconds() < 10:
        easygui.msgbox('准备开始抢支付宝红包！ 史上最薄', title="提醒", ok_button="知道啦")
    time.sleep(10)
    timeNow = datetime.datetime.now()

while (time12 - timeNow).total_seconds() > 0:
    print("12 remain seconds", (time12 - timeNow).total_seconds())
    if (time12 - timeNow).total_seconds() < 10:
        easygui.msgbox('准备开始抢支付宝红包！ 养头皮', title="提醒", ok_button="知道啦")
    time.sleep(10)
    timeNow = datetime.datetime.now()

while (time14 - timeNow).total_seconds() > 0:
    print("14 remain seconds", (time14 - timeNow).total_seconds())
    if (time14 - timeNow).total_seconds() < 10:
        easygui.msgbox('准备开始抢支付宝红包！ 狮王', title="提醒", ok_button="知道啦")
    time.sleep(10)
    timeNow = datetime.datetime.now()

while (time16 - timeNow).total_seconds() > 0:
    print("16  remain seconds", (time16 - timeNow).total_seconds())
    if (time16 - timeNow).total_seconds() < 10:
        easygui.msgbox('准备开始抢支付宝红包！ 宝宝金水', title="提醒", ok_button="知道啦")
    time.sleep(10)
    timeNow = datetime.datetime.now()

while (time18 - timeNow).total_seconds() > 0:
    print("18  remain seconds", (time18 - timeNow).total_seconds())
    if (time18 - timeNow).total_seconds() < 10:
        easygui.msgbox('准备开始抢支付宝红包！ 未知，郁美净旗舰店', title="提醒", ok_button="知道啦")
    time.sleep(10)
    timeNow = datetime.datetime.now()

while (time20 - timeNow).total_seconds() > 0:
    print("20  remain seconds", (time20 - timeNow).total_seconds())
    if (time20 - timeNow).total_seconds() < 10:
        easygui.msgbox('准备开始抢支付宝红包！ 广州浪奇    还有天猫红包', title="提醒", ok_button="知道啦")
    time.sleep(10)
    timeNow = datetime.datetime.now()

while (time22 - timeNow).total_seconds() > 0:
    print("22  remain seconds", (time22 - timeNow).total_seconds())
    if (time22 - timeNow).total_seconds() < 10:
        easygui.msgbox('准备开始抢支付宝红包！ 99元', title="提醒", ok_button="知道啦")
    time.sleep(10)
    timeNow = datetime.datetime.now()