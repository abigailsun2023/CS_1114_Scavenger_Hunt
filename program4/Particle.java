import sofia.micro.*;
import sofia.graphics.Color;

// Virginia Tech Honor Code Pledge:
// 
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)
/**
 *  The Particle class is made to initialize all of the basic characteristics of
 *  each type of particle (sand, water, acid, steel). These characteristics
 *  include velocity, color, acceleration, strength, density, and its ability
 *  to dissolve. The methods written in this class will help determine the 
 *  overall behavior of each type of particle.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.04.03)
 */
public class Particle extends ParticleBase
{
    //~ Fields ................................................................
    private double velocity;
    private double acceleration;
    private int strength;
    private double density;
    private boolean willDissolve;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------

    /**
     * Creates a new Particle object.
     * This constructor calls a super for color so that the particles
     * can be colored according to the subclass of the particle (khaki
     * for sand, blue for water, etc.)
     *
     * @param color        The color of the particle
     * @param willDissolve The ability to dissolve in acid
     * @param density      The density of the particle
     * 
     */
    public Particle(Color color, boolean willDissolve, double density)
    {
        super(color);
        velocity = 0.0;
        acceleration = 1.0;
        strength = 100;
        this.density = density;
        this.willDissolve = willDissolve;
    }

    /**
     * A getter method that returns particle's density 
     * (a floating-point value).
     *
     * @return getDensity()   Returns the density of a particle
     */
    public double getDensity()
    {
        return density;
    }

    /**
     * A getter method that returns this particle's downward 
     * velocity (a floating-point value).
     *
     * @return getVelocity()   Returns the velocity of a particle
     */
    public double getVelocity()
    {
        return velocity;
    }

    /**
     * A getter method that returns this particle's downward 
     * acceleration (a floating-point value).
     *
     * @return getAcceleration()  Returns the acceleration of a particle
     */
    public double getAcceleration()
    {
        return acceleration;
    }

    /**
     * A getter method that returns this particle's strength 
     * (an integer value).
     *
     * @return getStrength()  Returns the strength of a particle
     */
    public int getStrength()
    {
        return strength;
    }

    /**
     * A getter method that returns thae boolean value indicating 
     * whether this particle can be dissolved (i.e., is it reactive).
     *
     * @return willDissolve()   Returns the dissolvibilty of a particle
     */
    public boolean willDissolve()
    {
        return willDissolve;
    }

    /**
     * This method reduces the particle's strength by 1. If the strength 
     * becomes zero, this method should remove this particle from the world.
     */
    public void weaken()
    {       
        strength = this.strength - 1;

        if (strength == 0)
        {
            this.remove();
        }
    }

    /**
     * Returns a boolean value indicating whether this particle is 
     * in free-fall or not.
     *
     * @return isFalling   Returns if the particle is in free-fall
     */
    public boolean isFalling()
    {    
        int x = this.getGridX();
        int y = this.getGridY();        
        return ((y < this.getWorld().getHeight() - 1) && 
            (this.getWorld().getOneObjectAt(
                    x, y + 1, Particle.class) == null)); 
    }

    /**
     * This method helps to apply the natural physics of a real life
     * particle to a particle in the program. In other words, 
     * this method will increase the velocity as the particle falls
     * farther down.
     * If the particle stops/isn't falling, then the velocity will
     * return back to zero.
     */
    public void fall()
    {
        velocity = acceleration + velocity;
        int v = (int) velocity;
        int y = this.getGridY();
        int x = this.getGridX();
        for (int i = 0; i < v && this.isFalling(); i++)
        {
            y = y + 1;
            this.setGridLocation(x, y);
        }
        if (!(this.isFalling()))
        {
            velocity = 0;
        }
    }

    /**
     * This method helps the particle swap places when possible. The
     * particle needs to stay in bounds, so it can't leave or swap places
     * anywhere outside the grid.
     * If the particle falls on top of something, it'll switch places with
     * a spot that's empty/contains a particle of a lower density.
     * 
     * @param x   The x-axis coordinate
     * @param y   The y-axis coordinate
     * @return swapPlacesIfPossible()   Returns if a particle is
     *                                  able to swap places with a
     *                                  nearby particle.
     */
    public boolean swapPlacesIfPossible(int x, int y)
    {
        if ((x < 0) || (x > this.getWorld().getWidth() - 1) || (
            y > this.getWorld().getHeight() - 1) || (y < 0))
        {
            return false;
        }
        else
        {
            Particle perry = this.getWorld().getOneObjectAt(
                    x, y, Particle.class);
            if (perry == null)
            {
                this.setGridLocation(x, y);
                return true;
            }
            else if (this.getDensity() > perry.getDensity())
            {
                perry.setGridLocation(this.getGridX(), this.getGridY());
                this.setGridLocation(x, y);
                return true;
            }
        }
        return false;
    }

    /**
     * The dodge method implements swapIfPossible() when it lands (or is
     * about to land) on top of something. If there is another particle
     * under the particle that's falling, then the falling particle will
     * "dodge" it by moving one over to either the left or right and down
     * one (when possible). If the spot right below is empty, then the
     * falling particle will move there.
     * 
     * @return dodge()      Returns if the particle is able to
     *                      "dodge", or not
     */
    public boolean dodge()
    {
        int x = this.getGridX();
        int y = this.getGridY();
        return this.swapPlacesIfPossible(x, y + 1) || 
        this.swapPlacesIfPossible(x - 1, y + 1) ||
        this.swapPlacesIfPossible(x + 1, y + 1);
    }

    /**
     * Executes one "turn" for this particle. 
     * The particle should fall, if it is falling, 
     * or dodge otherwise.
     */
    public void act()
    {
        if (this.isFalling())
        {
            this.fall();
        }
        else 
        {
            this.dodge();
        }
    }
}
