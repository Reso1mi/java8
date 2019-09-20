package top.imlgw.java8.stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author imlgw.top
 * @date 2019/9/20 16:44
 */
public class StreamTest5 {
    public static void main(String[] args) {
        //supplier生成流
        Stream<String> generate = Stream.generate(UUID.randomUUID()::toString);
        generate.findFirst().ifPresent(System.out::println);

        //无限流,加limit限制
        Stream<Integer> integerStream= Stream.iterate(1, item -> item + 2).limit(8);
        Stream<Integer> integerStream2= Stream.iterate(1, item -> item + 2).limit(8);
        Stream<Integer> integerStream3= Stream.iterate(1, item -> item + 2).limit(8);
        Stream<Integer> integerStream4= Stream.iterate(1, item -> item + 2).limit(8);

        integerStream.forEach(System.out::println);
        //1,3,5,7,9,11,13,15
        System.out.println("=====================");


        //找出流中大于2的元素,然后将每个元素*2,然后忽略掉前两个元素,然后再取前两个元素,最后求这两个元素的和
        //mapToInt不会自动装箱,只针对int,会有一些针对int的方法比如这里的sum()
        //其实这些操作的中间操作都是返回都是一个新的Stream,只有在调用了终止操作(比如这里的sum)后才返回我们需要的结果
        int sum = integerStream2.filter(i -> i > 2).mapToInt(i -> i * 2).skip(2).limit(2).sum();
        System.out.println(sum); //32
        System.out.println("=====================");


        //这里的min()/max()也是IntStream中的方法,返回结果是OptionalInt
        //其实很好理解,经过一系列的中间操作后流可能空了,所以min和max是没有值的,而sum()就只需要返回0就行了
        //别忘了ifPresent
        integerStream3.mapToInt(i -> i).max().ifPresent(System.out::println);
        System.out.println("=====================");


        IntSummaryStatistics intSummaryStatistics = integerStream4.filter(i -> i > 2).mapToInt(i -> i * 2).skip(2)
                .limit(2).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax()); //18
        System.out.println(intSummaryStatistics.getMin()); //14
        System.out.println(intSummaryStatistics.getAverage()); //16.0
        System.out.println(intSummaryStatistics.getCount());//2

        //无限流
        Stream<Integer> integerStream5= Stream.iterate(1, item -> item + 2).limit(8);
        System.out.println(integerStream5);
        System.out.println(integerStream5.filter(integer -> integer>2));
        //去重,在这里会报错, stream has already been operated upon or closed
        //上面已经调用了integerStream5.filter这里再调用integerStream5的distinct
        //System.out.println(integerStream5.distinct());

    }
}
