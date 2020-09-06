package com.seafwg.annotationTest2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: 自定义注解：
 *
 * TODO
 *
 *  1. 属性的返回值类型有下列取值
 * 	  * 基本数据类型
 * 	  * String
 * 	  * 枚举
 * 	  * 注解
 * 	  * 以上类型的数组
 *
 *  2. 定义了属性，在使用时需要给属性赋值
 * 		1. 如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值。
 * 		2. 如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可。
 * 		3. 数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略
 * */
@Target(value = {ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno2 {
    int[] level(); // 使用数组
//    AnnoClass ac(); // 不能使用类
    AnnoEnum ae(); // 使用枚举
    MyAnno my(); // 使用注解
}
