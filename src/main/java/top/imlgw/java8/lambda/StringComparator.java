package top.imlgw.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author imlgw.top
 * @date 2019/9/15 17:46
 */
public class StringComparator {
    public static void main(String[] args) {
        List<String> names=Arrays.asList("zhangsan","lisi","zhaoliu","imlgw","wangwu");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        names.forEach(System.out::println);

        System.out.println("----------------");
        Collections.sort(names,(name1,name2)->name2.compareTo(name1));
        names.forEach(System.out::println);

        System.out.println("----------------");
        Collections.sort(names, Comparator.reverseOrder());
        names.forEach(System.out::println);
        //names.forEach(item-> System.out.println());
    }
}
