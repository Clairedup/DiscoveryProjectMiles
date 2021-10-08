package za.ac.nwu.ac.logic.flow.impl;

import org.aspectj.apache.bcel.classfile.Module;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

public class ModuleTest {
    private Module mod;

    @Before
    public void setUp() throws Exception
    {
        mod = new Module();
    }

    @Test
    public void testMod()
    {
        Integer result = mod.doMod(9,5);
        assertNotNull("Should not be null", result);
        assetEquals("Should be 4", 4, result);
    }
}
