package reflectProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by sww on 2018/4/13.
 * 动态代理模式：
 *      1.设置接口；
 *      2.设置被代理类；实现接口；
 *      3.自定义一个InvokeHandler;
 *          设置Object obj "被代理对象"， 初始化并返回"代理对象"
 *          实现invoke方法；
 *      静态代理：
 *          特点是被代理对象和代理对象实现相同的接口，并且代理对象含有被代理对象的实例。
 *          负责在调用被代理对象方法之前，添加一些额外的附加操作。
 *      动态代理：
 *          特点是在程序运行时，根据被代理类机器实现接口，动态的创建一个代理类。
 *          当调用代理类实现的抽象方法invoke时，就发起对代理类同样的方法的调用。
 */

interface Subject{
    void action();
    void print();
}

class TargetSubject implements Subject{
    @Override
    public void action() {
        System.out.println("targetSubject:action 执行");
    }

    public void print(){
        System.out.println("print 执行");
    }
}

class MyInvokeHandler implements InvocationHandler{

    Object object;
    public Object blind(Object obj){
        this.object=obj;
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(), //当前obj“被代理对象的类加载器”
                obj.getClass().getInterfaces(),  //被代理对象的实现方法们。
                this);     //当前MyInvokeHandler对象；
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        Object returnValue= method.invoke(object,args);
        return returnValue;
    }

}


public class TestDynamicProxy {

    public static void main(String[] args){
        //1.创建被代理类对象；
        TargetSubject targetSubject=new TargetSubject();
        //2.创建InvocationHandler对象,并通过其获取动态代理对象；
        MyInvokeHandler myInvokeHandler=new MyInvokeHandler();
        //3.调用target对象的方法。它会自动执行代理类的invoke方法。
        Subject proxyTarget= (Subject) myInvokeHandler.blind(targetSubject);
        proxyTarget.action();
        proxyTarget.print();

        NikeClothFactory nikeClothFactory=new NikeClothFactory();
        ClothFactory proxyClothFactory= (ClothFactory) myInvokeHandler.blind(nikeClothFactory);
        proxyClothFactory.productCloth();


    }



}
