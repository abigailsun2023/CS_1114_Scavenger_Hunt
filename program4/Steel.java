import sofia.micro.*;
import sofia.graphics.Color;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)
/**
 *  The Steel class is made so that the steal is initialized, and
 *  is main purpose is to be immobile and dissolved by acid.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.04.13)
 */
public class Steel extends Particle
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * The super calls to the parent method and makes it so that 
     * the steel is gray colored, dissolves in acid, and has the
     * density of 7.87 g/cm^3.
     */
    public Steel()
    {
        super(Color.gray, true, 7.87);
    }

    /**
     * By overriding the isFalling() method in the Particle 
     * (Parent) class, this boolean will return false and 
     * make the steel immobile.
     *
     * @return isFalling Returns false when program runs
     */
    @Override
    public boolean isFalling()
    {
        return false;
    }

    /**
     * By overriding the dodge() method in the Particle class,
     * this boolean will return false and will make it so that 
     * the steel does not dodge particles and will be immobile.
     *
     * @return dodge    Returns false when program runs
     */
    @Override
    public boolean dodge()
    {
        return false;
    }

}
