package com;

import java.util.List;

public class MontyHallSimulator {
    private final int NUMBER_OF_DOORS_FOR_MONTY_HALL = 3;
    private DoorFactory factory;
    private Boolean playerOptsToSwitchDoors;

    private int numberOfPlayerWins;

    public MontyHallSimulator(IRandom random, Boolean playerOptsToSwitchDoors) {
        this.factory = new DoorFactory(random);
        this.playerOptsToSwitchDoors = playerOptsToSwitchDoors;
    }

    public void simulateMontyHall(int numberOfGames) {
        for (int i = 1; i <= numberOfGames; i++) {
            List<Door> hostsDoors = factory.createDoors(NUMBER_OF_DOORS_FOR_MONTY_HALL);

            Door playersDoor = assignPlayerDoor(hostsDoors);

            revealEmptyDoor(hostsDoors);

            if (playerOptsToSwitchDoors) {
                hostsDoors.add(playersDoor);
                playersDoor = hostsDoors.get(0);
                hostsDoors.remove(0);
            }

            if (playersDoor.hasPrize) {
                numberOfPlayerWins++;
            }
        }
    }

    private Door assignPlayerDoor(List<Door> hostsDoors) {
        Door doorToAssign = hostsDoors.get(0);
        hostsDoors.remove(0);
        return doorToAssign;
    }

    private void revealEmptyDoor(List<Door> hostsDoors) {
        Door doorToReveal = findEmptyDoorToReveal(hostsDoors);
        hostsDoors.remove(doorToReveal);
    }

    private Door findEmptyDoorToReveal(List<Door> hostDoors) {
        for (Door door : hostDoors) {
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
