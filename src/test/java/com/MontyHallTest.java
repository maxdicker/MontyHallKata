package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

        assertEquals(3, doors.length);
    }


}
