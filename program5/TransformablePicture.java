import sofia.micro.*;
import sofia.graphics.Color;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Abigail Sun (asun14)
/**
 *  This TransformablePicture class .
 *
 *  @author Abigail Sun (asun14)
 *  @version (2020.04.26)
 */
public class TransformablePicture extends Picture
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new TransformablePicture object.
     * @param temple    This is the picture that will be adjusted.
     */
    public TransformablePicture(String temple)
    {
        super(temple);
    }

    /**
     * This constructor makes it so that TransforablePicture
     * takes the width and height as a parameter.
     * 
     * @param width    The width of an image
     * @param height   The height of an image
     */
    public TransformablePicture(int width, int height)
    {
        super(width, height);
    }

    /**
     * This constructor makes it so that TransformablePicture
     * takes a picture object as a parameter.
     * 
     * @param picture   This takes the picture object as a parameter
     */
    public TransformablePicture(Picture picture)
    {
        super(picture);
    }

    /**
     * Force every pixel's red component to the maximum value.
     */
    public void maxRed()
    {
        Pixel[][] pixel = this.getPixels();
        for (int x = 0; x < this.getImageWidth(); x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                pixel[x][y].setRed(255);
            }
        }
    }

    /**
     * Force every pixel's green component to the maximum value.
     */
    public void maxGreen()
    {
        Pixel[][] pixel = this.getPixels();
        for (int x = 0; x < this.getImageWidth(); x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                pixel[x][y].setGreen(255);
            }
        }
    }

    /**
     * Force every pixel's blue component to the maximum value.
     */
    public void maxBlue()
    {
        Pixel[][] pixel = this.getPixels();
        for (int x = 0; x < this.getImageWidth(); x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                pixel[x][y].setBlue(255);
            }
        }
    }

    /**
     * Convert each pixel to a grayscale value by averaging its red, 
     * green, and blue components together, and setting all three 
     * components to that average value.
     */
    public void grayscale()
    {

        Pixel [][] pixel = this.getPixels();
        for (int x = 0; x < this.getImageWidth(); x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                double avg = pixel[x][y].getAverage();
                pixel[x][y].setRed(avg);
                pixel[x][y].setBlue(avg);
                pixel[x][y].setGreen(avg);
            }
        }
    }

    /**
     * Invert the color of this picture by transforming each pixel to its
     * inverse color. You can invert a red value of r by setting it to 
     * 255 - r. Inverting a pixel requires inverting all three of its 
     * color components.
     */
    public void invert()
    {
        Pixel [][] pixel = this.getPixels();
        for (int x = 0; x < this.getImageWidth(); x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                int red = 255 - pixel[x][y].getRed();
                int blue = 255 - pixel[x][y].getBlue();
                int green = 255 - pixel[x][y].getGreen();
                Color color = Color.rgb(red, green, blue);
                pixel[x][y].setColor(color);
            }
        }
    }

    /**
     * This method is made to make all the x-values less than or equal
     * to 1/3 of the width red, 2/3 of the x-values green, and the rest
     * of the x-values blue.
     */
    public void multicolored()
    {
        Pixel [][] pixel = this.getPixels();
        for (int x = 0; x < this.getImageWidth() / 3; x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                pixel[x][y].setRed(255);
            }
        }
        for (int x = this.getImageWidth() / 3; 
            x < this.getImageWidth() * 2 / 3 ; x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                pixel[x][y].setGreen(255);
            }
        }
        for (int x = this.getImageWidth() * 2 / 3; 
            x < this.getImageWidth() ; x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                pixel[x][y].setBlue(255);
            }
        }
    }

    /**
     * Increase the brightness of this image by 20% by increasing the red,
     * green, and blue components of every pixel by this factor.
     */
    public void brighten()
    {
        Pixel [][] pixel = this.getPixels();
        for (int x = 0; x < this.getImageWidth(); x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                pixel[x][y].setRed(pixel[x][y].getRed() * 1.2);               
                pixel[x][y].setBlue(pixel[x][y].getBlue() * 1.2);
                pixel[x][y].setGreen(pixel[x][y].getGreen() * 1.2);
            }
        }
    }

    /**
     * Decrease the brightness of this image by 20% by decreasing the red,
     * green, and blue components of every pixel by this factor.
     */
    public void dim()
    {
        Pixel [][] pixel = this.getPixels();
        for (int x = 0; x < this.getImageWidth(); x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                pixel[x][y].setRed(pixel[x][y].getRed() * 0.8);
                pixel[x][y].setBlue(pixel[x][y].getBlue() * 0.8);
                pixel[x][y].setGreen(pixel[x][y].getGreen() * 0.8);
            }
        }
    }

    /**
     * This method returns a new TransformablePicture that represents the 
     * mirror image (horizontally) of this picture.
     * @return flipHorizontal This returns the width and height of a
     *                        transformable picture
     */
    public TransformablePicture flipHorizontal()
    {
        Pixel [][] pixel = this.getPixels();
        TransformablePicture tranny = new TransformablePicture(
                this.getImageWidth(), this.getImageHeight());
        Pixel[][] i = tranny.getPixels();
        for (int x = 0; x < this.getImageWidth(); x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                i[x][y].setColor(pixel[this.getImageWidth(
                        ) - 1 - x][y].getColor());
            }
        }
        return tranny;
    }

    /**
     * This method returns a new TransformablePicture that represents the 
     * mirror image (vertically) of this picture.
     * 
     * @return flipVertical This returns the width and height of a
     *                      transformable picture
     */
    public TransformablePicture flipVertical()
    {
        Pixel [][] pixel = this.getPixels();
        TransformablePicture tranny = new TransformablePicture(
                this.getImageWidth(), this.getImageHeight());
        Pixel[][] i = tranny.getPixels();
        for (int x = 0; x < this.getImageWidth(); x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                i[x][y].setColor(pixel[x][this.getImageHeight(
                        ) - 1 - y].getColor());
            }
        }
        return tranny;
    }

    /**
     * This method is made to "average" two pixels to get a new color
     * by using the fourth channel of each pixel's color, it's
     * alpha value by using transparent pixels/information.
     * 
     * @param picture This takes another picture object as a parameter
     */
    public void alphaBlend(Picture picture)
    {
        Pixel[][] pixel = this.getPixels();
        Pixel[][] i = picture.getPixels();
        for (int x = 0; x < this.getImageWidth(); x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                Pixel pixie = pixel[x][y];
                Pixel ipixie = i[x][y];
                int alpha = ipixie.getAlpha();
                double blend = alpha / 255.0;

                pixie.setRed((ipixie.getRed() * blend) + (
                        pixie.getRed() * (1 - blend)));

                pixie.setBlue((ipixie.getBlue() * blend) + (
                        pixie.getBlue() * (1 - blend)));

                pixie.setGreen((ipixie.getGreen() * blend) + (
                        pixie.getGreen() * (1 - blend)));
            }
        }
    }
}
