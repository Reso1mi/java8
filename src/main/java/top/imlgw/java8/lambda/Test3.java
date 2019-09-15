package top.imlgw.java8.lambda;

/**
 * @author imlgw.top
 * @date 2019/9/14 21:52
 */
@FunctionalInterface
interface MyInterface{
     void test();

     //继承过来的,不算抽象方法
     String toString();
}

public class Test3 {
    public static void main(String[] args) {
        Test3 test3=new Test3();
        test3.myTest(()->{
            System.out.println("myTest");
        });
        System.out.println("-------------");

        MyInterface myInterface=()->{
            System.out.println("imlgw.top");
        };

        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);
    }

    public  static void myTest(MyInterface myInterface){
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }
}
