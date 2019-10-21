package com;

import java.util.Random;

public class RandomScenario implements MontyHallScenario {
    private Random random = new Random();

    @Override
    public Boolean playerStartsWithPrizeDoor() {
        return random.nextBoolean();
    }
}
