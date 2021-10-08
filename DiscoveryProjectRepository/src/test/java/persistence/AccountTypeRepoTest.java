package persistence;


import config.RepoTestConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.Classes;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.nwu.ac.domain.persistence.MilesType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(Classes = {RepoTestConfig.class})
public interface AccountTypeRepoTest
{
    @Autowired
    AccountTypeRepo accountTypeRepo;

    @Before
    public void setUp() throws Exception{}

    @After
    public void tearDown() throws Exception{}

    @Test
    public void getAccountTypeByMnemonicNativeQueryMiles()
    {
        MilesType miles = accountTypeRepo.getMilesTypeByMnemonicNativeQuery("Miles");
        assertNotNull(miles);
        assertEquals("MILES", miles.getMnemonic());
    }
    @Test
    public void getAccountTypeByMnemonicNativeQueryMiles()
    {
        MilesType miles = accountTypeRepo.getMilesTypeByMnemonicNativeQuery("Car");
        assertNotNull(miles);
        assertEquals("CAR", miles.getMnemonic());
}
