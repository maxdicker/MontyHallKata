package com;

import java.util.ArrayList;
import java.util.List;

public class DoorFactory {

    public List<Door> createDoors(int numberOfDoors) {
        List<Door> doors = new ArrayList<>();

        for (int i = 1; i <= numberOfDoors; i++) {
            doors.add(new Door(false));
        }

        doors.set(0, new Door(true));

        return doors;
    }
}
