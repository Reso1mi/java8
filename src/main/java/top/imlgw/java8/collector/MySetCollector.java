package top.imlgw.java8.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * @author imlgw.top
 * @date 2019/9/21 23:50
 */
public class MySetCollector<T> implements Collector<T, Set<T>, Set<T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        //结果容器
        System.out.println("supplier invoke");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoke");
        //return (set,item)->set.add(item);
        return Set::add;
    }


    //合并并行流
    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoke");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    //
    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoke");
        //return t->t;
        return Function.identity();
    }


    //收集器的特性
    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoke");
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH,UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome","hello");
        Set<String> collect = list.stream().collect(new MySetCollector<>());
        System.out.println(collect);
    }
}
