title: 在DigitalOcean主机上玩vpn和shadowsock
date: 2014-12-07 16:02:16
comment: true
tags:
- vpn
- sock5
categories:
- linux
---
*   [vpn](#vpn)
    *   [vpn相关软件的安装](#vpninstall)
    *   [vpn 本地配置](#vpnconfig)
*   [shadowsock](#shadowsock)
    *   [shadowsock的安装与自启动](#ssinstall)
    *   [客户端配置与选择] (#ssconfig)
    *   [采用privoxy转成http代理](sstohttp)


年前拿到了个DigitalOcean的主机，终于摆脱了GFW和goagent的斗智斗勇，过上了墙里墙外的美好生活。
在centos7-64bit上安装vpn和shadowsock的过程中，遇到了一些问题。记录下来后结合最近的使用，分享给大家一些经验和技巧。

安装环境： CentOS 7.0 x64 vmlinuz-3.10.0-123.8.1.el7.x86_64 。通过cat /proc/version查看信息如下：
Linux version 3.10.0-123.8.1.el7.x86_64 (builder@kbuilder.dev.centos.org) (gcc version 4.8.2 20140120 (Red Hat 4.8.2-16) (GCC) ) #1 SMP Mon Sep 22 19:06:58 UTC 2014

硬广插入：vpn和shadowsock都采用的DigitalOcean的ssd主机5美元一个月搭建的，优势网上搜一下，ssd主机还有啥好说的？ [点击此处][do]注册购买，可以免费获赠10美元优惠款哦！

[do]:https://www.digitalocean.com/?refcode=b055d2148f2f


<h2 id="vpn">vpn部分</h2>
<h3 id="vpninstall">vpn相关软件的安装</h3>
vpn安装主要需要ppp 、pptpd和iptables 这些软件
<h4>前置检查</h4>
检查是否能够安装pptp  执行命令：

        modprobe ppp-compress-18 && echo ok
modprobe是检测能否在内核中挂载对应模块的命令。后面与上echo ok ，如果输出为ok，表示支持ppp压缩。

第二个是检测tun是否启用 执行命令：

        cat /dev/net/tun
输出结果为 cat: /dev/net/tun: File descriptor in bad state  表示开启了tun功能
<h4>安装软件</h4>
我使用的是cenos 7 x64 具体信息见上面。 安装命令：

        yum install -y perl ppp iptables
安装完毕后，可以通过

        yum list perl ppp iptables
来列出相关的软件版本，例如我安装的软件版本如下：

 ![install software](http://roytrack.qiniudn.com/blog_vpnppp_perl_iptables.jpg)

安装好了上述软件后就要开始安装pptp了。由于cenos 7比较新，所以需要更新一下yum源。自己在这里折腾了一阵，网上一通乱找，可用较好的方案如下：

        vi /etc/yum.repos.d/epel.repo

然后把下面这一段给粘过去

        [epel]
        name=Extra Packages for Enterprise Linux 7 - $basearch
        #baseurl=http://download.fedoraproject.org/pub/epel/7/$basearch
        mirrorlist=https://mirrors.fedoraproject.org/metalink?repo=epel-7&arch=$basearch
        failovermethod=priority
        enabled=1
        gpgcheck=0
        gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-EPEL-7

        [epel-debuginfo]
        name=Extra Packages for Enterprise Linux 7 - $basearch - Debug
        #baseurl=http://download.fedoraproject.org/pub/epel/7/$basearch/debug
        mirrorlist=https://mirrors.fedoraproject.org/metalink?repo=epel-debug-7&arch=$basearch
        failovermethod=priority
        enabled=0
        gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-EPEL-7
        gpgcheck=1

        [epel-source]
        name=Extra Packages for Enterprise Linux 7 - $basearch - Source
        #baseurl=http://download.fedoraproject.org/pub/epel/7/SRPMS
        mirrorlist=https://mirrors.fedoraproject.org/metalink?repo=epel-source-7&arch=$basearch
        failovermethod=priority
        enabled=0
        gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-EPEL-7
        gpgcheck=1

:wq退出 然后执行 yum makecache 更新一下缓存。

这时候就可以正式的安装pptpd了。 命令 yum install -y pptpd 执行一下。到此软件就基本安装完毕了。

<h4>配置软件</h4>
编辑pptpd.conf文件，命令如下：

        vi /etc/pptpd.conf

在文件结尾处有localip字样。配置如下：

        localip 192.168.0.1
        remoteip 192.168.0.234-238,192.168.0.245
第一行是vpn服务端的内网ip，第二行是客户端登陆后给分配的ip池。直接原样复制就行。

编辑options.pptpd文件，命令如下：

        vi /etc/ppp/options.pptpd
找到ms-dns行 修改如下：

        ms-dns 8.8.8.8
        ms-dns 114.114.114.114
用不易被污染的dns就行例如google的四个4，四个8等等。

编辑chap-secrets文件，命令如下：

        vi /etc/ppp/chap-secrets

配置格式为 用户名 pptpd 密码 *   例如：

        roytrack pptpd 123 *
编辑sysctl.conf文件

        vi /etc/sysctl.conf       编辑文件命令
        net.ipv4.ip_forward=1     添加转发内容
        sysctl -p                       执行该命令让配置生效

编辑rc.local文件

        chmod +x /etc/rc.d/rc.local            赋予该文件执行权限
        vi /etc/rc.d/rc.local               编辑该文件
        iptables -t nat -A POSTROUTING -s 192.168.0.0/24 -o eth0 -j MASQUERADE          添加路由转发
启动pptpd

        /etc/init.d/pptpd start         启动命令
        chkconfig pptpd on             pptpd开机自启动
到此vpn服务端就搭建好了。
<h2 id="vpnconfig"> vpn 本地配置</h2>
在win7中 打开控制面板-网络和共享中心-设置新的连接或网络-连接到工作区 一步步填上用户名 密码就ok了。


