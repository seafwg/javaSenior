package com.seafwg.reflect;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public class ReflectTest {
    @BeforeTest
    public void testBefore() {
        System.out.println("...before");
    }
    @Test
    public void test() {
        System.out.println("test");
    }
}
