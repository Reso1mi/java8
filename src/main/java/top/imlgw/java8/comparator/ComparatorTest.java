package top.imlgw.java8.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author imlgw.top
 * @date 2019/9/21 21:41
 */
public class ComparatorTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihaodd", "ass", "fuck", "wodasd");
        Collections.sort(list);
        //字符串 自然升序
        System.out.println(list);// [ass, fuck, nihaodd, wodasd]
        //list.stream().sorted(String::compareTo).forEach(System.out::println);

        System.out.println("================");
        //升序
        Collections.sort(list,(str,str2)->str.length()-str2.length());
        System.out.println(list);// [ass, fuck, wodasd, nihaodd]

        System.out.println("================");
        //降序
        Collections.sort(list,(str,str2)->str2.length()-str.length());
        System.out.println(list); //[nihaodd, wodasd, fuck, ass]

        System.out.println("================");
        //有具体的一定要使用具体的
        //comparingInt默认是升序的,可以用reversed()逆序
        Collections.sort(list,Comparator.comparingInt(String::length).reversed());
        System.out.println(list); // [nihaodd, wodasd, fuck, ass]

        System.out.println("================");
        //lambda表达式类型推断不了,离上下文太远了,必须要指明参数类型
        //把reversed()去掉之后就可以通过编译,因为最后的Comparable是reversed()返回的
        Collections.sort(list,Comparator.comparingInt((String s)->s.length()).reversed()); // [nihaodd, wodasd, fuck, ass]
        System.out.println(list);

    }
}
