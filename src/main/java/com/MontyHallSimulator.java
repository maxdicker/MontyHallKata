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
            hostsDoors = factory.createDoors(NUMBER_OF_DOORS_FOR_MONTY_HALL);

            Door playersDoor;
            if (scenario.playerStartsWithPrizeDoor()) {
                playersDoor = findPrizeDoor();
            } else {
                playersDoor = findEmptyDoor();
            }

            hostsDoors.remove(playersDoor);

            revealEmptyDoor();

            if (playerOptsToSwitchDoors) {
                hostsDoors.add(playersDoor);
                playersDoor = hostsDoors.get(0);
                hostsDoors.remove(playersDoor);
            }

            if (playersDoor.hasPrize) {
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
