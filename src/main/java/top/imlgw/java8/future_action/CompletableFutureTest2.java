package top.imlgw.java8.future_action;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author imlgw.top
 * @date 2019/9/23 22:17
 */
public class CompletableFutureTest2 {
    public static void main(String[] args) throws InterruptedException {
        //题外话,线程池工程方法设置线程默认为后台线程
        Executor executor=Executors.newFixedThreadPool(1, r->{
            Thread t=new Thread(r);
            //默认就是false
            //t.setDaemon(false);
            return t;
        });
        //重载的方法可以传入一个Executor
        CompletableFuture.supplyAsync(CompletableFutureTest2::get,executor).whenComplete((num, ex)->{
            Optional.ofNullable(num).ifPresent(System.out::println);
            Optional.ofNullable(ex).ifPresent(e->e.printStackTrace());
        });
        //直接这样会没有结果,因为主线程结束了,而Completable里面的线程是守护线程
        System.out.println("i am do  other things");
        /*while (true){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("i am do  other things");
        }*/
    }

    private static  double get(){
        try {
            System.out.println(Thread.currentThread().isDaemon()); //default true
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 99.0;
    }
}
