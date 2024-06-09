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

