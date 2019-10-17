package com;

import java.util.Random;

public class RealRandom implements IRandom{
    private Random random = new Random();

    @Override
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

}
