package cn.com.think.date_20180301;

import java.lang.reflect.Method;

/**
 * @author dubooooo@126.com 2018-02-24
 */
public class ThreadTest {

    public static void main(String[] args) {
        test03();
    }

    public static void test03() {
        try {
            Thread t = new Thread(new Thread01());
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println("DefaultUncaughtExceptionHandler start");
                    System.out.println(t.getName());
                    System.out.println(e.getMessage());
                    System.out.println("DefaultUncaughtExceptionHandler end");
                }
            });
            t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println("UncaughtExceptionHandler start");
                    System.out.println(t.getName());
                    System.out.println(e.getMessage());
                    System.out.println("UncaughtExceptionHandler end");
                }
            });
            Method start0 = t.getClass().getDeclaredMethod("start0");
            start0.setAccessible(true);
            start0.invoke(t);
            Thread.sleep(3000);
            System.out.println("Thread sleep end");
            //t.join();
            synchronized (ThreadTest.class) {
                ThreadTest.class.notifyAll();
            }
            //while (true) {
            //    System.out.println(t.getState());
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test02() {
        try {
            System.out.println("before join");
            Thread.currentThread().join();
            System.out.println("after join");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test01() {
        new Thread(new Task(Thread.currentThread())).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main over");
    }

}

class Task implements Runnable {

    private Thread t;

    public Task(Thread t) {
        this.t = t;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.t.interrupt();
        System.out.println("task over");
    }
}

class Thread01 implements Runnable {

    @Override
    public void run() {
        synchronized (ThreadTest.class) {
            try {
                System.out.println(Thread.currentThread().getName() + " starting");
                ThreadTest.class.wait();
                System.out.println(Thread.currentThread().getName() + " over");
                throw new RuntimeException("RuntimeException");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}