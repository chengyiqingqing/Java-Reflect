package com.wenwen.javareflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/4/12.
 */

public class Sww01_testReflectClass {

    public static void main(String[] args) throws Exception {
//        testNoReflect();
//        testReflect();
//        testReflectClass();
        new Sww01_testReflectClass().initReflectClass();
    }

    /**
     * 1.不使用反射的时候，应该调用哪些东西；
     */
    public static void testNoReflect(){
        //1.
        Person person=new Person();  //叫做运行时类，因为在编译的时候，只是生成了.class文件即Class对象
        person.setAge(10);           //在运行时，将.class文件对应的类 加载到内存里。
        person.setName("邵文文");
        System.out.println(person);//会打印它的toString()方法；
        person.show();
        person.disPlay("中国");

    }

    /**
     * 2.可以通过反射创建一个类的对象，并调用其中的结构。
     * @throws Exception
     */
    public static void testReflect() throws Exception{
        //1.创建clazz对应的运行时类Person类的对象
        Class clazz=Person.class;
        Person person=(Person)clazz.newInstance();
        System.out.println(person);
        //2.调用它的属性；
        Field fieldName=clazz.getField("name");//public 修饰的；
        fieldName.set(person,"邵文文");
        Field fieldAge=clazz.getDeclaredField("age");//private 修饰的；
        fieldAge.setAccessible(true);
        fieldAge.set(person,23);
        System.out.println(person);
        //3.调用它的方法；
        Method methodShow=clazz.getMethod("show");//调用没有参数的方法；
        methodShow.invoke(person);
        Method methodDisplay=clazz.getMethod("disPlay", String.class);
        methodDisplay.invoke(person,"中国");


    }

    /**
     * 3. java.lang.Class是反射的源头；
     *      我们创建了一个类，通过编译（javac.exe），生成对应的.class字节码文件。
     *      之后我们使用java.exe加载（JVM的类加载器完成的） 此.class文件。（每个类对应的.class文件）
     *      .class文件加载到内存以后，就是一个运行时类即对应的Class对象，存在在缓存区。
     *      (1) 每一个Class对象只创建一次；
     *      (2)
     */
    public static void testReflectClass(){
        Person person=new Person();
        Class clazz= person.getClass();
        System.out.println(clazz);
    }

    /**
     * 4.获取Class对象的三种方式；
     */
    public void initReflectClass(){
        //1.通过运行时类的对象的方式获取；
        Person person=new Person();
        Class clazz1= person.getClass();
        System.out.println(clazz1.getName()+"  "+clazz1.toString());
        try {
            Person person1= (Person) clazz1.newInstance();
            System.out.println(person);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //2.通过当前类的静态属性class获取；
        Class clazz2=Person.class;
        System.out.println(clazz2.getName()+"  "+clazz2.toString());
        //3.通过Class类的静态方法forName(),传入目标类名的全路径获取；
        String string="com.wenwen.javareflect.Person";
        try {
            Class clazz3=Class.forName(string);
            System.out.println(clazz3.getName()+"  "+clazz3.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //4.通过类加载器ClassLoader(了解即可)；
        ClassLoader classLoader=this.getClass().getClassLoader();//zhe里
        try {
            Class clazz4=classLoader.loadClass(string);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
