package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MontyHallTest {

    @Test
    public void loggerReturnsWinPercentage() {
        ResultLogger logger = new ResultLogger();

        logger.logBoolResult(true);
        logger.logBoolResult(false);
        logger.logBoolResult(true);

        assertEquals(2/3*100, logger.getTruePercentage());
    }

}
