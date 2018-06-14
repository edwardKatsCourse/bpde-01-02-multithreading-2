package com.company.crime_city;


import com.company.crime_city.actors.Murderer;
import com.company.crime_city.actors.Robber;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Murderer - убивает мирных жителей
     * Robber - грабит банки
     * Agent - агент, завербованный убийцами
     *
     * Robber сдается, когда полиция (Main) его ловит
     * (вызывает метод interrupt)
     *
     * Murderer игнорирует приказ полиции сдаться
     * (ничего не делает при вызове interrupt)
     *
     * Agent игнорирует вызов метода interrupt,
     * продолжает работать, даже если убийца был ликвидирован
     * (daemon)
     */

    static List<Thread> perpetrator = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        createCriminals();
        runCrimes();
        Thread.sleep(10_000);
        stopCrimesWithoutViolence();
        Thread.sleep(100);
        stopCrimeViolently();

    }

    private static void createCriminals() {
        for (int i = 0; i < 10; i++) {
            perpetrator.add(new Robber((i+1), "Robber"));
            perpetrator.add(new Murderer((i + 11), "Murderer"));
        }
    }

    private static void runCrimes() {
        for (Thread criminal : perpetrator) {
            criminal.start();
        }
    }

    private static void stopCrimesWithoutViolence() {
        for (Thread thread : perpetrator) {
            thread.interrupt();
        }
    }

    private static void stopCrimeViolently() {
        for (Thread thread : perpetrator) {
            if (thread.isAlive()) {
                thread.stop();
                if (thread instanceof Murderer) {
                    Murderer murderer = (Murderer) thread;
                    System.out.printf("Полиция ликвидировала убийцу %s #%s\n",
                            murderer.getCriminalType(),
                            murderer.getCriminalId());
                } else if (thread instanceof Robber){
                    Robber robber = (Robber) thread;
                    System.out.printf("Грабитель %s #%s не успел сдаться\n",
                            robber.getCriminalType(),
                            robber.getCriminalId());

                }
            }
        }
    }
}
