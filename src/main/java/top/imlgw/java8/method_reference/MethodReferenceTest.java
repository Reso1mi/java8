package top.imlgw.java8.method_reference;

import java.util.Arrays;
import java.util.List;

/**
 * @author imlgw.top
 * @date 2019/9/18 20:24
 */
public class MethodReferenceTest {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("hello","world",",Resolmi");
        list.forEach(item->System.out.println(item));
        //方法引用, 我们可以将方法引用看作是一个【函数指针】,参数自动传入
        list.forEach(System.out::println);
    }
}
