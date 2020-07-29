package com.seafwg.annotationTest;

/*
 * @create author: seafwg
 * @create time: 2020/7/29
 * @describe:
 */

import java.lang.annotation.Repeatable;

@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
  String value();
}
