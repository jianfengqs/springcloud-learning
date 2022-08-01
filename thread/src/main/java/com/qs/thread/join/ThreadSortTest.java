package com.qs.thread.join;

/**
 * 测试
 *
 * @author zhaijianfeng
 * @date 2022/07/28
 */
public class ThreadSortTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2");
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("thread3");
        });

//        thread1.start();
//        thread2.start();
//        thread3.start();

        thread1.start();

        // 让主线程等待子线程执行完成
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();


    }


}
