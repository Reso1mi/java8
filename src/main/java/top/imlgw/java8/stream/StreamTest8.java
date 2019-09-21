package top.imlgw.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author imlgw.top
 * @date 2019/9/21 16:41
 */
public class StreamTest8 {
    public static void main(String[] args) {
        //找出长度为5的并且将长度打出来
        List<String> list1 = Arrays.asList("hello", "world", "Resolmi");
        //不好
        list1.stream().filter(s -> s.length()==5).limit(1).forEach(s -> System.out.println(s+","+s.length()));
        //这样会好一些
        list1.stream().filter(s -> s.length()==5).findFirst().ifPresent(s-> System.out.println(s+","+s.length()));


        //上面都是引子,这里才是重点
        list1.stream().mapToInt(item->{
            int length=item.length();
            System.out.println(item);
            return  length;
        }).filter(len->len==5).findFirst().ifPresent(System.out::println);
        //上面打印的结果只有 mapToInt()中的sout只输出了hello

        //这一点其实很多人不太理解,其实StreamTest6中就已经提到过
        //流本身和操作是一起的,可以理解为流提供了一个容器,然后会将我们的操作都放到容器中
        //然后对流中的每个元素都依次执行这些操作, 类似：第一个元素执行第一个操作,执行第二个操作,第三个操作....第二个元素执行第一个操作....
        //而不是想当然的：对第一个元素执行第一个操作,然后对第二个元素执行第一个操作....对n个元素执行第一个操作,对第一个元素执行第二个操作......
        //先不说这样正确与否,效率上就很有问题了,显然JDK的工程师不会这样设计

        //既然会对没个元素都执行所有的操作,那为什么只输出了Hello呢?
        //因为流是具有短路的功能的
        //这里需要的是length==5的第一个,而 hello恰好长度为5并且是第一个,所以就直接返回了,后面的就不会再执行

        //这里将hello改为hello1
        //输出结果将为hello1和world
        System.out.println("=================");
        List<String> list2 = Arrays.asList("hello1", "world", "Resolmi");
        list2.stream().mapToInt(item->{
            int length=item.length();
            System.out.println(item);
            return  length;
        }).filter(len->len==5).findFirst().ifPresent(System.out::println);
    }
}
