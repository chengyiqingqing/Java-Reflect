package reflectProxy;

/**
 * Created by sww on 2018/4/13.
 * 静态代理模式：
 *      1.创建一个接口，里面含有功能方法；
 *      2.创建一个被代理类，实现这个接口；重写该方法；
 *      3.创建一个代理类，也实现这个接口；
 *          重写该方法：前工作，功能，后工作；
 */

public class TestStaticProxy {
    public static void main(String[] args){
        NikeClothFactory nikeClothFactory=new NikeClothFactory();
        ProxyFactory proxyFactory=new ProxyFactory(nikeClothFactory);
        proxyFactory.productCloth();
    }
}

//1.设置接口；
interface ClothFactory{
    void productCloth();
}

//2.设置被代理对象实现接口，并重写接口方法；
class NikeClothFactory implements ClothFactory{

    @Override
    public void productCloth() {
        System.out.println("生产NikeCloth");
    }
}

//3.设置代理。在执行主体功能前后，添加附加功能；
class ProxyFactory implements ClothFactory{

    //1.先持有被代理类的对象,并通过构造函数初始化它；
    NikeClothFactory nikeClothFactory;
    public ProxyFactory(NikeClothFactory nikeClothFactory) {
        this.nikeClothFactory = nikeClothFactory;
    }

    @Override
    public void productCloth() {
        System.out.println("代理：添加一些代理费用");
        nikeClothFactory.productCloth();
        System.out.println("代理：做一些售后服务");
    }

}
