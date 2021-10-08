package za.ac.nwu.ac.logic.flow.impl;

public class Module
{
    public Integer doMod(int dividend, int divisor)
    {
        if(divisor == 0) {
            return null;
        }
        return dividend % divisor;
    }
}
