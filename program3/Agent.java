import sofia.micro.*;

//-------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)

/**
 *  In the Agent class, the objective is to create methods that will
 *  allow the program to check the animals location, check if it's satisfied,
 *  and move the animal if not satisfied.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.03.04)
 */
public class Agent extends Actor
{
    //~ Fields ................................................................
    private String animals;
    private double thresholds;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Agent object.
     * 
     * @param animal         The string of animals
     * @param threshold      The value of the thresholds
     */
    public Agent(String animal, double threshold)
    {
        animals = animal;
        thresholds = threshold;
        setImage(animals + ".png");
    }

    /**
     * This method returns the kind of agent as a string 
     * (gets the kind of animal.)
     * 
     * @return getKind       Returns the kind of agent
     */
    public String getKind()
    {
        return animals;
    }

    /**
     * This method will return the agent's satisfaction threshold
     * as a double value.
     * 
     * @return getThreshold      Returns the agent's satisfaction
     *                          threshold
     */
    public double getThreshold()
    {
        return thresholds;
    }

    /**
     * This boolean returns true if the agent is satisfied, and will
     * return false if the agent is not satisfied.
     * 
     * @return isSameKindAs     Returns the kind of animal
     * 
     * @param agent     The agent is what helps the animals 
     *                  sort into their kind
     */
    public boolean isSameKindAs(Agent agent)
    {
        return agent.getKind().equals(animals);
    }

    /**
     * @return isSatisfiedAt        Returns true if the animal
     *                              is satisfied at the current 
     *                              location.
     * 
     * @param x      This is the x-axis
     * @param y      This is the y-axis
     */
    public boolean isSatisfiedAt(int x, int y)
    {
        int same = 0;
        int total = 0;

        int startX = Math.max(x - 1, 0);
        int endX = Math.min(x + 1, this.getWorld().getWidth() - 1);
        int startY = Math.max(y - 1, 0);
        int endY = Math.min(y + 1, this.getWorld().getHeight() - 1);
        for (int i = startX; i <= endX; i++)
        {
            for (int j = startY; j <= endY; j++)
            {

                Agent agent = this.getWorld().getOneObjectAt(i, j, Agent.class);
                if ((agent != null) && (agent != this))
                {
                    total++;
                    if (this.isSameKindAs(agent))
                    {
                        same++;
                    }
                    

                }
            }
        }
        if (total == 0)
        {
            return false;
        }

        return ((double)same / (double)total) >= thresholds;

    }

    /**
     * This boolean varifies if the agent is satisfied at its current
     * location by returning if its current location with the 
     * isSatisfiedAt(x, y) method.
     * 
     * @return isSatisfied      Returns if the animal is satisfied
     *                          in its current spot or not.
     */
    public boolean isSatisfied()
    {
        return this.isSatisfiedAt(this.getGridX(), this.getGridY());
    }

    /**
     * This method allows an animal to relocate to a location where it
     * will be satisfied.
     */
    public void relocate()
    {
        for (int a = 0; a < this.getWorld().getWidth(); a++)
        {
            for (int b = 0; b < this.getWorld().getHeight(); b++)
            {
                Agent boom = this.getWorld().getOneObjectAt(a, b, Agent.class);
                if (boom == null && this.isSatisfiedAt(a, b) )
                {
                    this.setGridLocation(a, b);
                    return;
                }
            }
        }
    }

    /**
     * This act() method basically means that if an animal is not satisfied
     * (not surrounded enough by the same kind), it will relocate to
     * a new location where it will be satisfied.
     */
    public void act()
    { 
        if (!this.isSatisfied())
        {
            this.relocate();
        }
    }

}
