package com.f4rrari.day02;

public class Person {
    protected String name;
    protected int age;
    protected String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // 方法：子类将重写
    public String getRole() {
        return "普通人";
    }

    public void introduce() {
        System.out.printf("我是%s，今年%d岁，性别%s，身份：%s%n",
                name, age, gender, getRole());
    }

    // getter/setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}