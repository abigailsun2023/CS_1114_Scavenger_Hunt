import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  The methods used in myProgram are made to help Jeroo maneuver around
 *  the grid to pick all the flowers and move back toward the center.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.02.02)
 */
public class ScavengerHunt extends LongIsland
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new ScavengerHunt object.
     */
    public void myProgram()
    {
        FloraJeroo flora = new FloraJeroo(2, 2);
        this.add(flora);
        flora.maneuverCorner();
        flora.pickUpperRow();
        flora.moveToBottom();
        flora.pickLowerRow();
        flora.moveToCenter();
        

    }

    //~ Methods ...............................................................

}
