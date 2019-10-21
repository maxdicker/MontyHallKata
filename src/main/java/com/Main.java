package com;

public class Main {

    public static void main(String[] args) {
        IO io = new ConsoleIO();
        io.printLine("Welcome to Monty Hall!");

        MontyHallSimulator simThatPlayerSwitches = new MontyHallSimulator(new RealRandom(), true);
        simThatPlayerSwitches.simulateMontyHall(1000);
        int switchWins = simThatPlayerSwitches.getNumberOfPlayerWins();
        io.printLine("Simulating 1000 games where the player SWITCHES their door, we found they won " + switchWins/10 + "%.");

        MontyHallSimulator simThatPlayerHolds = new MontyHallSimulator(new RealRandom(), false);
        simThatPlayerHolds.simulateMontyHall(1000);
        int holdWins = simThatPlayerHolds.getNumberOfPlayerWins();
        io.printLine("Simulating 1000 games where the player DOESN'T SWITCH their door, we found they won " + holdWins/10 + "%.");

    }
}
