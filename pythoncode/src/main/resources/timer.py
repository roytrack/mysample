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
time14=datetime.datetime.strptime("2015-5-22 13:58:00","%Y-%m-%d %H:%M:%S")
time16=datetime.datetime.strptime("2015-5-22 16:58:00","%Y-%m-%d %H:%M:%S")
time18=datetime.datetime.strptime("2015-5-22 17:58:00","%Y-%m-%d %H:%M:%S")
while (time14-timeNow).total_seconds() >0 :
    print("14 remain seconds" ,(time14-timeNow).total_seconds())
    if (time14-timeNow).total_seconds() <10 :
        easygui.msgbox('准备开始抢支付宝红包！ 贝芬乐',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()


while (time16-timeNow).total_seconds() >0 :
    print("16  remain seconds" ,(time16-timeNow).total_seconds())
    if (time16-timeNow).total_seconds() <10 :
        easygui.msgbox('准备开始抢支付宝红包！ 爱法贝',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()


while (time18-timeNow).total_seconds() >0 :
    print("18  remain seconds" ,(time18-timeNow).total_seconds())
    if (time18-timeNow).total_seconds() <10 :
        easygui.msgbox('准备开始抢支付宝红包！ 一九四一',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()