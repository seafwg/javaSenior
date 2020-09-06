package com.seafwg.annotationTest2;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: 自定义注解的使用：解析注解
 * TODO
 *
 * 在程序使用(解析)注解：获取注解中定义的属性值
 **/
//@MyAnno(age = 23,name="seafwg")
@MyAnno2(level = {1,2,3},ae=AnnoEnum.HOBBY1,my=@MyAnno(age = 23, name = "seafwg"))
public class DemoUseMyAnno {
}
