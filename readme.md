### 项目名称

Springbrick 集成项目

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
插件化开发优势：
  动态扩展：通过插件机制，可以在不修改核心系统代码的情况下，动态地添加或移除功能模块，增强了系统的可扩展性。
  多样化功能：可以根据需要开发和部署不同的插件，实现多样化的功能扩展，满足不同用户的需求。
  松耦合设计：插件化开发将核心功能与扩展功能分离，核心模块和插件模块之间的依赖关系较少，降低了模块间的耦合度。
  易于维护：模块化设计使得代码结构清晰，每个插件模块可以独立开发、测试和维护，减少了代码的复杂度和维护成本。
  独立开发：插件可作为独立的项目进行独立开发。
  
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
