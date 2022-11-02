import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)
/**
 *  The Acid Test class is made to test al of the methods in the 
 *  Acid class.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.04.03)
 */
public class AcidTest extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new AcidTest test object.
     */
    public AcidTest()
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
     * This tests if where an acid particle cannot dissolve
     * another particle (out of bounds). Since the acid didn't
     * dissolve anything, its strength should still be 100.
     */
    public void testDissolveIfPossible()
    {
        World world = new ParticleWorld(5, 5);
        Acid ally = new Acid();
        ally.dissolveIfPossible(0, 0);
        world.add(ally, 3, 4);
        Water wally = new Water();
        world.add(wally, 3, 3);
        
        ally.dissolveIfPossible(-1, -1);
        ally.dissolveIfPossible(-1, 0);
        ally.dissolveIfPossible(-1, 100);
        ally.dissolveIfPossible(0, -1);
        ally.dissolveIfPossible(0, 100);
        ally.dissolveIfPossible(100, -1);
        ally.dissolveIfPossible(100, 0);
        ally.dissolveIfPossible(100, 100);
        
        assertEquals(100, ally.getStrength());
    }
    
    /**
     * This tests an acid particle's ability to dissolve
     * particles around it. There's a water and steel
     * around the acid, and the acid should dissolve the
     * steel, while the water remains unaffected.
     * As a result, the strength of the acid and steel should be 99
     * while the water remains at 100.
     */
    public void testDissolveIfPossible2()
    {
        World world = new ParticleWorld(5, 5);
        Acid ally = new Acid();
        world.add(ally, 3, 4);
        Water wally = new Water();
        world.add(wally, 3, 3);
        Steel steve = new Steel();
        world.add(steve, 2, 2);
        
        ally.dissolveIfPossible(0, 0);
        ally.dissolveIfPossible(3, 3);
        ally.dissolveIfPossible(2, 2);
        
        assertEquals(99, ally.getStrength());
        assertEquals(100, wally.getStrength());
        assertEquals(99, steve.getStrength());
    }
    
    /**
     * This method tests the act method in Acid class. Since there
     * are no other particles around the acid, the strength should
     * still be at 100.
     */
    public void testAct()
    {
        World world = new ParticleWorld(5, 5);
        Acid ally = new Acid();
        ally.act();
        world.add(ally, 3, 4);
        ally.act();
        
        assertEquals(100, ally.getStrength());
    }
}
