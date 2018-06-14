package com.company.interruption;

public class InterruptionExample {
    /**
     * 1. Thread interruption (прерывание тредов)
     * 2. Thread cache (common resources vs thread local variables)
     * 3. volatile and synchronized
     *
     * this         thread local variables
     * static       volatile
     */

    public static void main(String[] args) throws InterruptedException {

        MyThread thread = new MyThread("Дочерний тред");
//        thread.setDaemon(true);
        thread.start();
        System.out.println("Я ухожу. Жду 2 секунды..");
        Thread.sleep(2000);
        System.out.println("Прерывайся!");
        thread.interrupt();

        System.out.println("Жду секунду и всёё");
        Thread.sleep(1000);

        //если ребенок не закончил - закончу сам!
        if (thread.isAlive()) {
            System.out.println("Прерываю жестко!");
            thread.stop();
        }
        System.out.println("Закрываю квартиру!");

        //boolean isInterrupted
//        thread.interrupt(); -> isInterrupted = true


//        thread.isInterrupted();
//        thread.isAlive();
//        thread.isDaemon();
    }

}
//User thread -> JVM waits for it to finish
//Daemon thread -> JMV does NOT wait and kills the process

/**
 * Daemon thread - check updates
 * User thread - save file before exit
 */
class MyThread extends Thread {
    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (1==1) {
//            if (currentThread.isInterrupted()) {
//                break;
//            }
        }
//        System.out.println(this.threadName + ": Вы видите это сообщение потому, что меня попросили закрыться!!");
    }
}