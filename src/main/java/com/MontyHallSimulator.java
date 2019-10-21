package com;

public class MontyHallSimulator {
    private final int NUMBER_OF_DOORS_FOR_MONTY_HALL = 3;
    private MontyHallScenario scenario;
    private Boolean playerOptsToSwitchDoors;

    private int numberOfPlayerWins;

    public MontyHallSimulator(MontyHallScenario scenario, Boolean playerOptsToSwitchDoors) {
        this.scenario = scenario;
        this.playerOptsToSwitchDoors = playerOptsToSwitchDoors;
    }

    public void simulateMontyHall(int numberOfSimulations) {
        for (int i = 1; i <= numberOfSimulations; i++) {
            scenario.constructScenario(NUMBER_OF_DOORS_FOR_MONTY_HALL);
            Boolean playerHasPrize = scenario.playerStartsWithPrizeDoor();

            if (playerHasPrize && !playerOptsToSwitchDoors || !playerHasPrize && playerOptsToSwitchDoors) {
                numberOfPlayerWins++;
            }

        }
    }

    public int getNumberOfPlayerWins() {
        return numberOfPlayerWins;
    }
}
