package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.ac.domain.dto.MilesTypeDto;
import za.ac.nwu.ac.domain.persistence.MilesType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepo;

import java.util.ArrayList;
import java.util.List;

public class MilesTransTranslator implements za.ac.nwu.ac.translator.MilesTransTranslator {


    @Autowired
    public void MilesTransTranslator(AccountTypeRepo accountTypeRepo)
    {
        this.accountTypeRepo = accountTypeRepo;
    }

    @Override
    public List<MilesTypeDto> getAllMilesTrans() {
        List<MilesTypeDto> milesTypeDtos = new ArrayList<>();
        try {
            for (MilesType milesType : accountTypeRepo.findAll()) {
                milesTypeDtos.add(new MilesTypeDto(milesType));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from DB", e);
        }
        return milesTypeDtos;
    }

    @Override
    public MilesTypeDto create(MilesTypeDto milesTypeDto)
    {
        try {
            MilesType milesType = accountTypeRepo.save(milesTypeDto.getMilesType());
            return new MilesTypeDto(milesType);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to save to DB", e);
        }
    }
}
