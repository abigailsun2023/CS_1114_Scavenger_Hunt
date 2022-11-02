import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)
/**
 *  The Steel Test class is made to test all of the methods in the Steel
 *  class. There will only be two methods tested which are the override
 *  of dodge and isFalling.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.04.03)
 */
public class SteelTest extends TestCase
{
    //~ Fields ................................................................
    private World world;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SteelTest test object.
     */
    public SteelTest()
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
     * This tests the override for isFalling() by calling a steel
     * particle into the world at (3, 3). Since the ability to fall
     * should return false, this means that the steel particle is
     * immobile from it's current location.
     */
    public void testIsFallingOverride()
    {
        world = new World(5, 5);
        Steel steve = new Steel();
        world.add(steve, 3, 3);

        assertFalse(steve.isFalling());
    }

    /**
     * This tests the oveerride for dodge() by creating a steel
     * particle at (3, 3) and asserting that it cannot dodge (since
     * it's immobile).
     */
    public void testDodgeOverride()
    {
        world = new World(5, 5);
        Steel steve = new Steel();
        world.add(steve, 3, 3);

        assertFalse(steve.dodge());
    }
}
