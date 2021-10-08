import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.ac.domain.dto.MilesTypeDto;
import za.ac.nwu.ac.logic.flow.CreateMilesTypeFlowInt;
import za.ac.nwu.ac.logic.flow.FetchMilesTypeFlow;
import za.ac.nwu.ac.web.sb.controller.DiscoveryController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DiscoveryControllerTest {
    private static final String APP_URL = "/discovery-system/mvc";
    private static final String DISCOVERY_CONTROLLER = APP_URL + "/miles-type";

    @Mock
    private FetchMilesTypeFlow fetchMilesTypeFlow;

    @Mock
    private ModifyMilesTypeFlow modifyMilesTypeFlow;

    @Mock
    private CreateMilesTypeFlowInt createMilesTypeFlowInt;

    @InjectMocks
    private DiscoveryController controller;

    @Before
    public void setUp()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAll() throws Exception
    {
        String expectedResponse = "{\"successfull\":true,\"payload\": {" +
    "{\"mnemonic\":\"MILES\",\"milesTypeName\":\"Miles account type\",\"creationDate\":[2021,9,1]}," +
                "{\"mnemonic\":\"CAR\",\"milesTypeName\":\"Car account type\",\"creationDate\":[2021,11,12]}";


        List<MilesTypeDto> milesTypes = new ArrayList<>();
        milesTypes.add(new MilesTypeDto("MILES","Miles account type", LocalDate.parse("2021-09-01")));
        milesTypes.add(new MilesTypeDto("PLAY","Play account type", LocalDate.parse("2021-11-12")));

        when(fetchMilesTypeFlow.getAllMilesTypes()).thenReturn(milesTypes);

        MvcResult mvcResult = mockMVC.perform(milesTypes.get());
    }


}
