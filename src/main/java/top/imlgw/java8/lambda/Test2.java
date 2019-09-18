package top.imlgw.java8.lambda;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author imlgw.top
 * @date 2019/9/14 20:47
 */
public class Test2 {
    private  static AtomicInteger MAX_1 = new AtomicInteger(0);

    private static int MAX_2 = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            print1002();
        }).start();

        new Thread(() -> {
            print1002();
        }).start();

        new Thread(() -> {
            print1002();
        }).start();


    }

    public synchronized static void print100()  {
        while (MAX_2 < 500) {
            System.out.println(Thread.currentThread().getName()+","+MAX_2++);
            Test2.class.notifyAll();
            try {
                Test2.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //。。。。。。。。。。。。
    public synchronized static void print1002()  {
        while (MAX_1.get() < 1000) {
            try {
                TimeUnit.MICROSECONDS.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+MAX_1.incrementAndGet());
        }
    }
}
