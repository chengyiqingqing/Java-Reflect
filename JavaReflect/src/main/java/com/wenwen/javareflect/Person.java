package com.wenwen.javareflect;

/**
 * Created by Administrator on 2018/4/12.
 */

public class Person {

    public String name;
    private int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show(){
        System.out.println("我是中国人");
    }

    public void disPlay(String str){
        System.out.println("我的国籍是："+str);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
