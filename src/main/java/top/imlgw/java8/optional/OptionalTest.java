package top.imlgw.java8.optional;

import java.util.Optional;

/**
 * @author imlgw.top
 * @date 2019/9/18 17:02
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional=Optional.empty();
        Optional<String> optional2=Optional.ofNullable("imlgw");//允许为空,不为空
        Optional<String> optiona3=Optional.of(null); //这样在构造的时候就会报错

        /*if (optional.isPresent()){
            这样写不符合函数式编程的思想
            System.out.println(optional.get());
        }*/

        //推荐的Optional使用方式,函数式的思想
        //Optional很多时候用在返回值上,避免NPE
        optional.ifPresent(item-> System.out.println(item));//啥也不干

        System.out.println(optional.orElse("world")); //world

        System.out.println(optional.orElseGet(()->"Resolmi")); //Resolmi


    }
}
