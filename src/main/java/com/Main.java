package com;

import java.text.DecimalFormat;

public class Main {

    private static final int NUMBER_OF_SIMULATIONS = 1000;
    private static final DecimalFormat df = new DecimalFormat("##.##%");

    public static void main(String[] args) {
        IO io = new ConsoleIO();
        io.printLine("Welcome to Monty Hall!");

        MontyHallSimulator simPlayerSwitching = new MontyHallSimulator(new RandomScenario(), true);
        simPlayerSwitching.simulateMontyHall(NUMBER_OF_SIMULATIONS);
        int switchWins = simPlayerSwitching.getNumberOfPlayerWins();
        io.printLine("Simulating "+ NUMBER_OF_SIMULATIONS +" games where the player SWITCHES their door, we found they won " + df.format(switchWins * 1.0f /NUMBER_OF_SIMULATIONS)+".");

        MontyHallSimulator simPlayerNotSwitching = new MontyHallSimulator(new RandomScenario(), false);
        simPlayerNotSwitching.simulateMontyHall(NUMBER_OF_SIMULATIONS);
        int holdWins = simPlayerNotSwitching.getNumberOfPlayerWins();
        io.printLine("Simulating "+ NUMBER_OF_SIMULATIONS +" games where the player DOESN'T SWITCH their door, we found they won " + df.format(holdWins * 1.0f /NUMBER_OF_SIMULATIONS)+".");

    }
}
