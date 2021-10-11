package za.ac.nwu.ac.logic.flow.impl;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import za.ac.nwu.ac.domain.dto.MilesTypeDto;
import za.ac.nwu.ac.logic.flow.CreateMilesTypeFlowInt;
import za.ac.nwu.ac.translator.MilesTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.logging.Logger;

@Transactional
@Component("createMilesTypeFlowName")
public class CreateMilesTypeFlow implements CreateMilesTypeFlowInt {
    private final MilesTypeTranslator milesTypeTranslator;
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CreateMilesTypeFlow.class);

    public CreateMilesTypeFlow(MilesTypeTranslator milesTypeTranslator){
        this.milesTypeTranslator = milesTypeTranslator;
    }

    @Override
    public MilesTypeDto create(MilesTypeDto milesType)
    {
        LOGGER.info("This was the input {}", milesType);

        if(null == milesType.getCreationDate())
        {
            milesType.setCreationDate(LocalDate.now());
        }
        return milesTypeTranslator.create(milesType);
    }



}
