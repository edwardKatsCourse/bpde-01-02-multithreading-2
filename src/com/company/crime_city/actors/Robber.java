package com.company.crime_city.actors;

public class Robber extends Thread {

    private Integer criminalId;
    private String criminalType;

    public Robber(Integer criminalId, String criminalType) {
        this.criminalId = criminalId;
        this.criminalType = criminalType;
    }

    public Integer getCriminalId() {
        return criminalId;
    }

    public String getCriminalType() {
        return criminalType;
    }

    @Override
    public void run() {
        while (true) {
            System.out.printf("%s #%s грабит банки\n",
                    this.criminalType,
                    this.criminalId);

            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("Полиция приказала interrupt, " +
                                "пока %s грабил банк. %s #%s сдается полиции\n",
                        this.criminalType,
                        this.criminalType,
                        this.criminalId);
                break;
            }
            try {
                System.out.printf("%s #%s залег на дно!\n",
                        this.criminalType,
                        this.criminalId);

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.printf("Полиция приказала interrupt, пока %s спал. " +
                                "%s #%s сдается полиции\n",
                        this.criminalType,
                        this.criminalType,
                        this.criminalId);
                break;
            }
        }
    }
}
