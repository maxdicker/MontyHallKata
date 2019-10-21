package com;

public class StubScenario implements MontyHallScenario {
    private Boolean playerStartsWithPrize;

    public StubScenario(Boolean playerStartsWithPrize) {
        this.playerStartsWithPrize = playerStartsWithPrize;
    }

    @Override
    public Boolean determinePlayerDoorStartsWithPrize(int totalNumberOfDoors) {
        return playerStartsWithPrize;
    }
}
