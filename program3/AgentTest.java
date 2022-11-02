import sofia.micro.*;

// -------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)

/**
 *  This test class will test out all of the methods in the Agent
 *  class to make sure the program does what it's intended to do.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.03.19)
 */
public class AgentTest extends TestCase
{
    //~ Fields ................................................................
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new AgentTest test object.
     */
    public AgentTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    //~ Methods ...........................
    // ----------------------------------------------------------
   

    /**
     * This tests if the two animals in the city are the same
     * kind (both monkeys). This should return true.
     */
    public void testIsSameKindAsTrue()
    {
        // 1. Set up initial conditions
        City city = new City(2, 2);
        // create monkey 1
        Agent mona = new Agent("monkey", 0.2);
        city.add(mona, 0, 0);

        // create monkey 2
        Agent michelle = new Agent("monkey", 0.2);
        city.add(michelle, 1, 0);

        // 2. Call the method(s) you are testing
        boolean check = mona.isSameKindAs(michelle);

        // 3. Make assertions capturing your expected outcomes
        assertTrue(check);
    }

    /**
     * This tests if the two animals in the city are the same
     * kind (both monkeys). This should return false.
     */
    public void testIsSameKindAsFalse()
    {
        // 1. Set up initial conditions
        City city = new City(2, 2);
        // create monkey 1
        Agent mona = new Agent("monkey", 0.2);
        city.add(mona, 0, 0);

        // create monkey 2
        Agent elle = new Agent("elephant", 0.2);
        city.add(elle, 1, 0);

        // 2. Call the method(s) you are testing
        boolean check = mona.isSameKindAs(elle);

        // 3. Make assertions capturing your expected outcomes
        assertFalse(check);
    }

    /**
     * This tests if the an animal is satisfied in its current spot, with
     * another animal right next to it.
     * Since the two animals are both elephants, the assertion should
     * be true.
     */
    public void testIsSatisfiedAt()
    {
        // 1. Set up initial conditions
        // Create world make it a 2x2
        City city = new City(2, 2);
        // add agents (example add elephent to 0,0)
        Agent bob = new Agent("elephant", 0.2);
        city.add(bob, 0, 0);
        // add another elephant agent 1,0 (bob2)
        Agent chad = new Agent("elephant", 0.2);
        city.add(chad, 1, 0);

        // 2. Call the method(s) you are testing
        boolean check = chad.isSatisfiedAt(1, 0);

        // 3. Make assertions capturing your expected outcomes
        assertTrue(check);
    }

    /**
     * This tests if the an animal is satisfied in its current spot, with
     * another animal right under it.
     * Since the two animals are both elephants, the assertion should
     * be true.
     */
    public void testIsSatisfiedAt2()
    {
        // 1. Set up initial conditions
        // Create world make it a 2x2
        City city = new City(2, 2);
        // add agents (example add elephent to 0,0)
        Agent bob = new Agent("elephant", 0.2);
        city.add(bob, 0, 0);
        // add another elephant agent 1,0 (bob2)
        Agent chad = new Agent("elephant", 0.2);
        city.add(chad, 0, 1);

        // 2. Call the method(s) you are testing
        boolean check = chad.isSatisfiedAt(0, 1);

        // 3. Make assertions capturing your expected outcomes
        assertTrue(check);
    }

    /**
     * This tests if the an animal is satisfied in its current spot, with
     * two different animals surrounding it.
     * Since the the monkey is only surrounded by elephants, the assertion 
     * should be false.
     */
    public void testIsSatisfiedAt3()
    {
        // 1. Set up initial conditions
        // Create world make it a 2x2
        City city = new City(2, 2);
        // add agents (example add elephent to 0,0)
        Agent bob = new Agent("elephant", 0.25);
        city.add(bob, 0, 0);
        // add a monkey agent at 1,0
        Agent charlotte = new Agent("monkey", 0.25);
        city.add(charlotte, 1, 0);
        // add another elephant to make the monkey unsatisfied 
        Agent danny = new Agent("elephant", 0.25);
        city.add(danny, 0, 1);

        // 2. Call the method(s) you are testing
        boolean check = charlotte.isSatisfiedAt(1, 0);

        // 3. Make assertions capturing your expected outcomes
        assertFalse(check);
    }
    
    /**
     * This tests if the an animal is satisfied in its current spot, with
     * two elephants and one monkey in the city.
     * Since one the elephant (danny) is not surrounded by any animals,
     * the assertion should be false.
     */
    public void testIsSatisfiedAt4()
    {
        // 1. Set up initial conditions
        // Create world make it a 2x2
        City city = new City(3, 3);
        // add agents (example add elephent to 0,0)
        Agent bob = new Agent("elephant", 0.25);
        city.add(bob, 0, 0);
        // add a monkey agent at 1,0
        Agent charlotte = new Agent("monkey", 0.25);
        city.add(charlotte, 1, 0);
        // add another elephant to make the monkey unsatisfied 
        Agent danny = new Agent("elephant", 0.25);
        city.add(danny, 2, 2);

        // 2. Call the method(s) you are testing
        boolean check = danny.isSatisfiedAt(2, 2);

        // 3. Make assertions capturing your expected outcomes
        assertFalse(check);
    }
    
     /**
     * This tests if the animal being checked is satisfied where it is.
     * Since both animals are elephants, the assertion should be true.
     */
    public void testIsSatisfiedTrue()
    {
        // 1. Set up initial conditions
        // Create world make it a 2x2
        City city = new City(2, 2);
        // add agents (example add elephent to 0,0)
        Agent bob = new Agent("elephant", 0.2);
        city.add(bob, 0, 0);
        // add another elephant agent 1,0 (bob2)
        Agent chad = new Agent("elephant", 0.2);
        city.add(chad, 0, 1);

        // 2. Call the method(s) you are testing
        boolean check = chad.isSatisfied();

        // 3. Make assertions capturing your expected outcomes
        assertTrue(check);
    }

    /**
     * This tests if the animal being checked is satisfied where it is.
     * Since the animal beig checked (monkey) is only surrounded by
     * elephants, the assertion should be false.
     */
    public void testIsSatisfiedFalse()
    {
        // 1. Set up initial conditions
        // Create world make it a 2x2
        City city = new City(2, 2);
        // add agents (example add elephent to 0,0)
        Agent bob = new Agent("elephant", 0.25);
        city.add(bob, 0, 0);
        // add a monkey agent at 1,0
        Agent charlotte = new Agent("monkey", 0.25);
        city.add(charlotte, 1, 0);
        // add another elephant to make the monkey unsatisfied 
        Agent danny = new Agent("elephant", 0.25);
        city.add(danny, 0, 1);

        // 2. Call the method(s) you are testing
        boolean check = charlotte.isSatisfied();

        // 3. Make assertions capturing your expected outcomes
        assertFalse(check);
    }
    
    /**
     * This tests if all the animals will relocate if they're unsatisfied
     * with their current position.
     * With this test in particular, the elephant ("E" or elsa) will be 
     * unsatisfied, but will be unable to relocate since there are no 
     * available/empty spaces.
     */
    public void testRelocate()
    {
        // 1. Set up initial conditions
        // e m m
        // m m m
        // e m E
        // E.act(); 20%
        // assert that its x and y value are now 0, 0

        City city = new City(3, 3);
        
        Agent murrey = new Agent("monkey", 0.2);
        city.add(murrey, 1, 0);
        
        Agent eddie = new Agent("elephant", 0.2);
        city.add(eddie, 0, 0);
        
        Agent emma = new Agent("elephant", 0.2);
        city.add(emma, 0, 2);

        Agent maddie = new Agent("monkey", 0.2);
        city.add(maddie, 2, 0);

        Agent monica = new Agent("monkey", 0.2);
        city.add(monica, 0, 1);

        Agent monique = new Agent("monkey", 0.2);
        city.add(monique, 1, 1);

        Agent mark = new Agent("monkey", 0.2);
        city.add(mark, 2, 1);

        Agent melanie = new Agent("monkey", 0.2);
        city.add(melanie, 1, 2);

        Agent elsa = new Agent("elephant", 0.2);
        city.add(elsa, 2, 2);

        // 2. Call the method(s) you are testing
        elsa.relocate();
        boolean check = elsa.isSatisfiedAt(2, 2);

        // 3. Make assertions capturing your expected outcomes
        assertEquals(elsa.getGridX(), 2);
        assertEquals(elsa.getGridY(), 2);
        assertFalse(check);

    }
    

    /**
     * This tests if all the animals will relocate if they're unsatisfied
     * with their current position.
     * With this test in particular, the animal ("E" or elsa) should move
     * to 0, 0 where it will be satisfied.
     */
    public void testAct()
    {
        // 1. Set up initial conditions
        // 0 e m
        // m m m
        // 0 m E
        // E.act(); 20%
        // assert that its x and y value are now 0, 0

        City city = new City(3, 3);
        Agent eddie = new Agent("elephant", 0.2);
        city.add(eddie, 1, 0);

        Agent maddie = new Agent("monkey", 0.2);
        city.add(maddie, 2, 0);

        Agent monica = new Agent("monkey", 0.2);
        city.add(monica, 0, 1);

        Agent monique = new Agent("monkey", 0.2);
        city.add(monique, 1, 1);

        Agent mark = new Agent("monkey", 0.2);
        city.add(mark, 2, 1);

        Agent melanie = new Agent("monkey", 0.2);
        city.add(melanie, 1, 2);

        Agent elsa = new Agent("elephant", 0.2);
        city.add(elsa, 2, 2);

        // 2. Call the method(s) you are testing
        elsa.act();

        // 3. Make assertions capturing your expected outcomes
        assertEquals(elsa.getGridX(), 0);
        assertEquals(elsa.getGridY(), 0);

    }

    /**
     * This tests if all the animals will relocate if they're unsatisfied
     * with their current position.
     * With this test in particular, the animal ("E" or elsa) should stay in
     * its current position, since it's satisfied. 
     */
    public void testAct2()
    {
        // 1. Set up initial conditions
        // 0 m m
        // m m e
        // 0 e E
        // E.act(); 20%
        // assert that its x and y value are now 0, 0

        City city = new City(3, 3);
        Agent margot = new Agent("monkey", 0.2);
        city.add(margot, 1, 0);

        Agent maddie = new Agent("monkey", 0.2);
        city.add(maddie, 2, 0);

        Agent monica = new Agent("monkey", 0.2);
        city.add(monica, 0, 1);

        Agent monique = new Agent("monkey", 0.2);
        city.add(monique, 1, 1);

        Agent eric = new Agent("elephant", 0.2);
        city.add(eric, 2, 1);

        Agent edna = new Agent("elephant", 0.2);
        city.add(edna, 1, 2);

        Agent elsa = new Agent("elephant", 0.2);
        city.add(elsa, 2, 2);

        // 2. Call the method(s) you are testing

        boolean check = elsa.isSatisfiedAt(2, 2);

        elsa.act();

        // 3. Make assertions capturing your expected outcomes
        assertTrue(check);
        assertEquals(elsa.getGridX(), 2);
        assertEquals(elsa.getGridY(), 2);

    }

    /**
     * This tests if all the animals will relocate if they're unsatisfied
     * with their current position.
     * With this test in particular, the animal ("E" or elsa) should move
     * to 0, 0 where it will be satisfied. 
     */
    public void testAct3()
    {
        // 1. Set up initial conditions
        // 0 e m
        // e m 0
        // 0 0 E
        // E.act(); 20%
        // assert that its x and y value are now 0, 0

        City city = new City(3, 3);
        Agent eddie = new Agent("elephant", 0.2);
        city.add(eddie, 1, 0);

        Agent maddie = new Agent("monkey", 0.2);
        city.add(maddie, 2, 0);

        Agent monica = new Agent("monkey", 0.2);
        city.add(monica, 0, 1);

        Agent monique = new Agent("monkey", 0.2);
        city.add(monique, 1, 1);

        Agent elsa = new Agent("elephant", 0.2);
        city.add(elsa, 2, 2);

        // 2. Call the method(s) you are testing
        elsa.act();

        boolean check = elsa.isSatisfiedAt(2, 2);

        // 3. Make assertions capturing your expected outcomes
        assertFalse(check);
        assertEquals(elsa.getGridX(), 0);
        assertEquals(elsa.getGridY(), 0);

    }

    /**
     * This tests if all the animals will relocate if they're unsatisfied
     * with their current position.
     * With this test in particular, the animal ("E" or elsa) should stay in
     * its current position, since it's satisfied. 
     */
    public void testAct4()
    {
        // 1. Set up initial conditions
        // 0 e m
        // m m e
        // 0 0 E
        // E.act(); 20%
        // assert that its x and y value are now 0, 0

        City city = new City(3, 3);
        Agent eddie = new Agent("elephant", 0.2);
        city.add(eddie, 1, 0);

        Agent maddie = new Agent("monkey", 0.2);
        city.add(maddie, 2, 0);

        Agent monica = new Agent("monkey", 0.2);
        city.add(monica, 0, 1);

        Agent monique = new Agent("monkey", 0.2);
        city.add(monique, 1, 1);

        Agent eric = new Agent("elephant", 0.2);
        city.add(eric, 2, 1);

        Agent elsa = new Agent("elephant", 0.2);
        city.add(elsa, 2, 2);

        // 2. Call the method(s) you are testing
        elsa.act();

        boolean check = elsa.isSatisfiedAt(2, 2);

        // 3. Make assertions capturing your expected outcomes
        assertEquals(elsa.getGridX(), 2);
        assertEquals(elsa.getGridY(), 2);
        assertTrue(check);

    }
    
    /**
     * This tests if all the animals will relocate if they're unsatisfied
     * with their current position.
     * With this test in particular, the elephant ("E" or elsa) should 
     * move to 0, 0, where it will be satisfied.
     */
    public void testAct5()
    {
        // 1. Set up initial conditions
        // 0 e m
        // m m m
        // 0 0 E
        // E.act(); 20%
        // assert that its x and y value are now 0, 0

        City city = new City(3, 3);
        Agent eddie = new Agent("elephant", 0.2);
        city.add(eddie, 1, 0);

        Agent maddie = new Agent("monkey", 0.2);
        city.add(maddie, 2, 0);

        Agent monica = new Agent("monkey", 0.2);
        city.add(monica, 0, 1);

        Agent monique = new Agent("monkey", 0.2);
        city.add(monique, 1, 1);

        Agent missy = new Agent("monkey", 0.2);
        city.add(missy, 2, 1);

        Agent elsa = new Agent("elephant", 0.2);
        city.add(elsa, 2, 2);

        // 2. Call the method(s) you are testing
        elsa.act();

        boolean check = elsa.isSatisfiedAt(2, 2);

        // 3. Make assertions capturing your expected outcomes
        assertEquals(elsa.getGridX(), 0);
        assertEquals(elsa.getGridY(), 0);
        assertFalse(check);

    }

}
