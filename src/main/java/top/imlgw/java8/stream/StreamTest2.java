package top.imlgw.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author imlgw.top
 * @date 2019/9/19 20:26
 */
public class StreamTest2 {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("Hello", "is me", "Stream");
        Stream<String> stringStream1 = Stream.of("Hello", "world", "Stream1");
        Stream<String> stringStream2 = Stream.of("Hello", "hahahahahah", "Stream2");
        Stream<String> stringStream3 = Stream.of("Hello", "hahahahahah", "Stream3");


        //Object[] objects = stringStream.toArray(len->new String[len]);

        Object[] objects = stringStream.toArray(String[]::new);
        Arrays.asList(objects).forEach(System.out::println);
        System.out.println("=========");

        List<String> collect = stringStream1.collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("=========");

        //根源的方法,等价于上面的
        //第一个参数Supplier不接收参数返回一个结果容器,这里就是list
        //第二个参数将Stream流的每一项添加到另一个list中
        //第三个参数将一个list添加到结果list中（看起来有点多余,可能是为了并行流设计的）
        ArrayList<Object> collect1 = stringStream2.collect(() -> new ArrayList<>(),
                (thelist, item) -> thelist.add(item), (list1, list2) -> list1.add(list2));
        collect1.forEach(System.out::println);
        System.out.println("=========");

        //方法引用,更加难懂了哈哈哈
        ArrayList<Object> collect2 = stringStream3.collect(ArrayList::new,
                ArrayList::add, ArrayList::addAll);
        collect2.forEach(System.out::println);
        System.out.println("=========");

        //官方文档里面的例子
        Stream<String> resolmi = Stream.of("R", "E", "S", "O", "L", "M", "I");
        String string = resolmi.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        System.out.println(string);
    }
}
