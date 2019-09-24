package top.imlgw.java8.future_action;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author imlgw.top
 * @date 2019/9/23 20:56
 * 模拟CompleteFuture
 */
public class FutureInAction2 {
    public static void main(String[] args) throws InterruptedException {
        MyFuture<String> future= invoke(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                return "finish";
            } catch (InterruptedException e) {
                return "error!!!";
            }
        });

        future.setCompletable(new MyCompletable<String>() {

            //回调函数
            @Override
            public void complete(String s) {
                System.out.println(s);
            }

            //异常回调
            @Override
            public void exception(Throwable throwable) {
                System.out.println(throwable);
            }
        });

        while (true){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("i am do other things");
        }
    }

    private static <T> MyFuture<T> invoke(MyCallable<T> callable) {
        AtomicReference<T> result = new AtomicReference();
        AtomicBoolean finished = new AtomicBoolean();

        MyFuture<T> future = new MyFuture<T>() {
            private MyCompletable<T> completable;

            @Override
            public T get() {
                return result.get();
            }

            @Override
            public boolean isDone() {
                return finished.get();
            }

            @Override
            public void setCompletable(MyCompletable<T> completable) {
                this.completable=completable;
            }

            @Override
            public MyCompletable<T> getCompletable() {
                return completable;
            }
        };

        Thread t = new Thread(() -> {
            try {
                T action = callable.action();
                result.set(action);
                finished.set(true);
                if (future.getCompletable()!=null){
                    //执行完成后执行回调
                    future.getCompletable().complete(action);
                }
            } catch (Throwable throwable) {
                if (future.getCompletable()!=null){
                    future.getCompletable().exception(throwable);
                }
            }
        });

        t.start();

        return future;
    }

    private interface MyFuture<T> {
        T get();

        boolean isDone();

        void setCompletable(MyCompletable<T> completable);

        MyCompletable<T> getCompletable();
    }


    @FunctionalInterface
    private interface MyCallable<T> {
        T action();
    }

    private interface MyCompletable<T> {
        void complete(T t);

        void exception(Throwable throwable);
    }

}
