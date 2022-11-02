import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)
/**
 *  This TransforablePictureTest class is made to test all of the
 *  methods in the TransformablePicture class.
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.04.26)
 */
public class TransformablePictureTest extends TestCase
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new TransformablePictureTest test object.
     */
    public TransformablePictureTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        /*# Insert your own setup code here */
    }

    /**
     * This tests the maxRed() by calling the method and asserting
     * that the pixel [0][0] is at the maximum red (255)
     */
    public void testMaxRed()
    {
        TransformablePicture pixie = new TransformablePicture(
                "color5x5.png");

        pixie.maxRed();

        assertEquals(255, pixie.getPixels()[0][0].getRed());

    }

    /**
     * This tests the maxBlue() by calling the method and asserting
     * that the pixel [0][0] is at the maximum blue (255)
     */
    public void testMaxBlue()
    {
        TransformablePicture pixie = new TransformablePicture(
                "color5x5.png");

        pixie.maxBlue();

        assertEquals(255, pixie.getPixels()[0][0].getBlue());
    }

    /**
     * This tests the maxGreen() by calling the method and asserting
     * that the pixel [0][0] is at the maximum green (255)
     */
    public void testMaxGreen()
    {
        TransformablePicture pixie = new TransformablePicture(
                "color5x5.png");

        pixie.maxGreen();

        assertEquals(255, pixie.getPixels()[0][0].getGreen());
    }

    /**
     * This tests the grayscale() by calling the method and asserting
     * that all of the RBG values are at zero.
     */
    public void testGrayscale()
    {
        TransformablePicture pixie = new TransformablePicture(
                "color5x5.png");

        pixie.grayscale();

        assertEquals(0, pixie.getPixels()[0][0].getRed());
        assertEquals(0, pixie.getPixels()[0][0].getGreen());
        assertEquals(0, pixie.getPixels()[0][0].getBlue());
    }

    /**
     * This tests invert() by calling the method and using red2x2.png
     * as the TransformablePicture(). After calling invert(), the
     * red value should be 0 while green and blue are 255.
     */
    public void testInvert()
    {
        TransformablePicture pixie = new TransformablePicture(
                "red2x2.png");
        

        pixie.invert();
        
        assertEquals(0, pixie.getPixels()[0][0].getRed());
        assertEquals(255, pixie.getPixels()[0][0].getGreen());
        assertEquals(255, pixie.getPixels()[0][0].getBlue());
    }

    /**
     * This tests the method multicolored() by using a gray5x5.png 
     * TransformablePicture() as the initial picture. After the 
     * multicolored() method is called, pixie[0][0] should be at
     * the maximum red (255), pixie[2][2] should be max green, and 
     * pixie[4][4] should be max blue.
     */
    public void testMulticolored()
    {
        TransformablePicture pixie = new TransformablePicture(
                "gray5x5.png");

        pixie.multicolored();

        assertEquals(255, pixie.getPixels()[0][0].getRed());
        assertEquals(255, pixie.getPixels()[2][2].getGreen());
        assertEquals(255, pixie.getPixels()[4][4].getBlue());
    }

    /**
     * This tests brighten() by calling the method on a 
     * TransforablePicture pixie (gray2x2.png). When doing this,
     * the values of red, green, and blue should have increased 
     * by 20% (starts at 127 and becomes 152 after calling brighten())
     */
    public void testBrighten()
    {
        TransformablePicture pixie = new TransformablePicture(
                "gray2x2.png");

        pixie.brighten();

        assertEquals(152, pixie.getPixels()[0][0].getRed());
        assertEquals(152, pixie.getPixels()[0][0].getGreen());
        assertEquals(152, pixie.getPixels()[0][0].getBlue());
    }

    /**
     * This tests dim() by calling the method on a 
     * TransforablePicture pixie (gray2x2.png). When doing this,
     * the values of red, green, and blue should have decreased 
     * by 20% (starts at 127 and becomes 102 after calling dim())
     */
    public void testDim()
    {
        TransformablePicture pixie = new TransformablePicture(
                "gray2x2.png");

        pixie.dim();

        assertEquals(102, pixie.getPixels()[0][0].getRed());
        assertEquals(102, pixie.getPixels()[0][0].getGreen());
        assertEquals(102, pixie.getPixels()[0][0].getBlue());
    }

    /**
     * This tests flipHorizontal() by calling the method on 
     * TransformablePicture pix (gray2x2) and setting pixie[1][0] to 
     * green. After flipHorizontal is called, this should make it so
     * that pix[0][0] is 127 for red and blue, and 255 for green.
     */
    public void testFlipHorizontal()
    {
        TransformablePicture pixie = new TransformablePicture(
                "gray2x2.png");
        
        pixie.getPixels()[1][0].setGreen(255);
        TransformablePicture pix = pixie.flipHorizontal();

        assertEquals(127, pix.getPixels()[0][0].getRed());
        assertEquals(255, pix.getPixels()[0][0].getGreen());
        assertEquals(127, pix.getPixels()[0][0].getBlue());
    }

    /**
     * This tests flipVertical() by calling the method on
     * TransformablePicture pix (gray2x2) and setting pixie[0][1] to 
     * green. After flipHorizontal is called, this should make it so
     * that pix[0][0] is 127 for red and blue, and 255 for green.
     */
    public void testFlipVertical()
    {
        TransformablePicture pixie = new TransformablePicture(
                "gray2x2.png");
        
        pixie.getPixels()[0][1].setGreen(255);
        TransformablePicture pix = pixie.flipVertical();

        assertEquals(127, pix.getPixels()[0][0].getRed());
        assertEquals(255, pix.getPixels()[0][0].getGreen());
        assertEquals(127, pix.getPixels()[0][0].getBlue());
    }

    /**
     * This tests the method alphaBlend() by usig a for loop to check
     * each pixel in the TransformablePicture(s), and asserting that
     * the colors in each pixel are blending together in the picture.
     */
    public void testAlphaBlend()
    {
        TransformablePicture pic = new TransformablePicture(
                "color5x5.png");
        TransformablePicture org = new TransformablePicture(
                pic);
        TransformablePicture blend = new TransformablePicture(
                "fade5x5.png");

        Pixel[][] pixel = org.getPixels();
        Pixel[][] i = blend.getPixels();

        pic.alphaBlend(blend);
        Pixel[][] pix = pic.getPixels();
        for (int x = 0; x < pic.getImageWidth(); x++)
        {
            for (int y = 0; y < pic.getImageHeight(); y++)
            {
                Pixel pixie = pixel[x][y];
                Pixel ipixie = i[x][y];
                double alpha = (double)ipixie.getAlpha();
                double blend1 = alpha / 255.0;

                assertEquals(pix[x][y].getRed(), (
                        ipixie.getRed() * blend1) + (
                        pixie.getRed() * (1 - blend1)), 0.9);

                assertEquals(pix[x][y].getBlue(), (
                        ipixie.getBlue() * blend1) + (
                        pixie.getBlue() * (1 - blend1)), 0.9);

                assertEquals(pix[x][y].getGreen(), (
                        ipixie.getGreen() * blend1) + (
                        pixie.getGreen() * (1 - blend1)), 0.9);
            }
        }
    }

    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
