package com.company.example;

public class ГлухойТред extends Thread {

    private Integer number;

    public ГлухойТред(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        boolean b = true;
        while (b) {
            System.out.printf("ГлухойТред #%s работает!\n",
                    this.number);
            try {
                Thread.sleep(500_000);
            } catch (InterruptedException e) {
                System.out.printf("ГлухойТред #%s: ДАЙТЕ ПОСТАТЬ!!\n",
                        this.number);
            }
        }
        System.out.printf("ГлухойТред #%s говорит \"Пока\"",
                this.number);

    }
}
