import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)
/**
 *  The Fluid Test class is made to test all the methods in the 
 *  Fluid class. In this case, there's only one method to test
 *  which is the override for dodge().
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.04.03)
 */
public class FluidTest extends TestCase
{
    //~ Fields ................................................................
    private ParticleWorld world;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FluidTest test object.
     */
    public FluidTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        /*# Insert your own setup code here */
    }
    
    /**
     * This tests the override for the dodge method.
     * Water particle wally is at (3, 3) while there's two more
     * water particles (wanda and will) in the spaces on either side
     * of the empty space directly below wally.
     * Since the only empty space is right  below it, wally will swap
     * to (3, 4).
     */
    public void testDodgeOverride()
    {
        world = new ParticleWorld(5, 5);
        Water wally = new Water();
        world.add(wally, 3, 3);
        Water wanda = new Water();
        world.add(wanda, 2, 4);
        Water will = new Water();
        world.add(will, 4, 4);
        wally.dodge();
        
        assertEquals(3, wally.getGridX());
        assertEquals(4, wally.getGridY());
    }
    
    /**
     * This tests the override for the dodge method.
     * Water particle wally is at (3, 4) while another water
     * particle wanda is at (2, 4), leaving one space to the right.
     * Since the only empty space is to the right, wally will swap
     * to (4, 4).
     */
    public void testDodgeOverride2()
    {
        world = new ParticleWorld(5, 5);
        Water wally = new Water();
        world.add(wally, 3, 4);
        Water wanda = new Water();
        world.add(wanda, 2, 4);
        wally.dodge();
        
        assertEquals(4, wally.getGridX());
        assertEquals(4, wally.getGridY());
    }
    
    /**
     * This tests the override for the dodge method.
     * Water particle wally is at (3, 4) while another water
     * particle will is at (4, 4), leaving one space to the left.
     * Since the only empty space is to the left, wally will swap
     * to (2, 4).
     */
    public void testDodgeOverride3()
    {
        world = new ParticleWorld(5, 5);
        Water wally = new Water();
        world.add(wally, 3, 4);
        Water will = new Water();
        world.add(will, 4, 4);
        wally.dodge();
        
        assertEquals(2, wally.getGridX());
        assertEquals(4, wally.getGridY());
    }
    
    /**
     * This tests the override for the dodge method.
     * Water particle wally is at (3, 4) while there's two more
     * water particles (wanda and will) in the spaces on either side
     * of wally.
     * Since there are no empty spaces on either side, wally will 
     * not swap anywhere (dodge will return false).
     */
    public void testDodgeOverride4()
    {
        world = new ParticleWorld(5, 5);
        Water wally = new Water();
        world.add(wally, 3, 4);
        Water wanda = new Water();
        world.add(wanda, 2, 4);
        Water will = new Water();
        world.add(will, 4, 4);
        wally.dodge();
        
        assertFalse(wally.dodge());
    }
}
