package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MontyHallTest {

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

}
