package za.ac.nwu.ac.logic.flow.impl;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import za.ac.nwu.ac.domain.dto.MilesTypeDto;
import za.ac.nwu.ac.logic.flow.CreateMilesTypeFlowInt;
import za.ac.nwu.ac.translator.MilesTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createMilesTypeFlowName")
public class CreateMilesTypeFlow implements CreateMilesTypeFlowInt {
    private final MilesTypeTranslator milesTypeTranslator;

    public CreateMilesTypeFlow(MilesTypeTranslator milesTypeTranslator){
        this.milesTypeTranslator = milesTypeTranslator;
    }

    @Override
    public MilesTypeDto create(MilesTypeDto milesType)
    {
        if(null == milesType.getCreationDate())
        {
            milesType.setCreationDate(LocalDate.now());
        }
        return milesTypeTranslator.create(milesType);
    }



}
