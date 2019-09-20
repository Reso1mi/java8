package top.imlgw.java8.stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author imlgw.top
 * @date 2019/9/20 14:20
 */
public class StreamTest3 {
    public static void main(String[] args) {
        Stream<String> stream= Stream.of("hello", "Resolmi", "John");
        Stream<String> stream1= Stream.of("hello", "Resolmi", "John");
        //Collectors.toList()默认是ArrayList下面的方法可以指定任意的List
        LinkedList<String> collect = stream.collect(Collectors.toCollection(LinkedList::new));
        collect.forEach(System.out::println);

        //TreeSet<String> collect = stream.collect(Collectors.toCollection(TreeSet::new));
        //collect.forEach(System.out::println);

        //将stream中的字符串拼接起来
        String collect1 = stream1.collect(Collectors.joining());
        System.out.println(collect1);
    }
}
