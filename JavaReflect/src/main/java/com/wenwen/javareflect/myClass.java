package com.wenwen.javareflect;

/**
 *
 */
public class myClass {

    public static void main(String[] args){
        System.out.println("asdfasdflj");
    }
    /**1.反射的定义：
     *       反射是被视为动态语言的关键：
     *       （1）反射机制允许程序在“运行期间”借助于Reflection API取得任何类的内部信息
     *       （2）并能直接操作任意对象的“内部属性及方法”
     */

    /**2.反射机制提供的功能：
     *      （1）运行时判断任意一个对象所属的类
     *      （2）运行时判断任意一个类所具有的成员变量和方法
     *      （3）运行时构造任意一个类的对象，并调用其的成员变量和方法
     *      （4）生成动态代理；
     *
     */

    /** 3.反射的主要内容
     * 1.理解Class类并实例化Class类的对象
     * 2.运行时创建类对象并获取类的完整结构
     * 3.通过反射调用类的指定方法，指定属性
     * 4.动态代理；
     *
     */

    /** 4.反射相关的api
     *      （1）java.lang.Class: 代表一个类相对应的Class类；
     *      （2）java.lang.reflect.Method: 代表类的方法；
     *      （3）java.lang.reflect.Field:  代表类的成员变量；
     *      （4）java.lang.reflect.Constructor: 代表类的构造方法；
     *
     */

}
