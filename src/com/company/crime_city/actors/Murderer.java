package com.company.crime_city.actors;

public class Murderer extends Thread {

    private Integer criminalId;
    private String criminalType;

    public Murderer(Integer criminalId, String criminalType) {
        this.criminalId = criminalId;
        this.criminalType = criminalType;
    }

    public Integer getCriminalId() {
        return criminalId;
    }

    public String getCriminalType() {
        return criminalType;
    }

    private static final int OCCURS_EACH_ITERATIONS = 2;

    private static volatile int agentsCount = 0;
    private static synchronized int getAgentsCount() {
        return ++agentsCount;
    }

    @Override
    public void run() {

        int iterationCount = 0;
        while (true) {

            System.out.printf("%s #%s убивает мирных жителей\n",
                    this.criminalType,
                    this.criminalId
            );

            if (++iterationCount == OCCURS_EACH_ITERATIONS) {
                System.out.printf("%s #%s создал нового агента\n",
                        this.criminalType,
                        this.criminalId);
                Agent agent = new Agent(getAgentsCount(), "Agent");
                agent.setDaemon(true);
                agent.start();
            }

            try {
                Thread.sleep(3500);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
