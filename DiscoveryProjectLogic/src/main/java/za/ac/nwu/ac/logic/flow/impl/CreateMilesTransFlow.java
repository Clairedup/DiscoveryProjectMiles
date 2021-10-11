package za.ac.nwu.ac.logic.flow.impl;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MilesTypeDto;
import za.ac.nwu.ac.translator.MilesTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.logging.Logger;

@Transactional
@Component("createMilesTransFlowName")
public class CreateMilesTransFlow implements za.ac.nwu.ac.logic.flow.CreateMilesTransFlow {
    private final Miles milesTypeTranslator;
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CreateMilesTypeFlow.class);

    public CreateMilesTypeFlow(MilesTypeTranslator milesTypeTranslator){
        this.milesTypeTranslator = milesTypeTranslator;
    }

    @Override
    public MilesTypeDto create(MilesTypeDto milesType)
    {
        LOGGER.info("This was the input {}", milesType;

        if(null == milesType.getCreationDate())
        {
            milesType.setCreationDate(LocalDate.now());
        }
        return milesTypeTranslator.create(milesType);
    }


}
