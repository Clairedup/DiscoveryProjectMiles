package za.ac.nwu.ac.logic.flow.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FetchMilesTypeFlowTest {

    private FetchMilesTypeFlowTest testClass;

    @BeforeEach
    void setUp() throws Exception
    {
        testClass = new FetchMilesTypeFlow(null);
    }

    @AfterEach
    void tearDown()throws Exception
    {
        testClass = null;
    }


    @Test
    void setMethodToTest()throws Exception
    {
        assertTrue(testClass.methodToTest());
    }
}