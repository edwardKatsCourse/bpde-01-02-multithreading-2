package com.company.crime_city.actors;

public class Agent extends Thread {


    private Integer agentId;
    private String agentName;

    public Agent(Integer agentId, String agentName) {
        this.agentId = agentId;
        this.agentName = agentName;
    }

    @Override
    public void run() {
        while (true) {
            System.out.printf("%s #%s шпионит за полицией для грабителей\n",
                    this.agentName,
                    this.agentId);

            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {}
        }
    }
}
