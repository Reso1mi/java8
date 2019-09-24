package top.imlgw.java8.future_action;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author imlgw.top
 * @date 2019/9/24 19:03
 */
public class CompletableFutureTest5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random rand = new Random();
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5+ rand.nextInt(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5 + rand.nextInt(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        //CompletableFuture<Void> f =  CompletableFuture.allOf(future1,future2);

        //任意一个完成后就返回,applyToEither有点像它的特例
        CompletableFuture<Object> f = CompletableFuture.anyOf(future1, future2)
                .whenComplete((r,e)-> System.out.println(r));

        while (true){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("i am do other things");
        }
    }
}
