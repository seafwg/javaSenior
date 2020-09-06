package com.seafwg.annotationTest2;

import java.lang.reflect.Method;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: 使用注解和反射完成一个“框架”：不能改变该类的任何代码。可以创建任意类的对象，可以执行任意方法
 * TODO
 *
 * 注解的作用代替配置文件的作用：加载一个要执行的类：
 **/

@Pro(className = "com.seafwg.annotationTest2.AnnoClass2",methodName = "show")
public class FrameReflectTest {
    public static void main(String[] args) throws Exception {
        //①.解析注解，获取类的字节码对象
        Class<FrameReflectTest> frt = FrameReflectTest.class;
        //②.获取注解对象：
        Pro pro = frt.getAnnotation(Pro.class);
        //③.调用注解对象中定义的抽象方法获取类的返回值
        String className = pro.className();
        String methodName = pro.methodName();

        //④.加载该类到内存
        Class aClass = Class.forName(className);
        //⑤.创建对象
        Object instance = aClass.newInstance();
        //⑥.获取方法对象
        Method aClassMethod = aClass.getMethod(methodName);
        //⑦.执行该方法
        aClassMethod.invoke(instance);

    }
}
