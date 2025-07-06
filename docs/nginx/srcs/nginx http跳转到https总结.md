查找了一些资料，在这里终结一下，提供给大家参考。

Nginx环境下强制http转https设置方法：

方法一：
下面代码照搬过去就行。无需做任何修改。春哥技术博客推荐此种方法，非常简单，改完以后实时生效，不用重启服务器。

if ($scheme = http ) {
    return 301 https://$host$request_uri;
}
AI生成项目
方法二：
下面代码照搬过去就行。无需做任何修改。

if ($server_port = 80 ) {
    return 301 https://$host$request_uri;
}
AI生成项目
方法三：
下列代码中请注意把域名修改成自己域名。

if ($ssl_protocol = "") { 
    return 301 https://$server_name$request_uri; 
}

if ($host != www.wn789.com) { 
    return 301 $scheme://www.wn789.com$request_uri; 
}
AI生成项目
方法四：
下面代码中的域名请注意修改成自己的域名，切勿完全照搬。另外还要注意的是删除原来代码中的“listen 80;”。

server {
    listen 80;
    server_name wn789.xin www.wn789.xin;
    rewrite ^(.*) https://www.wn789.xin$1 permanent;
}
AI生成项目
方法五：
server {
    listen 80;
    server_name wn789.xin www.wn789.xin www.789wn.com 789wn.comm ;
    return 301 https://$server_name$request_uri;
}
AI生成项目
方法六：通过proxy_redirec方式
proxy_redirect 配置块（使用的字段）：http、server、location

解决办法：
# re-write redirects to http as to https, example: /home
proxy_redirect http:// https://;

location /batch-framework-web {
            proxy_pass http://batch_cluster/batch-framework-web;
            proxy_redirect  http://batch_cluster/batch-framework-web https://www.kevin.com/batch-framework-web;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_connect_timeout 300;
            proxy_send_timeout 300;
            proxy_read_timeout 600;
            proxy_buffer_size 256k;
            proxy_buffers 4 256k;
            proxy_busy_buffers_size 256k;
            proxy_temp_file_write_size 256k;
            proxy_next_upstream error timeout invalid_header http_500 http_502 http_503 http_504 http_404;
            proxy_max_temp_file_size 128m;

} 
AI生成项目

方法七：采用nginx的497状态码
497 - normal request was sent to HTTPS 
解释：当网站只允许https访问时，当用http访问时nginx会报出497错误码

思路：
利用error_page命令将497状态码的链接重定向到https://dev.wangsl.com这个域名上

配置实例：
如下访问dev.wangsl.com或者wangsl.com的http都会被强制跳转到https

server {
    listen 80;
    server_name dev.wangsl.com wangsl.com *.wangsl.com;
    index index.html index.php index.htm;

    access_log  /usr/local/nginx/logs/8080-access.log main;
    error_log  /usr/local/nginx/logs/8080-error.log;
     
    error_page 497  https://$host$uri?$args; 
      
    location ~ / {
        root /var/www/html/8080;
        index index.html index.php index.htm;
    }
}
AI生成项目

也可以将80和443的配置放在一起：


server { 
    listen       127.0.0.1:443;  #ssl端口 
    listen       127.0.0.1:80;   #用户习惯用http访问，加上80，后面通过497状态码让它自动跳到443端口 
    server_name  dev.wangsl.com; 
    #为一个server{......}开启ssl支持 
    ssl                  on; 
    #指定PEM格式的证书文件  
    ssl_certificate      /etc/nginx/wangsl.pem;  
    #指定PEM格式的私钥文件 
    ssl_certificate_key  /etc/nginx/wangsl.key; 
       
    #让http请求重定向到https请求  
    error_page 497  https://$host$uri?$args; 
     
    location ~ / {
        root /var/www/html/8080;
        index index.html index.php index.htm;
    }
}
AI生成项目

方法八：利用meta的刷新作用将http跳转到https
上述的方法均会耗费服务器的资源，可以借鉴百度使用的方法：巧妙的利用meta的刷新作用，将http跳转到https。


可以基于http://dev.wangsl.com的虚拟主机路径下写一个index.html，内容就是http向https的跳转

将下面的内容追加到index.html首页文件内
[root@localhost ~]# cat /var/www/html/8080/index.html
<html> 
<meta http-equiv="refresh" content="0;url=https://dev.wangsl.com/"> 
</html>

server {
    listen 80;
    server_name dev.wangsl.com wangsl.com *.wangsl.com;
    index index.html index.php index.htm;

    access_log  /usr/local/nginx/logs/8080-access.log main;
    error_log  /usr/local/nginx/logs/8080-error.log;
     
    #将404的页面重定向到https的首页 
    error_page  404 https://dev.wangsl.com/;  
      
    location ~ / {
        root /var/www/html/8080;         
        index index.html index.php index.htm;
    }

————————————————
版权声明：本文为CSDN博主「zzhongcy」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/zzhongcy/article/details/115520618