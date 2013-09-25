

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GumballMachineTest
{
    /**
     * Default constructor for test class GumballMachineTest
     */
    public GumballMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void TestNormalScenario()
    {
        GumballMachine gumballM1 = new GumballMachine(5);
        assertEquals(gumballM1.getNoCoinState(), gumballM1.getState());
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        assertEquals(true, gumballM1.isGumballInSlot());
        gumballM1.takeGumballFromSlot();
        assertEquals(false, gumballM1.isGumballInSlot());
        assertEquals(gumballM1.getNoCoinState(), gumballM1.getState());
    }

    @Test
    public void TestInsertNickelAndQuarterMethods()
    {
        GumballMachine gumballM1 = new GumballMachine(5);
        assertEquals(gumballM1.getNoCoinState(), gumballM1.getState());
        gumballM1.insertNickel();
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        assertEquals(true, gumballM1.isGumballInSlot());
        gumballM1.takeGumballFromSlot();
        assertEquals(false, gumballM1.isGumballInSlot());
        assertEquals(gumballM1.getNoCoinState(), gumballM1.getState());
    }

    @Test
    public void TestNickelDimeQuarterMethod()
    {
        GumballMachine gumballM1 = new GumballMachine(5);
        assertEquals(gumballM1.getNoCoinState(), gumballM1.getState());
        gumballM1.insertDime();
        gumballM1.insertNickel();
        gumballM1.insertDime();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        assertEquals(true, gumballM1.isGumballInSlot());
        gumballM1.takeGumballFromSlot();
        assertEquals(false, gumballM1.isGumballInSlot());
        assertEquals(gumballM1.getNoCoinState(), gumballM1.getState());
    }
}



