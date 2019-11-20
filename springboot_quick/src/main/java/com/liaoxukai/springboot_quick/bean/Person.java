package com.liaoxukai.springboot_quick.bean;/*
 *@author:kai
 *@create:2019-10-2019/10/27-14:36
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;
    private Integer age;
    private String  birth;
    private Map<String,Integer> map;
    private List<String> list;
    private Dog dog;

    public Person() {
    }

    public Person(String name, Integer age, String birth, Map<String, Integer> map, List<String> list, Dog dog) {
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.map = map;
        this.list = list;
        this.dog = dog;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth='" + birth + '\'' +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }
}
