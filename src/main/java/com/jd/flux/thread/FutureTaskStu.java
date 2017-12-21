package com.jd.flux.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: ${date} ${time}
 */
public class FutureTaskStu extends FutureTask {


    public FutureTaskStu(Callable callable) {
        super(callable);
    }

//    @Override
//    public void run() {
//        System.out.println("1111");
//    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTaskStu task = new FutureTaskStu(() -> {

            System.out.println("2222");

            return "789";
        });

//        new Thread(task).start();
//        Thread.currentThread().join();

        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();

        String hello = futureTask.get();

        System.out.println(hello);

//        Thread.currentThread().join();
    }


}
