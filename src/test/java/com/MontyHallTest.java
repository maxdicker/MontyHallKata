package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MontyHallTest {

    @Test
    public void givenPlayerStartsWithPrizeDoorAndDoesntSwitchDoors_PlayerShouldWinAllGames() {
        MontyHallScenario stub = new StubScenario(true);
        MontyHallSimulator simulator = new MontyHallSimulator(stub, false);

        simulator.simulateMontyHall(1000);

        assertEquals(1000, simulator.getNumberOfPlayerWins());
    }

    @Test
    public void givenPlayerStartsWithPrizeDoorAndSwitchesDoors_PlayerShouldLoseAllGames() {
        MontyHallScenario stub = new StubScenario(true);
        MontyHallSimulator simulator = new MontyHallSimulator(stub, true);

        simulator.simulateMontyHall(1000);

        assertEquals(0, simulator.getNumberOfPlayerWins());
    }

    @Test
    public void givenPlayerDoesntStartWithPrizeDoorAndDoesntSwitch_PlayerShouldLoseAllGames() {
        MontyHallScenario stub = new StubScenario(false);
        MontyHallSimulator simulator = new MontyHallSimulator(stub, false);

        simulator.simulateMontyHall(1000);

        assertEquals(0, simulator.getNumberOfPlayerWins());
    }

    @Test
    public void givenPlayerDoesntStartWithPrizeDoorAndSwitchesDoors_PlayerShouldWinAllGames() {
        MontyHallScenario stub = new StubScenario(false);
        MontyHallSimulator simulator = new MontyHallSimulator(stub, true);

        simulator.simulateMontyHall(1000);

        assertEquals(1000, simulator.getNumberOfPlayerWins());
    }

    @Test
    public void givenRandomScenarioWherePlayerSwitchesDoors_PlayerShouldWinMostGames() {
        MontyHallSimulator simulator = new MontyHallSimulator(new RandomScenario(), true);

        simulator.simulateMontyHall(1000);
        int wins = simulator.getNumberOfPlayerWins();

        assertTrue(wins > 620 && wins < 720);
    }

    @Test
    public void givenRandomScenarioWherePlayerDoesntSwitchDoors_PlayerShouldLoseMostGames() {
        MontyHallSimulator simulator = new MontyHallSimulator(new RandomScenario(), false);

        simulator.simulateMontyHall(1000);
        int wins = simulator.getNumberOfPlayerWins();

        assertTrue(wins < 390 && wins > 290);
    }

}
