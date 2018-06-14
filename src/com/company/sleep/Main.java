package com.company.sleep;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SleepyThread sleepyThread = new SleepyThread();
        sleepyThread.start();

        while (sleepyThread.isAlive()) {
            sleepyThread.interrupt();
            Thread.sleep(5_000);
            System.out.println("sleepyThread.isInterrupted: " +
                    sleepyThread.isInterrupted());
        }
    }
}

class SleepyThread extends Thread {
    private Date start = new Date();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                System.out.println();
            } catch (InterruptedException e) {
                System.out.println("Пытались разбудить - не вышло");
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
            /*
            Date endDate = new Date();
            if ((endDate.getTime() - start.getTime()) > 3_000) {

                System.out.println("IsInterrupted(): " + Thread.currentThread().isInterrupted());
                start = new Date();
            }
            */

        }
    }
}
