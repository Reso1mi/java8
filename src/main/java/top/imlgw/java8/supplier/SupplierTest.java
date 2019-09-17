package top.imlgw.java8.supplier;

import java.util.function.Supplier;

/**
 * @author imlgw.top
 * @date 2019/9/17 23:03
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier=()->"hello world";
        System.out.println(supplier.get());
    }
}
