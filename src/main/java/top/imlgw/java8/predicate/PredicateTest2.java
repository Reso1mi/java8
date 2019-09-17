package top.imlgw.java8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author imlgw.top
 * @date 2019/9/16 22:22
 */
public class PredicateTest2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //找到所有的奇数
        conditionFilter(list, integer -> integer % 2 != 0).forEach(System.out::println);
        System.out.println("===========");
        //找出所有的偶数
        conditionFilter(list, integer -> integer % 2 == 0).forEach(System.out::println);
        System.out.println("===========");
        //找出所有大于5的数
        //list.stream().filter(integer -> integer>5).forEach(System.out::println);
        conditionFilter(list, integer -> integer > 5).forEach(System.out::println);
        System.out.println("===========");
        /*List<Integer> collect = list.stream().filter(integer -> integer > 5).collect(Collectors.toList());
        System.out.println(collect);*/
        //返回所有小于3的数
        conditionFilter(list, integer -> integer < 3).forEach(System.out::println);
        System.out.println("===========");
        //返回所有
        conditionFilter(list, integer -> true).forEach(System.out::println);
        System.out.println("===========");
        //啥也不返回
        conditionFilter(list, integer -> false).forEach(System.out::println);
        System.out.println("===========");
        //predicate.add(predicate2);
        conditionFilter2(list, integer -> integer > 5, integer -> integer % 2 == 0).forEach(System.out::println);
        System.out.println("==========");
        //isEqual
        System.out.println(isEqual("imlgw").test("imlgw"));
    }

    public static List<Integer> conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        /*for (Integer integer : list) {
            //这个test就是你的lambda实现
            if (predicate.test(integer)){
                System.out.println(integer);
            }
        }*/
        return list.stream().filter(predicate).collect(Collectors.toList());
    }


    public static List<Integer> conditionFilter2(List<Integer> list, Predicate<Integer>
            predicate, Predicate<Integer> predicate2) {
        return list.stream().filter(predicate.and(predicate2).negate()).collect(Collectors.toList());
    }

    public static Predicate<String> isEqual(Object object) {
        /*
        *
        *     static <T> Predicate<T> isEqual(Object targetRef) {
                    return (null == targetRef) ?
                        Objects::isNull : object -> targetRef.equals(object);
                    返回的也是一个 Predicate 如果参数不为空的话就是 object -> targetRef.equals(object)
                    这样的lambda,底层也还是借助的对象本身的equals方法,只不过封装了一下
              }
        * */
        return Predicate.isEqual(object);
    }
}
