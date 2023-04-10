package me.bruno.santana.java8.completable.future;

import java.util.concurrent.*;

public class CompletableFutureDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> futureObj = new CompletableFuture<>();

        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            futureObj.complete("Hello World");
        });

        while (!futureObj.isDone()) {
            System.out.println("Result hasn't yet returned");
        }

        System.out.println("Result -> " + futureObj.get());

    }

}
