package com;

import java.util.Random;

public class RandomScenario implements MontyHallScenario {
    private Random random = new Random();
    private Boolean playerStartsWithPrizeDoor = false;

    @Override
    public void constructScenario(int totalNumberOfDoors) {
        playerStartsWithPrizeDoor = random.nextInt(totalNumberOfDoors) == 0;
    }

    @Override
    public Boolean playerStartsWithPrizeDoor() {
        return playerStartsWithPrizeDoor;
    }
}
