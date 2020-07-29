package com.seafwg.annotationTest;

/*
 * @create author: seafwg
 * @create time: 2020/7/29
 * @describe: annotation注解的使用：
 * 1.使用示例：
 *  1.1 生成文档相关注解：方法前的@param...
 *  1.2 在编译时进行格式检查（jdk内置的三个基本注解）
 *    1.2.1 @Override:限定重写父类方法，该注解只用于方法
 *    1.2.2 @Deprecated: 表示所修饰的元素类，方法已过时。
 *    1.2.3 @SuppressWarnings:抑制编译器警告
 *  1.3 跟踪代码依赖性，实现配置文件功能
 *
 * 2.自定义注解：参照@SuppressWarngs注解
 *  ① 注解声明格式为： 修饰符 @interface 注解名{}
 *  ② 内部成员通常用value表示，格式为： 基本类型 value();不是方法是属性
 *  ③ 可以指定默认值，使用default定义： 基本数据类型 value() default xxx;
 *  ④ 如果自定义注解没有成员，表明是一个表示作用，eg:@Override,如果有成员在使用注解时，需要指明成员的值。
 * 自定义注解必须配上注解的信息处理流程（使用反射）才最有意义，自定义注解通常都会指明两个元注解：Retention,Target
 *
 * 3.jdk提供的四种元注解：
 * 元注解：对现有注解进行解释说明的注解
 *  3.1 Retention:指明所修饰的Annotation的生命周期：SOURCE/CLASS(default)/RUNTIME,只有声明RUNTIME时才能通过反射获取。
 *  3.2 Target:用于指定修饰的Annotation能用于那些程序元素，类，方法...
 *  3.3 Documented:所修饰的Annotation被javadoc解析时，保留下来
 *  3.4 Inherited:它所修饰的Annotation具有继承性
 *
 * 4.通过反射获取注解信息
 *
 * 5.jdk8注解新增：
 *  ① 可重复注解:eg:在MyAnnotation注解前使用@Repeatable(MyAnnotations.class)修饰两个注解关联在一起,两者的元注解Target,Retention等元注解相同
 *  ② 类型注解：
 *    ElementType.TYPE_PARAMETER：表示该注解能写在类型变量的声明语句中
 *    ElementType.TYPE_USE：表示该注解能写在适用类型的任何语句中
 */
public class annotationTest {
}

//jdk1.8以前的写法：
@MyAnnotations({@MyAnnotation(value = "hello"), @MyAnnotation(value = "world")})
class Person{
  //...
}

// jdk1.8的注解：可重复注解：
@MyAnnotation(value="hello")
@MyAnnotation(value="world")
class Student{

}
