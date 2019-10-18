package com;

public class StubRandom implements IRandom {
    private int nextInt;

    public StubRandom(int nextInt) {
        this.nextInt = nextInt;
    }

    @Override
    public int nextInt(int bound) {
        return nextInt;
    }
}
