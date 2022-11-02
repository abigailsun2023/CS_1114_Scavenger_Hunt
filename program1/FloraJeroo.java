import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  FloraJeroo allows the Jeroo to maneuver in differet ways in order to
 *  get and pick all 8 of the flowers on the grid.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.02.03)
 */
public class FloraJeroo extends Jeroo
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new FlowerPicker facing east with no flowers.
     * @param x          The x-coordinate of the Jeroo's location.
     * @param y          The y-coordinate of the Jeroo's location.
     */
    public FloraJeroo(int x, int y)
    {
        super(x, y);
    }
    /**
     * Creates a new Harvester facing east with no flowers.
     * @param x          The x-coordinate of the Jeroo's location.
     * @param y          The y-coordinate of the Jeroo's location.
     */
    /**
     * Allows flora to menuver around the first corner.
     */
    public void maneuverCorner()
    {
        this.hop(); //~ Jeroo needs to maneuver around corner in order
        //to get to the 1st row of flowers.
        this.turn(RIGHT);
        this.hop(2);
        this.turn(LEFT);
        this.hop(2);
        this.turn(LEFT);
        this.hop(3);
        this.turn(RIGHT);
    }
    /**
     * Creates a new Harvester facing east with no flowers.
     * @param x          The x-coordinate of the Jeroo's location.
     * @param y          The y-coordinate of the Jeroo's location.
     */
    /**
     * Allows flora to pick all the flowers in the 1st/upper row.
     */
    public void pickUpperRow()
    {
        this.pick();
        this.hop(3);
        this.pick();
        this.hop(4);
        this.pick();
    }
    /**
     * Creates a new Harvester facing east with no flowers.
     * @param x          The x-coordinate of the Jeroo's location.
     * @param y          The y-coordinate of the Jeroo's location.
     */
    /**
     * Allows FloraJeroo to move to the bottome row of flowers.
     */
    public void moveToBottom()
    {
        this.turn(RIGHT);
        this.hop();
        this.turn(LEFT);
        this.hop();
        this.turn(RIGHT);   //~ These steps were needed
        //to move the Jeroo around
        //the corner.
        this.hop(7);    //~ Brings Jeroo down to the bottom row of flowers.
        this.turn(RIGHT);   //~ Turns the Jeroo so that it's ready
        //to pick the row of flowers.
    }
    /**
     * Creates a new Harvester facing east with no flowers.
     * @param x          The x-coordinate of the Jeroo's location.
     * @param y          The y-coordinate of the Jeroo's location.
     */
    /**
     * Allows FloraJeroo to pick all the flowers in the lower/bottom
     * row (including the flower in between the water and net).
     */
    public void pickLowerRow()
    {
        this.pick();
        this.hop(2);
        this.pick();
        this.hop(3);
        this.pick();    // After the 3rd flower in the row is picked,
        // FloraJeroo now needs to turn the corner to
        // get to the 4th/last flower in the row.
        this.turn(RIGHT);
        this.hop();
        this.turn(LEFT);
        this.hop(2);
        this.turn(LEFT);
        this.hop();
        this.pick();

    }
    /**
     * Creates a new Harvester facing east with no flowers.
     * @param x          The x-coordinate of the Jeroo's location.
     * @param y          The y-coordinate of the Jeroo's location.
     */
    /**
     * Allows FloraJeroo to move to the center of the grid
     * to pick the last flower.
     */
    public void moveToCenter()
    {
        this.turn(LEFT);
        this.turn(LEFT);    //~ Two left turns are needed to make
        //the Jeroo make a 180 degree turn
        //so that it can start moving to
        //the center of the grid.
        this.hop(6);
        this.turn(RIGHT);   //~ Jeroo needs to turn right, hop three
        //times, and turn right again in order
        //to move to the center where the last 
        //flower is.
        this.hop(3);
        this.turn(RIGHT);
        this.hop(2);
        this.pick();
    }

    //~ Methods .....................................................
}

