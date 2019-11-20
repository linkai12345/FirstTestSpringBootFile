package com.liaoxukai;/*
 *@author:kai
 *@create:2019-10-2019/10/31-9:14
 */

public class TestMain {


    public static void main(String[] args) {
        testadd(new TestClass());
    }

    public static void testadd(TestInterface testInterface){

        System.out.println("测试下基于接口编程"+testInterface.add(3,4));
    }
}
