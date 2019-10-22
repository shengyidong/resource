##### 1.获取mysql数据源

wget http://repo.mysql.com/mysql57-community-release-el7-8.noarch.rpm

##### 2.解压

rpm -ivh mysql57-community-release-el7-8.noarch.rpm

##### 3.安装数据库

yum install mysql-server -y

##### 4.启动mysql

systemctl start mysqld

##### 5.开机启动mysql

systemctl enable mysql

##### 6.查询随机密码

grep "password" /var/log/mysqld.log

##### 7.登录mysql

mysql -uroot -p

##### 8.修改密码

set password=password("密码");

##### 9.授权

grant all privileges on *.* to 'root'@'%' identified by '远程登录密码' with grant option;

##### 10.刷新

flush privileges;
