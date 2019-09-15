package top.imlgw.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author imlgw.top
 * @date 2019/9/14 17:30
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("---------");
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("---------");
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("---------");
        list.forEach(integer -> System.out.println(integer));

        //方法引用创建实例
        System.out.println("---------");
        list.forEach(System.out::println);

    }
}
