package top.imlgw.java8.predicate;

import java.util.function.Predicate;

/**
 * @author imlgw.top
 * @date 2019/9/16 22:07
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate=p->p.length()>5;
        System.out.println(predicate.test("Hello World")); //true
    }
}
