package com;

public class DoorFactory {
    private IRandom random;

    public DoorFactory(IRandom random) {
        this.random = random;
    }

    public Door[] createDoors(int numberOfDoors) {
        Door[] doors = new Door[numberOfDoors];

        for (int i = 0; i < numberOfDoors; i++) {
            doors[i] = new Door(false);
        }

        doors[random.nextInt(numberOfDoors)] = new Door(true);

        return doors;
    }
}
