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
time9=datetime.datetime.strptime("2015-12-13 9:58:00","%Y-%m-%d %H:%M:%S")
time11=datetime.datetime.strptime("2015-9-19 10:58:00","%Y-%m-%d %H:%M:%S")
time13=datetime.datetime.strptime("2015-9-19 12:58:00","%Y-%m-%d %H:%M:%S")
time15=datetime.datetime.strptime("2015-9-19 14:58:00","%Y-%m-%d %H:%M:%S")
time17=datetime.datetime.strptime("2015-9-19 16:58:00","%Y-%m-%d %H:%M:%S")
time19=datetime.datetime.strptime("2015-9-19 18:56:00","%Y-%m-%d %H:%M:%S")
time21=datetime.datetime.strptime("2015-9-19 20:56:00","%Y-%m-%d %H:%M:%S")
#time18=datetime.datetime.strptime("2015-7-24 17:58:00","%Y-%m-%d %H:%M:%S")；



while (time9-timeNow).total_seconds() >0 :
    print("9 remain seconds" ,(time9-timeNow).total_seconds())
    if (time9-timeNow).total_seconds() <10 :
        easygui.msgbox('聚划算',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()



while (time11-timeNow).total_seconds() >0 :
     print("11 remain seconds" ,(time11-timeNow).total_seconds())
     if (time11-timeNow).total_seconds() <10 :
         easygui.msgbox('9点抢购',title="提醒",ok_button="知道啦")
     time.sleep(10)
     timeNow=datetime.datetime.now()


while (time13-timeNow).total_seconds() >0 :
    print("13 remain seconds" ,(time13-timeNow).total_seconds())
    if (time13-timeNow).total_seconds() <10 :
        easygui.msgbox('13点抢购',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()

while (time15-timeNow).total_seconds() >0 :
    print("15 remain seconds" ,(time15-timeNow).total_seconds())
    if (time15-timeNow).total_seconds() <10 :
        easygui.msgbox('15点抢购',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()

while (time17-timeNow).total_seconds() >0 :
    print("17 remain seconds" ,(time17-timeNow).total_seconds())
    if (time17-timeNow).total_seconds() <10 :
        easygui.msgbox('17点抢购',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()

while (time19-timeNow).total_seconds() >0 :
    print("19 remain seconds" ,(time19-timeNow).total_seconds())
    if (time19-timeNow).total_seconds() <10 :
        easygui.msgbox('19点抢购',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()


while (time21-timeNow).total_seconds() >0 :
    print("21 remain seconds" ,(time21-timeNow).total_seconds())
    if (time21-timeNow).total_seconds() <10 :
        easygui.msgbox('21点抢购',title="提醒",ok_button="知道啦")
    time.sleep(10)
    timeNow=datetime.datetime.now()