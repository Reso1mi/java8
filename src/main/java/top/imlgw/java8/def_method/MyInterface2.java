package top.imlgw.java8.def_method;

/**
 * @author imlgw.top
 * @date 2019/9/19 15:57
 */
public interface MyInterface2 {
    default void myMethod(){
        System.out.println("MyInterface2");
    }
}
