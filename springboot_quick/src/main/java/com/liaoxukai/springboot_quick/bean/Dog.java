package com.liaoxukai.springboot_quick.bean;/*
 *@author:kai
 *@create:2019-10-2019/10/27-14:38
 */

public class Dog {

    private String name;
    private Integer age;

    public Dog() {
    }

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
