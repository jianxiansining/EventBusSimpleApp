package com.djn.huidiao.huidiao;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/16.
 */
public class TestBean implements Serializable {
    public int flag;//标记

    public String name;
    public int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
