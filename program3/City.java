import sofia.micro.*;
import sofia.util.Random;

//-----------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)

/**
 *  The methods in this City class will be used to help set up the world
 *  fo the animals.
 *  This will be accomplished by setting the size of the world (x-axis, 
 *  y-axis, and pixels per cell) and the amount of animals (monkeys
 *  and elephants) in the world.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.04.03)
 */
public class City extends World
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new City object.
     * 
     */
    public City()
    {
        this(25, 25);
        this.populate(0.30, 0.40, 0.30);
    }
    
    /**
     * Uses a super to allow the City() method above to set the
     * size of the grid (24, 24).
     * 
     * @param x     The width of the grid.
     * @param y     The height of the grid.
     */
    public City(int x, int y)
    {
        super(x, y, 24);
    }

    /**
     * @param elephant       Returns the value for elephants
     * @param monkey         Returns the value for monkeys
     * @param empty          Returns the value for empty space
     */
    public void populate(double elephant, double monkey, double empty)
    {
        for (int x = 0; x <= this.getWidth() - 1; x++)
        {
            for (int y = 0; y <= this.getHeight() - 1; y++)
            {
                double chance = Random.generator().nextDouble();
                if (chance <= elephant)
                {
                    this.add(new Agent("elephant", empty), x, y);
                }
                else if (chance <= (elephant + monkey))
                {
                    this.add(new Agent("monkey", empty), x, y);
                }
            }
        }
    }
}

