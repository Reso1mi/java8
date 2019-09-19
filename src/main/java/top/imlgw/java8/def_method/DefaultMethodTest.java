package top.imlgw.java8.def_method;

/**
 * @author imlgw.top
 * @date 2019/9/19 15:57
 */
public class DefaultMethodTest extends MyInterfaceSub implements MyInterface{
    public static void main(String[] args) {
        DefaultMethodTest defaultMethodTest = new DefaultMethodTest();
        defaultMethodTest.myMethod();
    }

    /*
    //继承了两个所以必须重写
    @Override
    public void myMethod() {
        MyInterface2.super.myMethod();
    }*/
}
