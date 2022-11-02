import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)
/**
 *  This Particle Test class is meant to test all the methods in the Particle
 *  class to see if they function properly.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.04.03)
 */
public class ParticleTest extends TestCase
{
    //~ Fields ................................................................
    private ParticleWorld world;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ParticleTest test object.
     */
    public ParticleTest()
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
        //nothing
    }

    /**
     * This tests the weaken() method by calling it onto a sand particle.
     * Since the the weaken method is called once, it should weaken the 
     * sand particle's strength by 1 (strength is now 99).
     */
    public void testWeaken()
    {
        Sand sandy = new Sand();

        sandy.weaken();
        assertEquals(99, sandy.getStrength(), 2);
    }

    /**
     * This tests the weaken() method by checking if it will weaken the
     * strength of a particle (ex. sand) completely. The for loop will 
     * run weaken() until the strength is zero and removed from the world.
     */
    public void testWeaken2()
    {
        world = new ParticleWorld();
        Sand sandy = new Sand();
        world.add(sandy, 1, 1);
        for (int i = 0; i < 100; i++)
        {
            sandy.weaken();
        }

        assertEquals(0, sandy.getStrength(), 2);
        assertNull(world.getOneObjectAt(1, 1));
    }

    /**
     * This tests the getter method for getStrength() by asserting that the
     * density of a sand particle is 2.5 g/cm^3. This shows that the
     * method works.
     */
    public void testGetDensity()
    {
        Sand sandy = new Sand();
        assertEquals(2.50, sandy.getDensity(), 2);
    }

    /**
     * This tests the getter method for getAccelleration() by asserting that 
     * the acceleration of a sand particle is 1 m/s^2. This shows that the
     * method works.
     */
    public void testGetAcceleration()
    {
        Sand sandy = new Sand();
        assertEquals(1.0, sandy.getDensity(), 2);
    }

    /**
     * This tests the getter method for getVelocity() by asserting that the
     * velocity of a sand particle starts at zero. This shows that the
     * method works.
     */
    public void testGetVelocity()
    {
        Sand sandy = new Sand();
        assertEquals(0.0, sandy.getVelocity(), 2);
    }

    /**
     * This tests the getter method for getStrength() by asserting that the
     * strength of a sand particle starts at 100. This shows that the
     * method works.
     */
    public void testGetStrength()
    {
        Sand sandy = new Sand();
        assertEquals(100, sandy.getStrength(), 2);
    }

    /**
     * This tests the willDissolve() method by asserting that sand is
     * dissolveable (asserting willDissolve() is true).
     */
    public void testWillDissolve()
    {
        Sand sandy = new Sand();
        assertTrue(sandy.willDissolve());
    }

    /**
     * This tests the willDissolve() method by asserting that water cannot
     * dissolve (asserting willDissolve() is false).
     */
    public void testWillDissolve2()
    {
        Water wally = new Water();
        assertFalse(wally.willDissolve());
    }

    /**
     * This tests the willDissolve() method by asserting that steel is
     * dissolveable (asserting willDissolve() is true).
     */
    public void testWillDissolve3()
    {
        Steel steve = new Steel();
        assertTrue(steve.willDissolve());
    }

    /**
     * This tests the willDissolve() method by asserting that acid cannot
     * dissolve (asserting willDissolve() is false).
     */
    public void testWillDissolve4()
    {
        Acid ally = new Acid();
        assertFalse(ally.willDissolve());
    }

    /**
     * This tests the method isFalling() by calling a sand particle into
     * the world at (4, 4) and asserting that it is indeed falling (since 
     * there's nothing below it).
     */
    public void testIsFalling()
    {
        world = new ParticleWorld();
        Sand sandy = new Sand();
        world.add(sandy, 4, 4);

        assertTrue(sandy.isFalling());
    }

    /**
     * This tests the method isFalling() by calling a sand particle into
     * the world at (4, 4) and a steel particle right below it at (4, 5).
     * Because there is a steel particle underneath, the sand should not fall,
     * thus returning false.
     */
    public void testIsFalling2()
    {
        world = new ParticleWorld();
        Sand sandy = new Sand();
        world.add(sandy, 4, 4);
        Steel steve = new Steel();
        world.add(steve, 4, 5);

        assertFalse(sandy.isFalling());
    }

    /**
     * This tests the method fall() by calling fall onto a sand particle
     * thats at (4, 4). This test asserts that the particle is indeed
     * falling, and that the velocity and acceleration were at 1.
     */
    public void testFall()
    {
        world = new ParticleWorld(100, 100);
        Sand sandy = new Sand();
        world.add(sandy, 4, 4);
        Steel steve = new Steel();
        world.add(steve, 4, 100);

        sandy.fall();

        assertEquals(1, sandy.getVelocity(), 0.01);
        assertEquals(1, sandy.getAcceleration(), 0.01);
        assertTrue(sandy.isFalling());
    }

    /**
     * This tests the method fall() by calling fall onto a sand particle
     * thats at (4, 4) and directly above a steel particle. This
     * should return false, because the sand particle isn't falling and
     * will have the velocity of 0.
     */
    public void testFall2()
    {
        world = new ParticleWorld(100, 100);
        Sand sandy = new Sand();
        world.add(sandy, 4, 4);
        Steel steve = new Steel();
        world.add(steve, 4, 5);

        sandy.fall();

        assertEquals(0, sandy.getVelocity(), 0.01);
        assertFalse(sandy.isFalling());
    }

    /**
     * This tests the swapPlacesIfPossible() method by calling a
     * sand particle into the world and asserting that it can't go
     * out of bounds.
     */
    public void testSwapPlacesIfPossible()
    {
        world = new ParticleWorld(5, 1);
        Sand sandy = new Sand();
        world.add(sandy, 4, 0);

        assertFalse(sandy.swapPlacesIfPossible(-1, 2));
    }
    
    /**
     * This tests the swapPlacesIfPossible() method by calling a
     * sand particle into the world and asserting that it can't go
     * out of bounds.
     */
    public void testSwapPlacesIfPossible2()
    {
        world = new ParticleWorld(5, 1);
        Sand sandy = new Sand();
        world.add(sandy, 4, 0);

        assertFalse(sandy.swapPlacesIfPossible(2, -1));
    }

    /**
     * This tests the swapPlacesIfPossible() method by calling a
     * sand particle into the world and asserting that it can't go
     * out of bounds.
     */
    public void testSwapPlacesIfPossible3()
    {
        world = new ParticleWorld(1, 5);
        Sand sandy = new Sand();
        world.add(sandy, 0, 1);

        assertFalse(sandy.swapPlacesIfPossible(1, 2));
    }

    /**
     * This tests the swapPlacesIfPossible() method by calling a
     * sand particle into the world and asserting that it can't go
     * out of bounds.
     */
    public void testSwapPlacesIfPossible4()
    {
        world = new ParticleWorld(5, 5);
        Sand sandy = new Sand();
        world.add(sandy, 4, 1);

        assertFalse(sandy.swapPlacesIfPossible(3, 6));
    }
    
    /**
     * This tests the swapPlacesIfPossible() method by calling a
     * sand particle sandy at (0, 3), a water particle wally at
     * (1, 4), and a steel particle steve at (0, 4). 
     * Since the water has a lower density than the sand, the sand
     * will swap places with it.
     * Since the steel has a higher density and is immobile, it
     * cannot switch places with the sand.
     */
    public void testSwapPlacesIfPossible6()
    {
        world = new ParticleWorld(5, 5);
        Sand sandy = new Sand();
        world.add(sandy, 0, 3);
        Water wally = new Water();
        world.add(wally, 1, 4);
        Steel steve = new Steel();
        world.add(steve, 0, 4);

        assertTrue(sandy.swapPlacesIfPossible(1, 4));
        assertFalse(sandy.swapPlacesIfPossible(0, 4));
    }

    /**
     * This tests dodge() by creating a sand particle sandy at
     * (3, 1) and two other sand particles on both sides of the
     * empty space directly below sandy. When dodge is called, 
     * sandy should fall in the space right below its current
     * position (3, 2).
     */
    public void testDodge()
    {
        world = new ParticleWorld(5, 5);
        Sand sandy = new Sand();
        world.add(sandy, 3, 1);
        Sand sonja = new Sand();
        world.add(sonja, 2, 2);
        Sand sonny = new Sand();
        world.add(sonny, 4, 2);
        sandy.dodge();

        assertEquals(3, sandy.getGridX());
        assertEquals(2, sandy.getGridY());
    }

    /**
     * This tests dodge() by creating a sand particle sandy at
     * (9, 8) and another sand particle at (9, 9). Since sandy is
     * already at the right edge of the world, it will have to swap
     * places with the empty spot to the left of the other sand
     * particle (x - 1, y + 1).
     */
    public void testDodge2()
    {
        world = new ParticleWorld(10, 10);
        Sand sandy = new Sand();
        world.add(sandy, 9, 8);
        Sand stewart = new Sand();
        world.add(stewart, 9, 9);
        sandy.dodge();

        assertEquals(8, sandy.getGridX());
        assertEquals(9, sandy.getGridY());
    }

    /**
     * This tests dodge() by creating a sand particle sandy at
     * (9, 8) and another sand particle at (8, 9). Since sandy is
     * already at the right edge of the world and there's an empty
     * space directly below sandy, the particle will swap places
     * with the empty space right below its current position.
     */
    public void testDodge3()
    {
        world = new ParticleWorld(10, 10);
        Sand sandy = new Sand();
        world.add(sandy, 9, 8);
        Sand stewart = new Sand();
        world.add(stewart, 8, 9);
        sandy.dodge();

        assertEquals(9, sandy.getGridX());
        assertEquals(9, sandy.getGridY());
    }
    
    /**
     * This tests dodge() by creating a sand particle sandy at
     * (0, 8) and another sand particle at (0, 9). Since sandy is
     * already at the left edge of the world, it will have to swap
     * places with the empty spot to the right of the other sand
     * particle (x + 1, y + 1).
     */
    public void testDodge4()
    {
        world = new ParticleWorld(10, 10);
        Sand sandy = new Sand();
        world.add(sandy, 0, 8);
        Sand stewart = new Sand();
        world.add(stewart, 0, 9);
        sandy.dodge();

        assertEquals(1, sandy.getGridX());
        assertEquals(9, sandy.getGridY());
    }

    /**
     * This tests the act() by adding a sand particle sandy
     * to (1, 1) and calling the act method. Since there's nothing
     * below the particle, it will return true for isFalling().
     */
    public void testAct()
    {
        world = new ParticleWorld(10, 10);
        Sand sandy = new Sand();
        world.add(sandy, 1, 1);
        sandy.act();

        assertTrue(sandy.isFalling());
    }

    /**
     * This tests the act() by creating a sand particle at (9, 8)
     * and a steel particle at (9, 9). When calling act, the
     * particle will either continue to fall or dodge. Since there's
     * a steel particle right below the sand particle, the sand will
     * dodge it by going to the spot left of the steel (since both are
     * already at the right edge of the world).
     */
    public void testAct2()
    {
        world = new ParticleWorld(10, 10);
        Sand sandy = new Sand();
        world.add(sandy, 9, 8);
        Sand stewart = new Sand();
        world.add(stewart, 9, 9);
        sandy.act();

        assertEquals(8, sandy.getGridX());
        assertEquals(9, sandy.getGridY());
    }

    /**
     * This tests the act() by creating a sand particle at (9, 8)
     * and a steel particle at (8, 9). When calling act, the
     * particle will either continue to fall or dodge. Since there's
     * an empty space below the sand particle, it will fall into 
     * that spot.
     */
    public void testAct3()
    {
        world = new ParticleWorld(10, 10);
        Sand sandy = new Sand();
        world.add(sandy, 9, 8);
        Sand stewart = new Sand();
        world.add(stewart, 8, 9);
        sandy.act();

        assertEquals(9, sandy.getGridX());
        assertEquals(9, sandy.getGridY());
    }

    /**
     * This tests the act() by creating a sand particle at (3, 1)
     * and two other sand particles at (2, 2) and (4, 2). Since
     * the spot directly below is empty, the san dparticle will
     * fall into the spot right below.
     */
    public void testAct4()
    {
        world = new ParticleWorld(5, 5);
        Sand sandy = new Sand();
        world.add(sandy, 3, 1);
        Sand sonja = new Sand();
        world.add(sonja, 2, 2);
        Sand sonny = new Sand();
        world.add(sonny, 4, 2);
        sandy.act();

        assertEquals(3, sandy.getGridX());
        assertEquals(2, sandy.getGridY());
    }
}
