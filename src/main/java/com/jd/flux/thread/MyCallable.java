package com.jd.flux.thread;

import java.util.concurrent.Callable;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: ${date} ${time}
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("111111111");
        return "Hello world!";
    }

}
