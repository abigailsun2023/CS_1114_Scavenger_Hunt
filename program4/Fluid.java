import sofia.micro.*;
import sofia.graphics.Color;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)
/**
 *  This Fluid class is made to initialize all of the fluid (water and 
 *  acid) particles. All of the methods written in this class will be
 *  applied to all water and acid particles.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.04.13)
 */
public class Fluid extends Particle
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Fluid object.
     * 
     * @param color        The color of the particle
     * @param willDissolve The ability to dissolve in acid
     * @param density      The density of the particle
     */
    public Fluid(Color color, boolean willDissolve, double density)
    {
        super(color, willDissolve, density);
    }

    /**
     * This method overrides the dodge method so that instead of
     * trying to swap places diagonally from the current spot,
     * it'll swap places horizontally left or right.
     */
    @Override
    public boolean dodge()
    {
        int x = this.getGridX();
        int y = this.getGridY();

        return (super.dodge()) || 
            (this.swapPlacesIfPossible(x - 1, y + 0)) ||
            (this.swapPlacesIfPossible(x + 1, y + 0));
    }
}
