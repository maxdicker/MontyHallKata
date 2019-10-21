package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;

public class MontyHallTest {

    @Test
    public void doorFactoryReturnsSpecifiedNumberOfDoors() {
        DoorFactory factory = new DoorFactory();

        var doors = factory.createDoors(3);

        assertEquals(3, doors.size());
    }

    @Test
    public void doorFactoryReturnsExactlyOneDoorContainingPrize() {
        DoorFactory factory = new DoorFactory();

        var doors = factory.createDoors(5);
        int numberOfPrizes = findNumberOfPrizes(doors);

        assertEquals(1, numberOfPrizes);
    }

    //Its not clear that this gives player the prize door. Need to know implementation.
    @Test
    public void wherePlayerStartsWithPrizeDoor_ifSimulatingThatPlayerDoesntSwitch_PlayerShouldWinAllGames() {
        MontyHallScenario stub = new StubScenario(true);
        MontyHallSimulator simulator = new MontyHallSimulator(stub, false);

        simulator.simulateMontyHall(1000);
        int wins = simulator.getNumberOfPlayerWins();

        assertEquals(1000, wins);
    }

    @Test
    public void wherePlayerStartsWithPrizeDoor_ifSimulatingThatPlayerSwitches_PlayerShouldLoseAllGames() {
        MontyHallScenario stub = new StubScenario(true);
        MontyHallSimulator simulator = new MontyHallSimulator(stub, true);

        simulator.simulateMontyHall(1000);
        int wins = simulator.getNumberOfPlayerWins();

        assertEquals(0, wins);
    }

    //Could also test the last two scenarios (where player doesn't start with prize doors), but this won't improve coverage?

    @Test
    public void wherePlayerDoesntStartWithPrizeDoor_ifSimulatingThatPlayerDoesntSwitch_PlayerShouldLoseAllGames() {
        MontyHallScenario stub = new StubScenario(false);
        MontyHallSimulator simulator = new MontyHallSimulator(stub, false);

        simulator.simulateMontyHall(1000);
        int wins = simulator.getNumberOfPlayerWins();

        assertEquals(0, wins);
    }

    @Test
    public void wherePlayerDoesntStartWithPrizeDoor_ifSimulatingThatPlayerSwitches_PlayerShouldWinAllGames() {
        MontyHallScenario stub = new StubScenario(false);
        MontyHallSimulator simulator = new MontyHallSimulator(stub, true);

        simulator.simulateMontyHall(1000);
        int wins = simulator.getNumberOfPlayerWins();

        assertEquals(1000, wins);
    }

    @Test
    public void simulatingThatPlayerSwitchesDoors_PlayerShouldWinMostGames() {
        MontyHallSimulator simulator = new MontyHallSimulator(new RandomScenario(), true);

        simulator.simulateMontyHall(1000);
        int wins = simulator.getNumberOfPlayerWins();

        assertTrue(wins > 620 && wins < 720);
    }

    @Test
    public void simulatingThatPlayerDoesntSwitchDoors_PlayerShouldLoseMostGames() {
        MontyHallSimulator simulator = new MontyHallSimulator(new RandomScenario(), false);

        simulator.simulateMontyHall(1000);
        int wins = simulator.getNumberOfPlayerWins();

        assertTrue(wins < 390 && wins > 290);
    }

    private int findNumberOfPrizes(List<Door> doors) {
        int numberOfPrizes = 0;
        for (Door door : doors) {
            if (door.hasPrize) {
                numberOfPrizes++;
            }
        }
        return numberOfPrizes;
    }

}
