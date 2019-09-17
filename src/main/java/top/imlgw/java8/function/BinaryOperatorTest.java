package top.imlgw.java8.function;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author imlgw.top
 * @date 2019/9/17 23:26
 */
public class BinaryOperatorTest {
    //继承与BiFunction,BiFunction的特例,两个输入和返回都是相同的类型

    public static void main(String[] args) {
        System.out.println(compute(1, 2, (a, b) -> a + b));
        //返回less
        System.out.println(less(-231,442,(a,b)->a-b));
    }

    //少写两个泛型
    public static Integer compute(Integer a, Integer b, BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(a,b);
    }

    public static Integer less(Integer a, Integer b, Comparator<Integer> comparator){
        return BinaryOperator.minBy(comparator).apply(a,b);
    }
}
