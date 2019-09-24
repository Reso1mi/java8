package top.imlgw.java8.future_action;

import java.util.Optional;
import java.util.concurrent.*;

/**
 * @author imlgw.top
 * @date 2019/9/23 21:38
 */
public class CompletableFutureTest1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //很少会直接new出来用
        CompletableFuture<Double> completableFuture=new CompletableFuture();
        new Thread(()->{
            double v = get();
            completableFuture.complete(v);
        }).start();
        System.out.println("no block");
        //Optional.ofNullable(completableFuture.get()).ifPresent(System.out::println);

        completableFuture.whenComplete((num,ex)-> {
            Optional.ofNullable(num).ifPresent(System.out::println);
            Optional.ofNullable(ex).ifPresent(e->e.printStackTrace());
        });

/*        while (true){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("i am other things");
        }*/
        /*Executor executor=Executors.newFixedThreadPool(1, r->{
            Thread t=new Thread(r);
            t.setDaemon(true);
            return t;
        });
        executor.execute(()->{
            System.out.println("test");
        });*/
    }

    private static  double get(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 99.0;
    }
}
