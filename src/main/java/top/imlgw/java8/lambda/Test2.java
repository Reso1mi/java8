package top.imlgw.java8.lambda;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author imlgw.top
 * @date 2019/9/14 20:47
 */
public class Test2 {
    private static AtomicInteger MAX = new AtomicInteger(0);

    private static int MAX_2 = 0;

    public static void main(String[] args) {
/*        new Thread(() -> {
            while (MAX.get() < 100) {
                System.out.println(Thread.currentThread().getName() + "," + MAX.incrementAndGet());
            }
        }).start();

        new Thread(() -> {
            while (MAX.get() < 100) {
                System.out.println(Thread.currentThread().getName() + "," + MAX.incrementAndGet());
            }
        }).start();

        new Thread(() -> {
            while (MAX.get() < 100) {
                System.out.println(Thread.currentThread().getName() + "," + MAX.incrementAndGet());
            }
        }).start();*/


        new Thread(() -> {
            print100();
        }).start();

        new Thread(() -> {
            print100();
        }).start();

        new Thread(() -> {
            print100();
        }).start();
    }

    public synchronized static void print100()  {
        while (MAX_2 < 100) {
            System.out.println(Thread.currentThread().getName()+","+MAX_2++);
            Test2.class.notifyAll();
            try {
                Test2.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
