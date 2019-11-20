package com.liaoxukai;/*
 *@author:kai
 *@create:2019-10-2019/10/31-9:13
 */

public class TestClass implements TestInterface{

    @Override
    public Integer add(Integer a, Integer b) {

        return a+b;
    }

    @Override
    public Integer minus(Integer a, Integer b) {
        return a-b;
    }
}
