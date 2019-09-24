package top.imlgw.java8.future_action;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author imlgw.top
 * @date 2019/9/23 17:29
 */
public class FutureInAction {
    public static void main(String[] args) throws InterruptedException {
        MyFuture<String> future= invoke(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                return "i am finished";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "error";
            }
        });
        System.out.println(future.get());
        System.out.println(future.get());
        System.out.println(future.get());
        while (!future.isDone()){
            TimeUnit.SECONDS.sleep(5);
        }
        System.out.println(future.get());
    }

    private static <T> MyFuture<T> invoke(MyCallable<T> callable){
        AtomicReference<T> result=new AtomicReference();
        AtomicBoolean finished= new AtomicBoolean();
        Thread t=new Thread(()->{
            T action = callable.action();
            result.set(action);
            finished.set(true);
        });

        t.start();
        MyFuture<T> future=new MyFuture<T>(){

            @Override
            public T get() {
                return result.get();
            }

            @Override
            public boolean isDone() {
                return finished.get();
            }
        };
        return future;
    }

    private interface MyFuture<T>{
        T get();

        boolean isDone();
    }

    @FunctionalInterface
    private interface MyCallable<T>{
        T action();
    }
}
