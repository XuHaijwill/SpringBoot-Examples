# SpringBoot-Examples

## Springboot源码阅读

> Spring Boot 源码分析 - 剖析 @SpringBootApplication 注解
> https://www.cnblogs.com/lifullmoon/p/14957751.html
> https://www.skjava.com/series/article/1363961057

## Openjdk17
https://github.com/adoptium/temurin17-binaries/releases/tag/jdk-17.0.5+8
https://learn.microsoft.com/zh-cn/java/openjdk/download


## spring-boot-starter-parent，spring-boot-dependencies区别

```pom
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.5.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
  </parent>
```

> [推荐,常用]第二种是通过dependencyManagement进行依赖管理
```
 <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
   </dependencyManagement>
```