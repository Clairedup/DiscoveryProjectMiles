package za.ac.nwu.ac.repo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.MilesType;

import javax.persistence.criteria.From;

@Repository
public interface AccountTypeRepo extends JpaRepository<MilesType, Long>
{
    @Query(value = "SELECT" +
            "       TYPE_ID,"  +
            "       ACCOUNT_NAME" +
            "       CREATION_DATE, " +
            "       MNEMONIC"
                   From
            "       VITRSA_SANDBOX_MILES_TYPE" +
            "       WHERE MNEMONIC = :mnemonic", nativeQuery = true)
    MilesType getMilesTypeByMnemonicNativeQuery(String mnemonic);

}
