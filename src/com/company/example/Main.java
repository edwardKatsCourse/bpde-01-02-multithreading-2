package com.company.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Thread> threads = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            threads.add(new ГлухойТред(i+1));
            threads.add(new ПослушныйТред(i+1));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        Thread.sleep(10_000);
        for (Thread thread : threads) {
            thread.interrupt();
        }

        Thread.sleep(1000);
        threads
                .stream()
                .filter( x-> x.isAlive())
                .forEach(x -> x.getClass().getSimpleName());

        for (Thread thread : threads) {
            thread.stop();
        }
    }
}
