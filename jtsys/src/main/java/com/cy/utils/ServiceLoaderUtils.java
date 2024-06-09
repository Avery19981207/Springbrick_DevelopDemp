package com.cy.utils;

import com.cy.controller.config.ClassImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class ServiceLoaderUtils {

    @Autowired
    ClassImpl classImpl;

    static String jarPath = "";


    public static void loadJarsFromAppFolder() throws Exception {
        String path = jarPath;
        File f = new File(path);
        if (f.isDirectory()) {
            for (File subf : f.listFiles()) {
                if (subf.isFile()) {
                    loadJarFile(subf);
                }
            }
        } else {
            loadJarFile(f);
        }
    }

    public static void loadJarFile(File path) throws Exception {
        URL url = path.toURI().toURL();
        // 可以获取到AppClassLoader，可以提到前面，不用每次都获取一次
        URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        // 加载
        //Method method = URLClassLoader.class.getDeclaredMethod("sendMsg", Map.class);
        Method method = URLClassLoader.class.getMethod("sendMsg", Map.class);

        method.setAccessible(true);
        method.invoke(classLoader, url);
    }

    public static void main(String[] args) throws Exception{
        System.out.println(invokeMethod("hello"));
    }

    public String doExecuteMethod() throws Exception{
        String path = "D:\\work\\springboot-mry-plug-develop-method\\springboot-mry-iz-demo\\lib";
        File f1 = new File(path);
        Object result = null;
        if (f1.isDirectory()) {
            for (File subf : f1.listFiles()) {
                //获取文件名称
                String name = subf.getName();
                String fullPath = path + "\\" + name;
                //执行反射相关的方法
                //ServiceLoaderUtils serviceLoaderUtils = new ServiceLoaderUtils();
                //result = serviceLoaderUtils.loadMethod(fullPath);
                File f = new File(fullPath);
                URL urlB = f.toURI().toURL();
                URLClassLoader classLoaderA = new URLClassLoader(new URL[]{urlB}, Thread.currentThread()
                        .getContextClassLoader());
                String[] clazz = classImpl.getClazz();
                for(String claName : clazz){
                    if(name.equals("springboot-mry-biz-0.0.1-SNAPSHOT.jar")){
                        /*if(!claName.equals("com.mry.plugins.impl.AliyunSendMsg")){
                            continue;
                        }*/
                        Class<?> loadClass = classLoaderA.loadClass(claName);
                        if(Objects.isNull(loadClass)){
                            continue;
                        }
                        //获取实例
                        Object obj = loadClass.newInstance();
                        Map map = new HashMap();
                        //获取方法
                        Method method=loadClass.getDeclaredMethod("sendMsg",Map.class);
                        result = method.invoke(obj,map);
                        if(Objects.nonNull(result)){
                            break;
                        }
                    }else if(name.equals("springboot-mry-miz-0.0.1-SNAPSHOT.jar")){
                        /*if(!claName.equals("com.mry.plugins.impl.TencentSendMsg")){
                            continue;
                        }*/
                        Class<?> loadClass = classLoaderA.loadClass(claName);
                        if(Objects.isNull(loadClass)){
                            continue;
                        }
                        //获取实例
                        Object obj = loadClass.newInstance();
                        Map map = new HashMap();
                        //获取方法
                        Method method=loadClass.getDeclaredMethod("sendMsg",Map.class);
                        result = method.invoke(obj,map);
                        if(Objects.nonNull(result)){
                            break;
                        }
                    }
                }
                if(Objects.nonNull(result)){
                    break;
                }
            }
        }
        return result.toString();
    }

    public Object loadMethod(String fullPath) throws Exception{
        File f = new File(fullPath);
        URL urlB = f.toURI().toURL();
        URLClassLoader classLoaderA = new URLClassLoader(new URL[]{urlB}, Thread.currentThread()
                .getContextClassLoader());
        Object result = null;
        String[] clazz = classImpl.getClazz();
        for(String claName : clazz){
            Class<?> loadClass = classLoaderA.loadClass(claName);
            if(Objects.isNull(loadClass)){
                continue;
            }
            //获取实例
            Object obj = loadClass.newInstance();
            Map map = new HashMap();
            //获取方法
            Method method=loadClass.getDeclaredMethod("sendMsg",Map.class);
            result = method.invoke(obj,map);
            if(Objects.nonNull(result)){
                break;
            }
        }
        return result;
    }


    public static String invokeMethod(String text) throws Exception{
        String path = "D:\\work\\springboot-mry-plug-develop-method\\springboot-mry-iz-demo\\lib\\springboot-mry-miz-0.0.1-SNAPSHOT.jar";
        File f = new File(path);
        URL urlB = f.toURI().toURL();
        URLClassLoader classLoaderA = new URLClassLoader(new URL[]{urlB}, Thread.currentThread()
                .getContextClassLoader());
        Class<?> product = classLoaderA.loadClass("com.mry.plugin.impl.TencentSendMsg");
        //获取实例
        Object obj = product.newInstance();
        Map map = new HashMap();
        //获取方法
        Method method=product.getDeclaredMethod("sendMsg",Map.class);
        //执行方法
        Object result1 = method.invoke(obj,map);
        // TODO According to the requirements , write the implementation code.
        return result1.toString();
    }

    public static String getApplicationFolder() {
        String path = ServiceLoaderUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        return new File(path).getParent();
    }

}
