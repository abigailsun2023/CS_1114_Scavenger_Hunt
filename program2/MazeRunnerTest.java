import sofia.micro.*;
import sofia.micro.jeroo.*;
import static sofia.micro.jeroo.CompassDirection.*;
import static sofia.micro.jeroo.RelativeDirection.*;

// -------------------------------------------------------------------------
/**
 *  These tests will help us see if the assertions
 *  made about the Jeroo are true.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.02.16)
 */
public class MazeRunnerTest extends TestCase
{
    //~ Fields .....................................................

    //~ Constructor .................................
    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunnerTest test object.
     */
    public MazeRunnerTest()
    {
        // This section is empty because all the methods are being tested.
    }

    // ----------------------------------------------------------
    /**
     * When clearMaze() is tested, there will be no 
     * nets or flowers left on the map.
     */
    public void testClearMaze()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(4);
        MazeRunner runner = new MazeRunner();
        island.add(runner, 2, 2);

        // 2. Call the method(s) you are testing
        runner.clearMaze();

        // 3. Make assertions capturing your expected outcomes
        assertEquals(0, runner.getWorld().getObjects(Net.class).size());
        assertEquals(0, runner.getWorld().getObjects(Flower.class).size());

    }

    /**
     * If the Jeroo is facing East and surrounded
     * by water except for the right, (which is South)
     * the Jeroo should turn right to avoid water.
     */
    public void testAvoidWaterTrue()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(4);
        MazeRunner runner = new MazeRunner();
        island.add(runner, 11, 1);

        // 2. Call the method(s) you are testing
        runner.avoidWater();

        // 3. Make assertions capturing your expected outcomes

        assertTrue(runner.isFacing(SOUTH));

        // ----------------------------------------------------------
        /*# Insert your own test methods here */

    }

    /**
     * When avoidWater() is tested where the Jeroo doesn't
     * see water to the left, then the Jeroo will turn left.
     */
    public void testAvoidWaterFalse()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(4);
        MazeRunner runner = new MazeRunner();
        island.add(runner, 1, 5);

        // 2. Call the method(s) you are testing
        runner.avoidWater();

        // 3. Make assertions capturing your expected outcomes

        assertFalse(runner.isFacing(SOUTH));
        assertTrue(runner.isFacing(NORTH));
    }

    /**
     * When disableNet() is tested where there's a net ahead, then 
     * the Jeroo will toss a flower and hop one.
     */
    public void testDisableNetTrue()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(4);
        MazeRunner runner = new MazeRunner();
        island.add(runner, 4, 1);

        // 2. Call the method(s) you are testing
        runner.disableNet();
        runner.hop();

        // 3. Make assertions capturing your expected outcomes

        assertEquals(5, runner.getGridX());
        assertEquals(1, runner.getGridY());
        assertEquals(island.getObjects(Net.class).size() - 1, 7);
    }   

    /**
     * When disableNet() is tested where there's no net ahead, then 
     * the code will just move onto the next method.
     */
    public void testDisableNetFalse()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(4);
        MazeRunner runner = new MazeRunner();
        island.add(runner, 5, 3);

        // 2. Call the method(s) you are testing
        runner.disableNet();
        runner.hop();

        // 3. Make assertions capturing your expected outcomes

        assertEquals(6, runner.getGridX());
        assertEquals(3, runner.getGridY());
        assertEquals(island.getObjects(Net.class).size() - 0,
            island.getObjects(Net.class).size() - 0);
    }

    /**
     * When pickFlower() is tested in a spot where there's a 
     * flower ahead, then the Jeroo will move up one ad pick 
     * the flower.
     */
    public void testPickFlowerTrue()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(4);
        MazeRunner runner = new MazeRunner();
        island.add(runner, 7, 5);

        // 2. Call the method(s) you are testing
        runner.pickFlower();

        // 3. Make assertions capturing your expected outcomes

        assertEquals(8, runner.getGridX());
        assertEquals(5, runner.getGridY());
        assertEquals(island.getObjects(Flower.class).size() - 1, 
            island.getObjects(Flower.class).size() - 1);
    }    

    /**
     * When pickFlower() is tested in a spot where there's not
     * a flower ahead, then the Jeroo will just move onto the 
     * next method.
     */
    public void testPickFlowerFalse()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(4);
        MazeRunner runner = new MazeRunner();
        island.add(runner, 1, 4);

        // 2. Call the method(s) you are testing
        runner.pickFlower();

        // 3. Make assertions capturing your expected outcomes

        assertEquals(1, runner.getGridX());
        assertEquals(4, runner.getGridY());
        assertEquals(island.getObjects(Flower.class).size() - 0, 
            island.getObjects(Flower.class).size() - 0);
    }    

    /**
     * When MovetoOrigin() is tested at (1, 4), the Jeroo
     * should end up at the origin (1, 1).
     */
    public void testMoveToOrigin()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(4);
        MazeRunner runner = new MazeRunner();
        island.add(runner, 1, 4);

        // 2. Call the method(s) you are testing
        runner.clearMaze();
        runner.moveToOrigin();

        // 3. Make assertions capturing your expected outcomes

        assertEquals(1, runner.getGridX());
        assertEquals(1, runner.getGridY());

    }  
    
    /**
     * When MovetoOrigin() is tested at the origin (1, 1), the Jeroo
     * should end up back at the origin.
     */
    public void testMoveToOrigin2()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(4);
        MazeRunner runner = new MazeRunner();
        island.add(runner, 1, 1);

        // 2. Call the method(s) you are testing
        runner.clearMaze();
        runner.moveToOrigin();

        // 3. Make assertions capturing your expected outcomes

        assertEquals(1, runner.getGridX());
        assertEquals(1, runner.getGridY());

    }  
    
    /**
     * When MovetoOrigin() is tested at (4, 1), the Jeroo
     * should end up at the origin (1, 1).
     */
    public void testMoveToOrigin3()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(4);
        MazeRunner runner = new MazeRunner();
        island.add(runner, 4, 1);

        // 2. Call the method(s) you are testing
        runner.clearMaze();
        runner.moveToOrigin();

        // 3. Make assertions capturing your expected outcomes

        assertEquals(1, runner.getGridX());
        assertEquals(1, runner.getGridY());

    }
    
    /**
     * When MovetoOrigin() is tested at (3, 4), the Jeroo
     * should end up at the origin (1, 1).
     */
    public void testMoveToOrigin4()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(4);
        MazeRunner runner = new MazeRunner();
        island.add(runner, 3, 4);

        // 2. Call the method(s) you are testing
        runner.clearMaze();
        runner.moveToOrigin();

        // 3. Make assertions capturing your expected outcomes

        assertEquals(1, runner.getGridX());
        assertEquals(1, runner.getGridY());

    }  

    /**
     * When MazeRunner is summoned, this test should assert that
     * the Jeroo is actually summoned at the specific spot it was
     * called to (1, 1).
     */
    public void testMazeRunner()
    {
        Island island = new MazeIsland(4);
        MazeRunner runner = new MazeRunner();
        island.add(runner, 1, 1);
        
       

        assertEquals(1, runner.getGridX());
        assertEquals(1, runner.getGridY());

        

    }
    
    /**
     * When myProgram runs, this test should assert that
     * the map is clear of all nets and flowers.
     */
    public void testMyProgram()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(4);
        MazeRunner runner = new MazeRunner();
        island.add(runner, 2, 2);

        // 2. Call the method(s) you are testing
        runner.myProgram();

        // 3. Make assertions capturing your expected outcomes
        assertEquals(0, runner.getWorld().getObjects(Net.class).size());
        assertEquals(0, runner.getWorld().getObjects(Flower.class).size());
        
    }
}
