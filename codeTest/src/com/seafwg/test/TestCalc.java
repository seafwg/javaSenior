package com.seafwg.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public class TestCalc {
    /**
     * 初始化方法：用于资源申请，所有测试方法在执行之前都会先执行该方法
     */
    @BeforeTest
    public void testBefore() {
        System.out.println("before...");
    }

    /**
     * 释放资源方法：在所有测试方法执行完后，都会自动执行该方法
     */
    @AfterTest
    public void testAfter() {
        System.out.println("after...");
    }
    //@Test
    @Test
    public void testAdd() {
        //1.创建计算器对象：
        Calc calc = new Calc();
        //2.调用add方法：
        int returnAdd = calc.add(1, 2);
        //设置断言：Assert
        Assert.assertEquals(3,returnAdd);
    }
    @Test
    public void testSub() {
        //1.create Calc obj
        Calc calc = new Calc();
        //2.call obj sub methods
        int resultSub = calc.sub(3, 1);
        //3.use assert compare to your expect number
        Assert.assertEquals(2,resultSub);
    }
}
