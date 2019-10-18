package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MontyHallTest {

    // Bad typing of percentage. Susceptible to rounding and assertion issues.
    @Test
    public void loggerReturnsWinPercentage() {
        ResultLogger logger = new ResultLogger();

        logger.logBoolResult(true);
        logger.logBoolResult(false);
        logger.logBoolResult(true);

        assertEquals((double)2/3*100, logger.getPercentageOfTrue(), 0);
    }

    @Test
    public void doorFactoryCreatesSpecifiedNumberOfDoors() {
        DoorFactory factory = new DoorFactory(new RealRandom());

        var doors = factory.createDoors(3);

        assertEquals(3, doors.size());
    }

    @Test
    public void doorFactoryCreatesExactlyOneDoorContainingPrize() {
        DoorFactory factory = new DoorFactory(new RealRandom());

        var doors = factory.createDoors(5);

        int numberOfPrizes = 0;
        for (Door door : doors) {
            if (door.hasPrize) {
                numberOfPrizes++;
            }
        }

        assertEquals(1, numberOfPrizes);
    }

    @Test
    public void givenSimulationWherePlayerDoesntSwitch_WhenPlayerStartsWithPrize_PlayerShouldWinAllGames() {
        IRandom stub = new StubRandom(0);
        MontyHallSimulator simulator = new MontyHallSimulator(stub, false);
        simulator.simulateMontyHall(1000);

        int wins = simulator.getNumberOfPlayerWins();

        assertEquals(1000, wins);
    }

    @Test
    public void givenSimulationWherePlayerSwitches_WhenPlayerStartsWithPrize_PlayerShouldLoseAllGames() {
        IRandom stub = new StubRandom(0);
        MontyHallSimulator simulator = new MontyHallSimulator(stub, true);
        simulator.simulateMontyHall(1000);

        int wins = simulator.getNumberOfPlayerWins();

        assertEquals(0, wins);
    }


}
