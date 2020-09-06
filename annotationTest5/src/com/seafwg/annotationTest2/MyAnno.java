package com.seafwg.annotationTest2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: 自定义注解：
 * TODO
 **/
@Target(value={ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    int age();
    String name();
}
