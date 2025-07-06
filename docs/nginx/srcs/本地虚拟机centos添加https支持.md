因为是本地环境，不需要申请免费证书，使用模拟环境生成自签名证书即可
1 安装openssl

yum install mod_ssl openssl
AI生成项目
2 切换到nginx配置文件夹，创建ssl文件夹，切换到ssl文件夹

[root@localhost conf]# pwd
/usr/local/openresty/nginx/conf
[root@localhost conf]# mkdir ssl
[root@localhost conf]# cd ssl/
AI生成项目
3 生成2048位的加密私钥

openssl genrsa -out server.key 2048
AI生成项目
4 生成证书签名请求（CSR），这里需要填写许多信息，随便填写即可

openssl req -new -key server.key -out server.csr
AI生成项目
5 生成类型为X509的自签名证书。有效期设置3650天，即有效期为10年。

openssl x509 -req -days 3650 -in server.csr -signkey server.key -out server.crt
AI生成项目
6 查看生成的文件

[root@localhost ssl]# ls
server.crt  server.csr  server.key
AI生成项目
7 配置nginx支持https

server {
        listen       80;
        #https配置开始
    listen       443 ssl;
        server_name  localhost;

        ssl_certificate      ssl/server.crt;
        ssl_certificate_key  ssl/server.key;
     
        ssl_session_cache    shared:SSL:1m;
        ssl_session_timeout  5m;
     
        ssl_ciphers  HIGH:!aNULL:!MD5;
        ssl_prefer_server_ciphers  on;
        #https配置结束
        server_name  localhost;
     
        #charset koi8-r;
     
        #access_log  logs/host.access.log  main;
     
        location / {
            root   html;
            index  index.html index.htm;
        }
AI生成项目

8 重启nginx服务器

service nginx restart
或./nginx -s reload
————————————————
版权声明：本文为CSDN博主「西城xml」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/xichengqc/article/details/88055895