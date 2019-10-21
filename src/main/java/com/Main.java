package com;

public class Main {

    public static void main( String[] args ) {
        MontyHallSimulator switchSim = new MontyHallSimulator(new RealRandom(), true);
        MontyHallSimulator holdSim = new MontyHallSimulator(new RealRandom(), false);
        switchSim.simulateMontyHall(1000);
        holdSim.simulateMontyHall(1000);

        System.out.println(switchSim.getNumberOfPlayerWins());
        System.out.println(holdSim.getNumberOfPlayerWins());
    }
}
