package top.imlgw.java8.stream;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author imlgw.top
 * @date 2019/9/20 14:31
 */
public class StreamTest4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "Resolmi", "imlgw");
        /*List<String> res=new ArrayList<>();
        list.stream().forEach(item-> res.add(item.toUpperCase()));
        res.forEach(System.out::println);*/
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("==============");

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        integerList.stream().map(integer -> integer*integer).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("==============");
        //扁平化,将所有的list合并为一个流
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
        listStream.flatMap(lis->lis.stream().map(integer -> integer*integer)).collect(Collectors.toList()).forEach(System.out::println);
    }
}
