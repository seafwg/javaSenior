package com.seafwg.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: 案例：写一个"框架"，不能改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执行其中任意方法
 * TODO
 * * 实现：
 * 1. 配置文件：pro.properties配置文件配置类，方法名。
 * 2. 反射：利用反射运行时加载类，方法，并执行。
 * * 步骤：
 * 1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 * 2. 在程序中加载读取配置文件
 * 3. 使用反射技术来加载类文件进内存
 * 4. 创建对象
 * 5. 执行方法
 *
 * 修改配置文件的好处：
 *  大型项目优势明显，代码结构不变，逻辑不变，避免了测试等环节。
 **/
public class FrameReflectTest {
    public static void main(String[] args) throws Exception {
        //前提：不能改变该类的任何代码。可以创建任意类的对象，可以执行任意方法

        //1.加载配置文件：
        // 1.1 创建Properties对象
        Properties pro = new Properties();
        // 1.2 加载配置文件，转换为一个集合：
        // 1.2.1 获取class目录下的配置文件
        ClassLoader classLoader = FrameReflectTest.class.getClassLoader();
        InputStream res = classLoader.getResourceAsStream("pro.properties");
        pro.load(res);

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存：
        Class aClass = Class.forName(className);

        //4.创建对象：
        Object obj = aClass.newInstance();

        //5.通过对象获取方法：
        Method aClassMethod = aClass.getMethod(methodName);

        //6.执行该方法
        aClassMethod.invoke(obj);

    }
}
