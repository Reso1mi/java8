package top.imlgw.java8.predicate;

import java.util.function.BiPredicate;

/**
 * @author imlgw.top
 * @date 2019/9/17 23:57
 */
public class BiPredicateTest {
    public static void main(String[] args) {
        System.out.println(compare(2323,33124,(a,b)->a.toString().length()>b.toString().length()));
    }

    
    public static boolean compare(Integer a, Integer b, BiPredicate<Integer,Integer> biPredicate){
        return biPredicate.test(a,b);
    }
}
