package top.imlgw.java8.future_action;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author imlgw.top
 * @date 2019/9/24 18:54
 */
public class CompletableFutureTest4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random rand = new Random();
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5+rand.nextInt(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5 + rand.nextInt(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 200;
        });
        //谁先完成谁先打印
        future.applyToEither(future2, i -> i.toString()).whenComplete((r,e)-> System.out.println(r));
        //do other things
        while (true){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("i am do other things");
        }
    }
}
