package org.hg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args){
        List<String> names = Arrays.asList("Jim","Tom","Jack","Mark");
        List<CompletableFuture> futures = new ArrayList<>();
        for(String name:names){
            CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{System.out.println(name);return name;});
            futures.add(future);
        }
        for(CompletableFuture f:futures){
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
