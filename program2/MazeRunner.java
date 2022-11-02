import sofia.micro.jeroo.*;

//// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)
/**
 *  The methods in this Jeroo class will allow the Jeroo to pick all
 *  the flowers and disable all the nets.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.02.16)
 */
public class MazeRunner extends Jeroo
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunner object.
     */
    public MazeRunner()
    {
        super(15);
    }
    // ----------------------------------------------------------

    /**
     * Picks one straight line of flowers, stopping when there are no
     * more flowers left.
     * @precondition The jeroo is standing on the first flower in the
     *               line, and is facing in the same direction as the
     *               line of flowers.
     * @postcondition The jeroo has picked the continuous line of
     *                flowers starting from where it was standing, it
     *                ends standing in the spot where the last 
     *                was, still facing the same direction as before.
     */
    public void myProgram()
    {
        clearMaze();
        moveToOrigin();

    }

    /**
     * Allows the Jeroo to harvest all the flowers in the row.
     */
    public void clearMaze()
    {
        while ((this.getWorld().getObjects(Net.class).size() != 0) 
            || (this.getWorld().getObjects(Flower.class).size() != 0))
        {
            this.avoidWater();
            this.disableNet();
            this.pickFlower();
            this.moveStraightAhead();

        }

    }
    /**
     * The method allows for the Jeroo to avoid water
     * by turning when there's water around.
     */
    public void avoidWater()
    {
        if (!this.seesWater(LEFT))
        {
            this.turn(LEFT);
        }
        else if (this.seesWater(AHEAD))
        {
            if (!this.seesWater(RIGHT))
            {
                this.turn(RIGHT);
            }
            else
            {
                this.turn(RIGHT);
                this.turn(RIGHT);
            }
        }
    }

    /**
     * This method allows the Jeroo to toss a flower and
     * disable a net whenever there's a net ahead.
     */
    public void disableNet()
    {
        if (this.seesNet(AHEAD))
        {
            this.toss();
        }
    }

    /**
     * This method allows the Jeroo to pick and hop 
     * whenever there's a flower ahead.
     */
    public void pickFlower()
    {
        if (this.seesFlower(AHEAD))
        {
            this.pick();
            this.hop();
            this.pick();
        }
    }

    /**
     * This method allows the Jeroo to move straight ahead
     * whenever there's no water, nets, or flowers ahead.
     */
    public void moveStraightAhead()
    {
        if (this.isClear(AHEAD))
        {
            this.hop();
        }
    }

    /**
     * Allows the Jeroo to move back to the origin (1, 1)
     * 
     */
    public void moveToOrigin()
    {

        while ((this.getGridX() != 1) || (this.getGridY() != 1))
        {
            this.avoidWater();
            this.moveStraightAhead();
        }
    }

}
