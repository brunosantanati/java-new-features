package me.bruno.santana.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFutureResultObj1 = CompletableFuture.supplyAsync(() -> "Hello").thenApply(hello -> hello + "World");
        CompletableFuture<String> completableFutureResultObj2 = getHello().thenCompose(hello -> getHelloWorld(hello));

        System.out.println(completableFutureResultObj1.get());
        System.out.println(completableFutureResultObj2.get());
    }

    private static CompletableFuture<String> getHello() {
        return CompletableFuture.supplyAsync(() -> "Hello");
    }

    private static CompletableFuture<String> getHelloWorld(String hello) {
        return CompletableFuture.supplyAsync(() -> hello + " World");
    }

}