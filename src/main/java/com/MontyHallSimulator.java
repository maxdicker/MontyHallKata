package com;

import java.util.List;

public class MontyHallSimulator {
    private final int TOTAL_NUMBER_OF_DOORS = 3;

    private IRandom random;
    private DoorFactory factory;
    private Boolean playerSwitchesDoors;

    private Door playerDoor;
    private List<Door> hostDoors;
    private int numberOfPlayerWins;

    public MontyHallSimulator(IRandom random, Boolean playerSwitchesDoors) {
        this.random = random;
        this.factory = new DoorFactory(random);
        this.playerSwitchesDoors = playerSwitchesDoors;
    }

    public void simulateMontyHall(int numberOfGames) {
        for (int i = 1; i <= numberOfGames; i++) {
            List<Door> doors = factory.createDoors(TOTAL_NUMBER_OF_DOORS);
            playerDoor = doors.get(0);
            doors.remove(0);
            hostDoors = doors;

            Door doorToReveal = findDoorToReveal(hostDoors);
            hostDoors.remove(doorToReveal);

            if (playerSwitchesDoors) {
                hostDoors.add(playerDoor);
                playerDoor = hostDoors.get(0);
                hostDoors.remove(0);
            }

            if (playerDoor.hasPrize) {
                numberOfPlayerWins++;
            }
        }
    }

    private Door findDoorToReveal(List<Door> hostDoors) {
        for (Door door : hostDoors) {
            if (!door.hasPrize) {
                return door;
            }
        }
        throw new IllegalStateException("There are no doors without prizes to reveal");
    }

    public int getNumberOfPlayerWins() {
        return numberOfPlayerWins;
    }
}
