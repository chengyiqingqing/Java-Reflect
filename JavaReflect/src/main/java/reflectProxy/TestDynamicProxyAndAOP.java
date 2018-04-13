package reflectProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by sww on 2018/4/13.
 *  1.动态代理增加通用的方法。
 *  2.回调目标对象的方法
 *  3.动态代理增加的通用的方法
 */

public class TestDynamicProxyAndAOP {

    public static void main(String[] args){
        TargetSubject targetSubject = new TargetSubject();
        Subject myProxySubject= (Subject) MyProxy.getProxyInstance(targetSubject);
        myProxySubject.action();
    }

}

interface Subjects{
    void action();
    void print();
}

class TargetSubjects implements Subjects{
    @Override
    public void action() {
        System.out.println("targetSubject:action 执行");
    }

    public void print(){
        System.out.println("print 执行");
    }
}

class MyInvokeHandlerAOP implements InvocationHandler {

    Object object;

    public void setObject(Object obj){
        this.object=obj;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        ProxyUtils.method1();
        Object returnValue= method.invoke(object,args);
        ProxyUtils.method2();
        return returnValue;
    }

}

class ProxyUtils{

    public static void method1(){
        System.out.println("print method1");
    }
    public static void method2(){
        System.out.println("print method2");
    }

}

class MyProxy{

    public static Object getProxyInstance(Object obj){
        MyInvokeHandlerAOP myInvokeHandlerAOP=new MyInvokeHandlerAOP();
        myInvokeHandlerAOP.setObject(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),myInvokeHandlerAOP);
    }

}