package me.bruno.santana.java8;

import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> futureObj = Executors.newSingleThreadExecutor().submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            return "Hello World!";
        });

        while (!futureObj.isDone()) {
            System.out.println("Result hasn't yet returned");
        }

        System.out.println("Result -> " + futureObj.get());
    }

}
