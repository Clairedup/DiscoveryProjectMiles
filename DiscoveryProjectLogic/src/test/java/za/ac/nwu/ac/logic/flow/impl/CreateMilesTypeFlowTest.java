package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MilesTypeDto;
import za.ac.nwu.ac.logic.flow.CreateMilesTypeFlowInt;
import za.ac.nwu.ac.translator.MilesTypeTranslator;



@RunWith(MockitoJUnitRunner.class)
public class CreateMilesTypeFlowTest {

    private MilesTypeTranslator translator;
    private CreateMilesTypeFlow flow;

    @BeforeEach
    void setUp() throws Exception
    {
        translator = Mockito.mock(MilesTypeTranslator.class);
        flow = new CreateMilesTypeFlow(translator);
    }

    @After
    public void tearDown() throws Exception
    {}

    @Test
    public void create()
    {
        flow.create(new MilesTypeDto());
    }
}
