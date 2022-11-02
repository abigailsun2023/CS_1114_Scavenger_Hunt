import sofia.micro.*;
import sofia.graphics.Color;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)
/**
 *  The Acid Class initializes the acid particles in the program. The 
 *  methods written in here defines the behavior of each acid particle.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.04.13)
 */
public class Acid extends Fluid
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Acid object.
     * The super calls to the parent method and makes it so that 
     * the acid is green colored, doesn't dissolve in acid, and 
     * has the density of 1.00 g/cm^3.
     */
    public Acid()
    {
        super(Color.green, false, 1.00);
    }

    /**
     * This method checks if the acid particle is able to dissolve
     * any nearby particles.
     * 
     * @param x The x-coordinate of the particle
     * @param y The y-coordinate of the particle
     */
    public void dissolveIfPossible(int x, int y)
    {
        //check if this acid is in the world
        //check to make sure that x && y are in bounds
        World world = this.getWorld();
        if ((world == null) || (x >= world.getWidth()) || 
            (y >= world.getHeight()) || (x < 0) || (y < 0))
        {
            return;
        }
        else if ((world.getOneObjectAt(x, y, Particle.class) != null) &&
            (world.getOneObjectAt(x, y, Particle.class).willDissolve()))
        {
            this.weaken();
            world.getOneObjectAt(x, y, Particle.class).weaken();
        }
    }

    /**
     * The act makes it so that the acid particle dissolves the 
     * dissolveable particles around it. If there is some particle 
     * in the world, then the act will call the act method in the
     * Particle class.
     */
    @Override
    public void act()
    {
        int x = this.getGridX();
        int y = this.getGridY();
        this.dissolveIfPossible(x - 1, y);
        this.dissolveIfPossible(x + 1, y);
        this.dissolveIfPossible(x, y - 1);
        this.dissolveIfPossible(x, y + 1);
        if (this.getWorld() != null)
        {
            super.act();
        }
    }
}
