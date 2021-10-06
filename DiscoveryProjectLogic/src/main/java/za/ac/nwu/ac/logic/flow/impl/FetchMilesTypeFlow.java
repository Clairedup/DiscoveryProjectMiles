package za.ac.nwu.ac.logic.flow.impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MilesTypeDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FetchMilesTypeFlow implements FetchMilesTypeFlow
{
    @Override
    public List<MilesTypeDto> getAllMilesTypes(){
        List<MilesTypeDto> milesTypeDtos = new ArrayList<>();
        milesTypeDtos.add(new MilesTypeDto("MILES","MILES", LocalDate.now()));
        return milesTypeDtos;
    }

}

