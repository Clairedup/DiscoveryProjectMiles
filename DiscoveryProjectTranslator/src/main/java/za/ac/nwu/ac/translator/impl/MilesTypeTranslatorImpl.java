package za.ac.nwu.ac.translator.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MilesTypeDto;
import za.ac.nwu.ac.domain.persistence.MilesType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepo;
import za.ac.nwu.ac.translator.MilesTypeTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MilesTypeTranslatorImpl implements MilesTypeTranslator
{
    private final AccountTypeRepo accountTypeRepo;

    @Autowired
    public void MilesTypeTranslator(AccountTypeRepo accountTypeRepo)
    {
        this.accountTypeRepo = accountTypeRepo;
    }

    @Override
    public List<MilesTypeDto> getAllMilesTypes() {
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

}
