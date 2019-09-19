package top.imlgw.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author imlgw.top
 * @date 2019/9/19 17:37
 */
public class StreamTest1 {
    public static void main(String[] args) {
        //创建Stream的方式
        Stream<String> hello = Stream.of("Hello", ",is me");
        String[] myArray=new String[]{"AA","dd"};
        Stream<String> myArray1 = Stream.of(myArray);
        Arrays.stream(myArray);

        List<String> list=new ArrayList<>();
        Stream<String> stream = list.stream();

        //使用
        IntStream.of(new int[]{5,6,7}).forEach(System.out::println);
        //[3,8) 左闭右开
        System.out.println("=============");
        IntStream.range(3,8).forEach(System.out::println);
        //[3,8]
        System.out.println("=============");
        IntStream.rangeClosed(3,8).forEach(System.out::println);

        //将list每个元素*2之后将结果加起来
        System.out.println("=============");
        List<Integer> integerList=Arrays.asList(1,2,3,4,5,6,7,8,9,10); //110
        //惰性求值,及早求值
        System.out.println(integerList.stream().map(integer -> integer * 2).reduce(0,Integer::sum));
        System.out.println(integerList.stream().mapToInt(integer -> integer * 2).sum());
    }
}
