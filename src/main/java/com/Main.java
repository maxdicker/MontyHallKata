package com;

public class Main {

    public static void main(String[] args) {
        IO io = new ConsoleIO();
        io.printLine("Welcome to Monty Hall!");

        MontyHallSimulator simPlayerSwitching = new MontyHallSimulator(new RandomScenario(), true);
        simPlayerSwitching.simulateMontyHall(1000);
        int switchWins = simPlayerSwitching.getNumberOfPlayerWins();
        io.printLine("Simulating 1000 games where the player SWITCHES their door, we found they won " + switchWins/10 + "%.");

        MontyHallSimulator simPlayerNotSwitching = new MontyHallSimulator(new RandomScenario(), false);
        simPlayerNotSwitching.simulateMontyHall(1000);
        int holdWins = simPlayerNotSwitching.getNumberOfPlayerWins();
        io.printLine("Simulating 1000 games where the player DOESN'T SWITCH their door, we found they won " + holdWins/10 + "%.");

    }
}
