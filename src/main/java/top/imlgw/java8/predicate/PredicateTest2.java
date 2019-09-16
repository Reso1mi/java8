package top.imlgw.java8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author imlgw.top
 * @date 2019/9/16 22:22
 */
public class PredicateTest2 {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //找出所有的偶数
        list.stream().filter(integer -> integer%2==0).forEach(System.out::println);
        System.out.println("===========");
        //找出所有大于5的数
        list.stream().filter(integer -> integer>5).forEach(System.out::println);
        System.out.println("===========");
        List<Integer> collect = list.stream().filter(integer -> integer > 5).collect(Collectors.toList());
        System.out.println(collect);
    }
}
