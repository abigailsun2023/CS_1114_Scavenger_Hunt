import sofia.micro.*;

// ---------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)

/**
 *  This test class will test out all of the methods in the City
 *  class to make sure the program does what it's intended to do.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.03.19)
 */
public class CityTest extends TestCase
{
    //~ Fields .......................................


    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new CityTest test object.
     */
    public CityTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    //~ Methods ................................................
    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        //nothing
    }

    /**
     * This tests if the city constructor works
     */
    public void testCity()
    {
        // 1. Set up initial conditions
        City city = new City();
        // 2. Call the method(s) you are testing
        
        // 3. Make assertions capturing your expected outcomes
        assertEquals(25, city.getWidth());
        assertEquals(25, city.getHeight());

    }

    /**
     * This tests to see if populate() will populate the whole 
     * world with elephants. Since the world is 10x10, there
     * should be 100 elephants total.
     */
    public void testPopulateElephants()
    {
        // 1. Set up initial conditions
        //create city
        City city = new City(10, 10);
        
        // 2. Call the method(s) you are testing
        city.populate(1.0, 0.0, 0.2);
 
        // 3. Make assertions capturing your expected outcomes
        assertEquals(100, city.getObjects(Agent.class).size());

    }
    
    /**
     * This tests to see if populate() will populate the whole 
     * world with monkeys. Since the world is 10x10, there
     * should be 100 monkeys total.
     */
    public void testPopulateMonkeys()
    {
        // 1. Set up initial conditions
        //create city
        City city = new City(10, 10);
        
        // 2. Call the method(s) you are testing
        city.populate(0.0, 1.0, 0.2);
 
        // 3. Make assertions capturing your expected outcomes
        assertEquals(100, city.getObjects(Agent.class).size());

    }
    
    /**
     * This tests to see if populate() will populate the whole 
     * world with both elephants and monkeys. Since the world 
     * is 10x10, there should be 100 animals total.
     */
    public void testPopulateBoth()
    {
        // 1. Set up initial conditions
        //create city
        City city = new City(10, 10);
        
        // 2. Call the method(s) you are testing
        city.populate(0.5, 0.5, 0.2);
 
        // 3. Make assertions capturing your expected outcomes
        assertEquals(100, city.getObjects(Agent.class).size());

    }

  

    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
