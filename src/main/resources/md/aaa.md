title: 在oceanDigital主机上玩vpn和shadowsock
date: 2014-12-07 16:02:16
comment: true
tags:
- vpn
- sock5
categories:
- linux
---
*   [vpn](#vpn)
    *   [vpn软件相关的安装](#vpninstall)
    *   [vpn 本地配置](#vpnconfig)
*   [shadowsock](#shadowsock)
    *   [shadowsock的安装与自启动](#ssinstall)
    *   [客户端配置与选择] (#ssconfig)
    *   [采用privoxy转成http代理](sstohttp)


年前拿到了个DigitalOcean的主机，终于摆脱了GFW和goagent的斗智斗勇，过上了墙里墙外的美好生活。
在centos7-64bit上安装vpn和shadowsock的过程中，遇到了一些问题。记录下来后结合最近的使用，分享给大家一些经验和技巧。

硬广插入：vpn和shadowsock都采用的DigitalOcean的ssd主机5美元一个月搭建的，优势网上搜一下，ssd主机还有啥好说的？ [点击此处][do]注册购买，可以免费获赠10美元优惠款哦！

[do]:https://www.digitalocean.com/?refcode=b055d2148f2f


<h2 id="vpn">vpn</h2>
<h3 id="vpn">vpnconfig</h3>