import sofia.micro.*;
import sofia.graphics.Color;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)
/**
 *  The Sand class is made to initialize the "sand" in this program.
 *  This sand will be khaki colored and will dissolve in acid.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.04.13)
 */
public class Sand extends Particle
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Sand object.
     *
     * The super calls to the parent method and makes it so that 
     * the sand is khaki colored, dissolves in acid, and has the
     * density of 2.5 g/cm^3.
     */
    public Sand()
    {
        super(Color.khaki, true, 2.50);
    }
}
