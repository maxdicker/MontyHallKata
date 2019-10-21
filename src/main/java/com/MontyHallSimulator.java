package com;

import java.util.List;

public class MontyHallSimulator {
    private final int NUMBER_OF_DOORS_FOR_MONTY_HALL = 3;
    private MontyHallScenario scenario;
    private DoorFactory factory;
    private Boolean playerOptsToSwitchDoors;

    private List<Door> hostsDoors;
    private int numberOfPlayerWins;

    public MontyHallSimulator(MontyHallScenario scenario, Boolean playerOptsToSwitchDoors) {
        this.scenario = scenario;
        this.factory = new DoorFactory();
        this.playerOptsToSwitchDoors = playerOptsToSwitchDoors;
    }

    public void simulateMontyHall(int numberOfGames) {
        for (int i = 1; i <= numberOfGames; i++) {
            Boolean playerHasPrize = scenario.determinePlayerDoorStartsWithPrize(NUMBER_OF_DOORS_FOR_MONTY_HALL);

            if (playerHasPrize && !playerOptsToSwitchDoors || !playerHasPrize && playerOptsToSwitchDoors) {
                numberOfPlayerWins++;
            }

        }
    }

    private Door findPrizeDoor() {
        for (Door door : hostsDoors) {
            if (door.hasPrize) {
                return door;
            }
        }
        throw new IllegalStateException("There is no door with a prize!");
    }

    private void revealEmptyDoor() {
        Door doorToReveal = findEmptyDoor();
        hostsDoors.remove(doorToReveal);
    }

    private Door findEmptyDoor() {
        for (Door door : hostsDoors) {
            if (!door.hasPrize) {
                return door;
            }
        }
        throw new IllegalStateException("There are no doors without prizes that the host can reveal!");
    }

    public int getNumberOfPlayerWins() {
        return numberOfPlayerWins;
    }
}
