package top.imlgw.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author imlgw.top
 * @date 2019/9/15 16:19
 */
public class Test4 {
    public static void main(String[] args) {
        //Runnable接口
        new Thread(() ->
                System.out.println("Runnable")
        ).start();

        //转换为大写并输出
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.forEach(str -> System.out.println(str.toUpperCase()));
        System.out.println(list);
        System.out.println("forEach---------------");
        //转换为大写并存储到另一个list
        List<String> temp = new ArrayList<>();
        list.forEach(str -> temp.add(str.toUpperCase()));
        temp.forEach(str -> System.out.println(str));

        //stream
        System.out.println("stream----------------");
        list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
        //方法引用
        System.out.println("方法引用---------------");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        //toUpperCase是实例方法,参数就是this,这一点可以参考我之前的JVM字节码相关的方法表相关内容
        Function<String,String> function=String::toUpperCase;
        System.out.println(function);


    }
}
