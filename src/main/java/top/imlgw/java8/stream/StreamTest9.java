package top.imlgw.java8.stream;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author imlgw.top
 * @date 2019/9/21 17:15
 */
public class StreamTest9 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "hello world", "hello world welcome", "hello hello world welcome");
        //flapMap的R返回的是Stream,会把Stream中字符分割成数组打平,并且合并成一个流
        list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
        //也可以这样写
        list.stream().flatMap(s -> Arrays.stream(s.split(" "))).distinct().forEach(System.out::println);

        //求笛卡尔积
        List<String> list1 = Arrays.asList("hi", "hello", "nihao", "haha");
        List<String> list2 = Arrays.asList("imlgw ", "Resolmi ", "cyc ", "ycy ");
        System.out.println("================");
        //用map也可以解决,在map中再map
        //仔细想了下其实是错的
        list1.stream().map(s -> list2.stream().map(s1 -> s + "," + s1).collect(StringBuilder::new, StringBuilder::append,
                StringBuilder::append)).forEach(System.out::println);
        System.out.println("===============");
        //正确的做法用flatMap
        list1.stream().flatMap(s -> list2.stream().map(s1 -> s + "," + s1)).collect(Collectors.toList()).forEach(System.out::println);


        System.out.println("===============");
        //自己看的一点 Match
        System.out.println(list.stream().allMatch(s -> s.length() >3)); //true

        System.out.println(list.stream().anyMatch(s -> s.length() <3));//false

        System.out.println(list.stream().noneMatch(s -> s.length() <3));//true

        //The behavior of this operation is explicitly nondeterministic
        //这个操作作用和findFirst一样,但是这个不稳定,为了再并行流下有更好的性能
        System.out.println(list.stream().findAny().get());//true
    }
}
