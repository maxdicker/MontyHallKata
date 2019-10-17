package com;

public class DoorFactory {
    private IRandom random;

    public DoorFactory(IRandom random) {
        this.random = random;
    }

    public Door[] createDoors(int numberOfDoors) {
        Door[] doors = new Door[numberOfDoors];

        return doors;
    }
}
