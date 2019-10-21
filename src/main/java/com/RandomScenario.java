package com;

import java.util.Random;

public class RandomScenario implements MontyHallScenario {
    private Random random = new Random();

    @Override
    public Boolean determinePlayerDoorStartsWithPrize(int totalNumberOfDoors) {
        return random.nextInt(totalNumberOfDoors) == 0;
    }
}
