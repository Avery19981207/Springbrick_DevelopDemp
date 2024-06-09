### 项目名称
基于Springbrick插件化开发的企业后台管理系统

# Spring-brick 框架

## 简介

**Spring-brick** 是一个可以动态扩展系统的框架，最早在2019年开始开发。该框架可以在SpringBoot项目上开发插件功能，开发插件就像开发独立应用一样。根据网站的介绍，使用该框架可以实现如下需求：

## 特性

- **微型 SpringBoot 项目**：在插件中，您可以像开发一个微型 SpringBoot 项目一样开发，简单易用。
- **灵活的系统扩展**：在插件中扩展出系统各种功能点，用于系统灵活扩展，再也不用使用分支来交付不同需求的项目了。
- **框架集成**：在插件中可以集成各种框架及其各种 spring-boot-xxx-starter。
- **独立依赖**：在插件中可以定义独立依赖包，再也不用在主程序中定义依赖包了。
- **版本冲突解决**：可以完美解决插件包与插件包、插件包与主程序因为同一框架的不同版本冲突问题。各个插件可以定义同一依赖的不同版本框架。
- **动态部署**：无需重启主程序，可以自由实现插件包的动态安装部署，来动态扩展系统的功能。
- **独立微服务**：插件也可以不依赖主程序独立集成微服务模块。
源码地址：https://gitee.com/starblues/springboot-plugin-framework-parent
文档地址：https://www.yuque.com/starblues/spring-brick-3.0.0

### 项目描述

本项目是一个基于Springbrick的Springboot插件化开发项目样例，整合了多种功能模块，旨在提供一个高效、可扩展的应用架构。通过使用 Springbrick，我们实现了项目的插件化动态开发，提升了开发效率和代码可维护性。

### 主程序结构

```
jt-sys/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cy/
│   │   │           ├── controller/
│   │   │           ├── pojo/
│   │   │           ├── service/
│   │   │           ├── utils/
│   │   ├── resources/
│   │   │   ├── JtsysApplication.yml
│   │   │   ├── mapper/
│   │   │   │    └── sys/
│   │   │   ├── static/
│   │   │   ├── templates/
│   ├── test/
│       └── java/
│           └── com/
│               └── ecy/
├── .gitignore
├── README.md
└── pom.xml
```
### 插件结构

```
xx_plugin/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cy/
│   │   │           ├── controller/
│   │   │           ├── pojo/
│   │   │           ├── service/
│   │   │           ├── utils/
│   │   ├── resources/
│   │   │   ├── Application.yml
│   │   │   ├── mapper/
│   │   │   │    └── sys/
│   │   │   ├── static/
│   │   │   ├── templates/
├── .gitignore
├── README.md
└── pom.xml
```

### 安装和运行

#### 先决条件

确保你已安装以下软件：

- JDK 8+
- Maven 3+
- MySQL 5.6

#### 配置数据库

在 `src/main/resources/application.yml` 文件中配置数据库连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database_name
    username: your_username
    password: your_password
```

在 `src/main/resources/application.yml` 文件中配置数据库连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database_name
    username: your_username
    password: your_password
```
#### 创建数据库
```
执行jtsys.sql文件
```
#### 主程序打包安装至本地maven仓库

```sh
mvn clean install
```
#### 插件打包，并将jar包防止固定文件路径下

```sh
mvn clean package
```
#### 配置插件路径

在 `src/main/resources/application.yml` 文件中配置数据库连接信息：

```yaml
plugin:
  # 运行模式, 开发环境: dev; 生产环境: prod
  runMode: prod
  # 主程序包名, 包名建议设置到范围最大级别，能包含主程序所有类的包名范围
  mainPackage: com.cy
  pluginPath:
    - 输入您本地的插件路径
```
### 执行主程序，访问

```sh
localhost:80/doPageUI
```
### 项目功能

- 部门管理
- 角色管理
- 菜单管理
- 日志管理
- 用户管理
- 密码修改

### 插件管理接口

在项目中，我们编写PluginManageController类，自定义了插件注册信息、插件热部署、插件卸载、停用的功能。此优化方案实现项目业务的热部署化更新，用于尝尝需要添加定制化小功能的场景。
**
  
### 示例代码

#### PluginManageController

```java
package com.cy.controller;


import com.gitee.starblues.core.PluginInfo;
import com.gitee.starblues.core.exception.PluginException;
import com.gitee.starblues.integration.operator.PluginOperator;
import com.gitee.starblues.integration.operator.upload.UploadByInputStreamParam;
import com.gitee.starblues.integration.operator.upload.UploadByMultipartFileParam;
import com.gitee.starblues.integration.operator.upload.UploadParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * 动态插件支持
 */
@RestController
@RequestMapping("/plugin")
public class PluginManageController {

    @Resource
    private PluginOperator pluginOperator;
    /**
     * 获取插件信息 [适用于 dev、prod 环境]
     *
     * @return 返回插件信息列表
     */
    @GetMapping("list")
    public List<PluginInfo> getPluginInfo() {
        return pluginOperator.getPluginInfo();
    }

    /**
     * 上传插件. [适用于 dev、prod 环境]
     * <pre>
     * dev模式:
     * 如果不存在相同插件(插件id不相同), 则正常上传到临时目录, 然后加载、启动。
     * 如果存在相同插件(插件id相同) 相同插件在启动状态,则进入更新模式(满足上传的插件包版本必须大于已启动的插件版本), 系统会自动卸载旧版本, 然后对临时目录中的插件进行安装、启动。 相同插件不在启动状态, 则直接对临时目录中的插件进行安装、启动。
     *
     * prod模式:
     * 如果不存在相同插件(插件id不相同), 则正常上传到插件目录, 然后加载、启动。
     * 如果存在相同插件(插件id相同) 相同插件在启动状态, 则进入更新模式(满足上传的插件包版本必须大于已启动的插件版本), 系统会自动卸载旧版本,安装新版本。 相同插件不在启动状态, 则进入覆盖模式, 会对旧插件进行备份(可根据isBackOldPlugin配置不备份), 然后上传新插件包到插件目录, 然后安装、启动。 如果在插件根目录存在同文件名称插件,
     * 系统会抛出异常, 建议重命名插件名称, 再上传。
     * </pre>
     *
     * @param pluginMultipartFile 上传参数。如果需要解压文件。则压缩包必须符合zip压缩包压缩包不允许
     *
     * @return 成功: 返回插件信息PluginInfo; 失败: 抛出异常或者返回null
     *
     * @throws PluginException 异常信息
     * @see UploadByInputStreamParam
     * @see UploadByMultipartFileParam
     */
    @PostMapping("upload")
    public PluginInfo uploadPlugin(@RequestParam("file") MultipartFile pluginMultipartFile) throws PluginException {
        return pluginOperator.uploadPlugin(UploadParam.byMultipartFile(pluginMultipartFile));
    }

    /**
     * 通过路径安装启动插件 [适用于 dev、prod 环境]
     *
     * @param pluginPath 插件文件路径
     *
     * @return 成功: 返回插件信息PluginInfo; 失败: 抛出异常或者返回null
     *
     * @throws PluginException 异常信息
     */
    @GetMapping("install")
    public PluginInfo install(@RequestParam("pluginPath") String pluginPath) throws PluginException {
        return pluginOperator.install(new File(pluginPath).toPath(), false);
    }

    /**
     * 卸载插件 [适用于 dev、prod 环境]
     *
     * @param pluginId 插件id
     *
     * @throws PluginException 异常信息
     */
    @GetMapping("uninstall")
    public String uninstall(@RequestParam("pluginId") String pluginId) throws PluginException {
        pluginOperator.uninstall(pluginId, false, true);
        return "uninstall ok!";
    }

    /**
     * 启用插件 [适用于 dev、prod 环境]
     *
     * @param pluginId 插件id
     *
     * @return 成功返回true.不成功抛出异常或者返回false
     *
     * @throws PluginException 异常信息
     */
    @PostMapping("start")
    public boolean start(@RequestParam("pluginId") String pluginId) throws PluginException {
        return pluginOperator.start(pluginId);
    }

    /**
     * 停止插件 [适用于 dev、prod 环境]
     *
     * @param pluginId 插件id
     *
     * @return 成功: 返回true; 失败: 抛出异常或者返回false
     *
     * @throws PluginException 异常信息
     */
    @PostMapping("stop")
    public boolean stop(@RequestParam("pluginId") String pluginId) throws PluginException {
        return pluginOperator.stop(pluginId);
    }

}
```

## 常见问题
该框架最大的问题在于**依赖冲突**，经过实验整理了以下问题：
 **1.插件需要排除spring-boot-start-web依赖，否则加载插件失败。**
 **2.插件引用主程序代码需要用provided模式，否则会连通依赖的主程序代码一同编译打包，在加载时出现关于cglibi的类加载冲突异常。**
**3.插件中bean对象进行依赖注入时，不从主程序获取依赖注入，会报NoSuchBeanDefinitionException异常**

### 依赖冲突

使用 **Spring-brick** 框架时，可能会遇到以下依赖冲突问题：

1. **插件需要排除 `spring-boot-starter-web` 依赖**：否则加载插件失败。
   
   解决方案：在插件的 `pom.xml` 中，排除 `spring-boot-starter-web` 依赖。

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
       <exclusions>
           <exclusion>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-tomcat</artifactId>
           </exclusion>
       </exclusions>
   </dependency>
   ```

2. **插件引用主程序代码需要用 `provided` 模式**：否则会连同依赖的主程序代码一同编译打包，在加载时出现关于 `cglib` 的类加载冲突异常。
   
   解决方案：在插件的 `pom.xml` 中，将主程序的依赖设置为 `provided`。

   ```xml
   <dependency>
       <groupId>com.cy</groupId>
       <artifactId>main-app</artifactId>
       <version>1.0.0</version>
       <scope>provided</scope>
   </dependency>
   ```

3. **插件中 Bean 对象进行依赖注入时，不从主程序获取依赖注入**：会报 `NoSuchBeanDefinitionException` 异常。
   
   解决方案：确保插件中的 Bean 对象可以从主程序获取依赖注入，或在插件中定义所需的依赖。

