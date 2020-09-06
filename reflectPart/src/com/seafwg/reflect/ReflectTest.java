package com.seafwg.reflect;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: 反射机制：在运行时构造一个运行时类的对象[将类的各个组成部分封装为其他对象Class]
 * TODO
 * 优点：
 *  ①.可以在程序运行过成中操作这些对象。
 *  ②.可以解耦，提高程序的可读性。
 *
 * 获取Class对象的方式：
 * 	1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
 * 		* 多用于配置文件，将类名定义在配置文件中。读取文件，加载类
 * 	2. 类名.class：通过类名的属性class获取
 * 		* 多用于参数的传递
 * 	3. 对象.getClass()：getClass()方法在Object类中定义着。
 * 		* 多用于对象的获取字节码的方式
 * 	* 结论：
 * 		同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，不论通过哪一种方式获取的Class对象都是同一个。
 *
 * 	* Class对象功能：
 * 获取功能：
 * 		1. 获取成员变量们
 * 			* Field[] getFields() ：获取所有public修饰的成员变量
 * 			* Field getField(String name)   获取指定名称的 public修饰的成员变量
 *
 * 			* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
 * 			* Field getDeclaredField(String name)
 * 		2. 获取构造方法们
 * 			* Constructor<?>[] getConstructors()
 * 			* Constructor<T> getConstructor(类<?>... parameterTypes)
 *
 * 			* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
 * 			* Constructor<?>[] getDeclaredConstructors()
 * 		3. 获取成员方法们：
 * 			* Method[] getMethods()
 * 			* Method getMethod(String name, 类<?>... parameterTypes)
 *
 * 			* Method[] getDeclaredMethods()
 * 			* Method getDeclaredMethod(String name, 类<?>... parameterTypes)
 *
 * 		4. 获取全类名
 * 			* String getName()
 *
 * * Field：成员变量
 * * 操作：
 * 		1. 设置值
 * 			* void set(Object obj, Object value)
 * 		2. 获取值
 * 			* get(Object obj)
 *
 * 		3. 忽略访问权限修饰符的安全检查
 * 			* setAccessible(true):暴力反射
 *
 * * Constructor:构造方法
 * * 创建对象：
 * 		* T newInstance(Object... initargs)
 *
 * 		* 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法
 *
 * 	* Method：方法对象
 * 	* 执行方法：
 * 		* Object invoke(Object obj, Object... args)
 *
 * 	* 获取方法名称：
 * 		* String getName:获取方法名
 **/
public class ReflectTest {
    @BeforeTest
    public void init() {
        System.out.println("init...");
    }
    @AfterTest
    public void after() {
        System.out.println("after...");
    }
    @Test
    public void test() {
        System.out.println("test");
    }

    @Test
    public void testNum() {
        int a = 128;
        byte b = (byte) a;
        System.out.println(b);
    }

    @Test
    public void getClassWay() {

    }
}
