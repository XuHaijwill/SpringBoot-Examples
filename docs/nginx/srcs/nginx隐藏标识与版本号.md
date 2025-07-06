# nginx隐藏标识与版本号

https://cloud.tencent.com/developer/article/1797657

### 隐藏Nginx标识与版本号

#### 前言

为什么要隐藏nginx标识与版本号？因为nginx默认配置存在安全漏洞。如下图：

![img](imgs\htcmdvuuen.png)

#### 目录

1、隐藏版本号 2、隐藏Nginx标识--修改源码 3、重新编译安装后即可

#### 1、隐藏版本号

curl Nginx[服务器](https://cloud.tencent.com/product/cvm?from_column=20065&from=20065)时，有这么一行Server: nginx，说明我用的是 Nginx 服务器，但并没有具体的版本号。由于某些 Nginx 漏洞只存在于特定的版本，隐藏版本号可以提高安全性。这只需要在nginx.conf配置里加上这个就可以了：

编辑server模块在server_name下面怎么如下配置：

server_tokens off;

eg:

![img](imgs\6jyzqmrb08.png)

#### 2、隐藏Nginx标识--修改源码

下载Nginx源码 [http://nginx.org/download/nginx-1.19.2.tar.gz](https://cloud.tencent.com/developer/tools/blog-entry?target=https%3A%2F%2Flinks.jianshu.com%2Fgo%3Fto%3Dhttp%3A%2F%2Fnginx.org%2Fdownload%2Fnginx-1.19.2.tar.gz&objectId=1797657&objectType=1&isNewArticle=undefined)

**下载不同版本的nginx模板**

[http://nginx.org/download/nginx-填写版本号.tar.gz](https://cloud.tencent.com/developer/tools/blog-entry?target=https%3A%2F%2Flinks.jianshu.com%2Fgo%3Fto%3Dhttp%3A%2F%2Fnginx.org%2Fdownload%2Fnginx-%25E5%25A1%25AB%25E5%2586%2599%25E7%2589%2588%25E6%259C%25AC%25E5%258F%25B7.tar.gz&objectId=1797657&objectType=1&isNewArticle=undefined)

**下载后存放位置：**

[图片上传失败...(image-8211aa-1614592774731)]

##### 2.1第一步：修改 core包下的nginx.h文件**

```javascript
vim src/core/nginx.h +14

#define NGINX_VER "happy/" NGINX_VERSION
```

修改前：

![img](imgs\l3i1u279dn.png)

修改后：

[root@glxxh src]# vim core/nginx.h

![img](imgs\81m4ygtqve.png)



##### 2.2第二步：修改src/http包下文件

修改文件：

1.ngx_http_special_response.c

2.ngx_http_header_filter_module.c

###### 2.2.1修改gx_http_special_response.c

```javascript
# vim src/http/ngx_http_special_response.c  +22 +29 和 +36 （注意修改后无引号，NGINX_VER为变量）
```

修改前：

![img](imgs\66rlque50q.png)

修改后

![img](imgs\wtoswf1w36.png)

###### 2.2.2修改ngx_http_header_filter_module.c：



```javascript
# vim src/http/ngx_http_header_filter_module.c +49
```

修改为：

![img](imgs\nk3q6mpq3d.png)



```javascript
static  char ngx_http_server_string[] = "Server: happy" CRLF;
```

#### 3、重新编译安装后即可

##### 3.1第一步:先备份

**先备份/usr/local/nginx/sbin下的启动文件**

**再备份/usr/local/nginx/conf/下的nginx.conf文件**

##### 3.2第二步：编译nginx源码

![img](imgs\uw1r6fcggg.png)



进入nginx目录进行编译操作

cd nginx-1.13.7

[root@localhost nginx-1.13.7]# ./configure --prefix=/usr/local/nginx

[root@localhost nginx-1.13.7]# make

##### 3.3第三步:更换启动文件nginx(非常重要的一步)：

1.先停掉nginx服务器：

2.备份/usr/local/nginx/sbin/nginx文件

3.替换启动文件：将编译好的/u  sr/local/nginx-1.13.7/objs/nginx 拷贝到/usr/local/nginx/sbin/下

4．启动nginx

[root@localhost sbin]# ./nginx -V

#### 4、curl -I localhost

![img](imgs\xkoywwyfe8.png)



#### 5、访问验证

修改前：

![img](imgs\8v8dkdmx2a.png)

修改后：

![img](imgs\r271d7n5pw.png)

#### 6.修改默认配置

/usr/local/nginx/html下面的静态页面要修改不要出现nginx的字样。

![img](imgs\ouitv7enu4.png)

如果遇到这方面的问题，没有处理好，请留言，如果有写的不对的地方请指正。



## 为什么要隐藏nginx的版本号和标识？

隐藏Nginx的版本号和标识的主要目的是增强服务器的安全性，具体原因如下：



1. **减少攻击面**：攻击者通常会利用已知的漏洞进行攻击。如果Nginx的版本号被公开，攻击者可以轻松识别出服务器使用的Nginx版本，并针对该版本的已知漏洞进行攻击。隐藏版本号可以增加攻击者发现和利用漏洞的难度。



2. **防止信息泄露**：Nginx的标识信息可能包含操作系统、编译选项等额外信息，这些信息可能被攻击者用来进一步分析服务器的配置和环境，从而找到更多的攻击点。



3. **提高安全性**：通过隐藏版本号和标识，可以降低服务器被针对性攻击的风险，提高整体安全性。



**实现步骤**



1. **修改Nginx配置文件**：在Nginx的配置文件中，找到`http`、`server`或`location`块，添加或修改相关指令来隐藏版本号和标识。



2. **重启Nginx服务**：修改配置文件后，需要重启Nginx服务以使更改生效。



**代码实现**



```
http {
    server_tokens off;
    more_clear_headers Server;
}
```



`server_tokens off;`：隐藏Nginx版本号。

`more_clear_headers Server;`：隐藏`Server`响应头中的标识信息（需要安装`ngx_http_headers_more_filter_module`模块）。

## Nginx去除Server HTTP头，之headers-more-nginx-module使用

https://blog.csdn.net/zzhongcy/article/details/115538272

## How To Customize The Nginx Server Header?

https://www.uptimia.com/questions/how-to-customize-the-nginx-server-header