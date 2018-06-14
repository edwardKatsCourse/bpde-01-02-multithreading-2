package com.company.example;

public class ПослушныйТред extends Thread {

    private Integer number;

    public ПослушныйТред(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (true) {
            System.out.printf("ПослушныйТред #%s работает\n", this.number);
            try {
                if (currentThread.isInterrupted()) {
                    break;
                }
                Thread.sleep(500_000);
            } catch (InterruptedException e) {

                System.out.printf("ПослушныйТред #%s РАЗБУДИЛИ!\n",
                        this.number);


                System.out.printf("ПослушныйТред #%s Interrupted status:%s\n",
                        this.number,
                        currentThread.isInterrupted());
            }

        }

        System.out.printf("ПослушныйТред #%s говорит \"Пока\"\n",
                this.number);
    }
}
