package top.imlgw.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author imlgw.top
 * @date 2019/9/20 17:43
 */
public class StreamTest6 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "resolmi", "imlgw");
        //list.stream().map(str->str.substring(0,1).toUpperCase()+str.substring(1)).forEach(System.out::println);

        //中间操作都是惰性求值的,只有遇到 终止操作/及早求值 的时候才会执行
        list.stream().map(str -> {
            String res = str.substring(0, 1).toUpperCase() + str.substring(1);
            System.out.println("test");
            return res;
        });

        //这样写就会执行map中的方法
        /*
          test
          Hello
          test
          World
          test
          Resolmi
          test
          Imlgw
        */
        list.stream().map(str -> {
            String res = str.substring(0, 1).toUpperCase() + str.substring(1);
            System.out.println("test");
            return res;
        }).forEach(System.out::println);

        System.out.println("=============");
        //下面的是有问题的,distinct()会一直等待前面的输出,认为会有不同的出现,并不知道前面只会输出1
        //IntStream.iterate(0,i->i).distinct().limit(6).forEach(System.out::println);
        //改成这样就没问题,先限制数量再去重
        IntStream.iterate(0, i -> i).limit(6).distinct().forEach(System.out::println);
    }
}
