package com;

public class StubScenario implements MontyHallScenario {
    private Boolean playerStartsWithPrizeDoor;

    public StubScenario(Boolean playerStartsWithPrizeDoor) {
        this.playerStartsWithPrizeDoor = playerStartsWithPrizeDoor;
    }

    @Override
    public void constructScenario(int totalNumberOfDoors) {
    }

    @Override
    public Boolean playerStartsWithPrizeDoor() {
        return playerStartsWithPrizeDoor;
    }
}
