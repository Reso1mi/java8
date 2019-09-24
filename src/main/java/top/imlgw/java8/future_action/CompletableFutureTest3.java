package top.imlgw.java8.future_action;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author imlgw.top
 * @date 2019/9/24 18:22
 */
public class CompletableFutureTest3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture.supplyAsync(CompletableFutureTest3::get, executorService).thenApply(CompletableFutureTest3::multiply)
                .whenComplete((v, ex) -> Optional.ofNullable(v).ifPresent(System.out::println));

    }

    private static double get() {
        try {
            System.out.println(Thread.currentThread().isDaemon()); //default true
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 99.0;
    }

    private static double multiply(double value) {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value * 10;
    }
}
