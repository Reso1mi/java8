package top.imlgw.java8.function;

import java.util.function.Function;

/**
 * @author imlgw.top
 * @date 2019/9/15 21:01
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest functionTest=new FunctionTest();
        //函数传递,不用预先定义参数的行为
        //让参数具有行为
        System.out.println(functionTest.compute(1,value->value*2));
        System.out.println(functionTest.compute(2,value->value+5));
        System.out.println(functionTest.compute(3,value->value*value));
        System.out.println(functionTest.convert(4,value-> String.valueOf(value+" Hello")));
        //functionTest.reduce(5,a->{a--});
        Function<Integer,Integer> function=value->value*2;

    }

    /*
    * 高阶函数: 接收函数作为参数,或者返回一个函数作为返回值
    * */

    //参数的行为由Function参数获得
    //Function<InputType,OutputType>
    public int compute(int a, Function<Integer,Integer> function){
        int result=function.apply(a);
        return result;
    }

    //对比一下, 就会发现上面的方式确实hin优雅
    public int method1(int a){
        return  a*2;
    }

    public int method2(int a){
        return  a+5;
    }

    public int method3(int a){
        return  a*a;
    }

    public String convert(int a,Function<Integer,String> function){
        return function.apply(a);
    }

    public void reduce(int a,Function<Integer,Void> function){
        function.apply(a);
    }
}
