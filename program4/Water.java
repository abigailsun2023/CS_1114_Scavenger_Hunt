import sofia.micro.*;
import sofia.graphics.Color;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)
/**
 *  This Water class is made so that we can initilize water and 
 *  make it so that it functions as a fluid and cannot be dissolved
 *  by acid.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.04.03)
 */
public class Water extends Fluid
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Water object.
     * 
     * The super calls to the parent method and makes it so that 
     * the water is cadet blue colored, doesn't dissolve in acid, 
     * and has the density of 1.00 g/cm^3.
     */
    public Water()
    {
        super(Color.cadetBlue, false, 1.00);
    }
}
