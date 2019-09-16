package top.imlgw.java8.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author imlgw.top
 * @date 2019/9/16 18:38
 */
public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 test2=new FunctionTest2();

        System.out.println(test2.compute(2,value->value*3,value->value*value)); //12
        System.out.println(test2.compute2(2,value->value*3,value->value*value));//36

        System.out.println(test2.compute3(1,2,(v1,v2)->v1+v2)); //3
        System.out.println(test2.compute3(1,2,(v1,v2)->v1-v2)); //-1
        System.out.println(test2.compute3(1,2,(v1,v2)->v1*v2)); //2
        System.out.println(test2.compute3(1,2,(v1,v2)->v1/v2)); //0
        //BiFunction andThen
        System.out.println(test2.compute4(2,3,(v1,v2)->v1+v2,v3->v3*v3)); //25
    }

    public int compute(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        //return (V v) -> apply(before.apply(v));
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        //return (T t) -> after.apply(apply(t));
        return function1.andThen(function2).apply(a);
    }

    public int compute3(int a, int b, BiFunction<Integer,Integer,Integer> function){
        return  function.apply(a,b);
    }

    public int compute4(int a,int b,BiFunction<Integer,Integer,Integer> bifunction,Function<Integer,Integer> function){
        //BiFunction的第二个参数一定是 Function而不是BiFunction
        //因为BiFunction只有一个返回,这个返回将作为after的输入,所以肯定是Function
        return bifunction.andThen(function).apply(a,b);
        //正因为如此, BiFunction是没有compose方法的,compose会接受一个before Function的返回
        //作为调用者Function的输入,而BiFunction需要两个输入
    }
}
