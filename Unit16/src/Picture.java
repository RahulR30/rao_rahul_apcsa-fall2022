import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.text.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 *
 * @author
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   *
   */

  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
            " height " + getHeight()
            + " width " + getWidth();
    return output;

  }

  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  public void keepOnlyBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] r : pixels) {
      for(Pixel c : r) {
        c.setGreen(0);
        c.setRed(0);
      }
    }
  }
  public void clearBlueOverValue(int val)
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        if (pixelObj.getBlue() > val) {
          pixelObj.setBlue(0);
        }
      }
    }
  }
  public void keepOnlyRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
        pixelObj.setBlue(0);
      }
    }
  }
  public void setRedToHalfValueInTopHalf()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (int r = 0; r<pixels.length/2; r++)
    {
      for (int c = 0; c<pixels[0].length; c++)
      {
        Pixel pixelObj = pixels[r][c];
        pixelObj.setRed(pixelObj.getRed()/2);
      }
    }
  }
  public int getAverageForColumn( int col )
  {
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      Pixel pixelObj = rowArray[col];
      count += (pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen())/3;
    }
    count = count/(pixels.length);
    return count;
  }
  public int getCountRedOverValue(int val)
  {
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        if (pixelObj.getRed() > val) {
          count++;
        }

      }
    }
    return count;
  }

  public void keepOnlyGreen()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
        pixelObj.setRed(0);
      }
    }
  }
  public void negate() {
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] r : pixels) {
      for(Pixel c : r) {
        c.setBlue(255-c.getBlue());
        c.setRed(255-c.getRed());
        c.setGreen(255-c.getGreen());
      }
    }
  }

  public void grayScale() {
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] r : pixels) {
      for(Pixel c : r) {
        int average = (c.getBlue() + c.getRed() + c.getGreen())/3;
        c.setBlue(average);
        c.setRed(average);
        c.setGreen(average);
      }
    }
  }

  public void fixUnderwater() {
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] r : pixels) {
      for(Pixel c : r) {
        c.setRed(c.getBlue());
      }
    }
  }

  public void mirrorVerticalRightToLeft() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel left = null;
    Pixel right = null;
    int width = pixels[0].length;
    for (int r = 0; r < pixels.length; r++)
    {
      for (int c = width/2; c < width; c++)
      {
        right = pixels[r][c];
        left = pixels[r][width - 1 - c];
        left.setColor(right.getColor());
      }
    }
  }

  public void mirrorHorizontal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel top = null;
    Pixel bottom = null;
    int width = pixels[0].length;
    for (int r = 0; r < pixels.length/2; r++) {
      for (int c = 0; c < width; c++) {
        top = pixels[r][c];
        bottom = pixels[pixels.length-1-r][c];
        bottom.setColor(top.getColor());
      }
    }
  }

  public void mirrorHorizontalBotToTop() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel top = null;
    Pixel bottom = null;
    int width = pixels[0].length;
    for (int r = pixels.length/2; r < pixels.length; r++) {
      for (int c = 0; c < width; c++) {
        bottom = pixels[r][c];
        top = pixels[pixels.length-1-r][c];
        top.setColor(bottom.getColor());
      }
    }
  }

  public void mirrorDiagonal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topRightPixel = null;
    Pixel bottomLeftPixel = null;
    int maxLength;
    if (pixels.length < pixels[0].length) { maxLength = pixels.length; }
    else {maxLength = pixels[0].length; }

    for (int r = 0; r < maxLength; r++)
    {
      for (int c = r; c < maxLength; c++)
      {
        topRightPixel = pixels[r][c];
        bottomLeftPixel = pixels[c][r];
        bottomLeftPixel.setColor(topRightPixel.getColor());
      }
    }
  }
  /** Method that mirrors the picture around a
   * vertical mirror in the center of the picture
   * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {

        leftPixel = pixels[row][col];
        rightPixel = pixels[row]
                [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }

  public void mirrorArms()
  {
    int mirrorPoint = 206;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int r = 168; r < 201; r++)
    {
      // loop from 13 to just before the mirror point
      for (int c = 102; c < 300; c++)
      {

        leftPixel = pixels[r][c];
        rightPixel = pixels[mirrorPoint - r + mirrorPoint][c];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }

  public void mirrorGull()
  {
    int mirrorPoint = 356;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int r = 232; r < 329; r++)
    {
      // loop from 13 to just before the mirror point
      for (int c = 232; c < mirrorPoint; c++)
      {

        leftPixel = pixels[r][c];
        rightPixel = pixels[r]
                [mirrorPoint - c + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }

  /** copy from the passed fromPic to the
   * specified startRow and startCol in the
   * current picture
   * @param fromPic the picture to copy from
   * @param startRow the start row to copy to
   * @param startCol the start col to copy to
   */
  public void copy(Picture fromPic,
                   int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow;
         fromRow < fromPixels.length &&
                 toRow < toPixels.length;
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol;
           fromCol < fromPixels[0].length &&
                   toCol < toPixels[0].length;
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  public void copy2(Picture fromPic, int startRow, int endRow, int startCol, int endCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow;
         fromRow < fromPixels.length &&
                 toRow < endRow;
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol;
           fromCol < fromPixels[0].length &&
                   toCol < endCol;
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  public void myCollage()
  {
    Picture p1 = new Picture("/Users/rahulrao/Downloads/Programming/Projects/rao_rahul_apcsa-fall2022/Unit16/src/Images/kitten2.jpg");
    Picture p2 = new Picture("/Users/rahulrao/Downloads/Programming/Projects/rao_rahul_apcsa-fall2022/Unit16/src/Images/arch.jpg");
    Picture p3 = new Picture("/Users/rahulrao/Downloads/Programming/Projects/rao_rahul_apcsa-fall2022/Unit16/src/Images/swan.jpg");
    this.copy(p1,0,0);
    this.copy(p2,100,0);
    this.copy(p3,100,200);

    Picture test = new Picture(p1);
    test.keepOnlyBlue();
    this.copy(test,0,5);

    Picture test1 = new Picture(p2);
    test1.negate();
    this.copy(test1,100,0);

    Picture test2 = new Picture(p3);
    test2.mirrorVertical();
    this.copy(test2,100,200);
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("/Users/rahulrao/Downloads/Programming/Projects/rao_rahul_apcsa-fall2022/Unit16/src/Images/flower1.jpg");
    Picture flower2 = new Picture("/Users/rahulrao/Downloads/Programming/Projects/rao_rahul_apcsa-fall2022/Unit16/src/Images/flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("/Users/rahulrao/Downloads/Programming/Projects/rao_rahul_apcsa-fall2022/Unit16/src/Images/collage.jpg");
  }


  /** Method to show large changes in color
   * @param edgeDist the distance for finding edges
   */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0;
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) >
                edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

  public void edgeDetection2(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel bottomPixel = null;

    Pixel[][] pixels = this.getPixels2D();
    for (int row = 0; row < pixels.length - 1; row++)
    {
      for (int col = 0;
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        topPixel = pixels[row][col];
        bottomPixel = pixels[row + 1][col];
        if (leftPixel.colorDistance(rightPixel.getColor()) > edgeDist || topPixel.colorDistance(bottomPixel.getColor()) > edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

  /** Hide a black and white message in the current
   * picture by changing the red to even and then
   * setting it to odd if the message pixel is black
   * @param messagePict the picture with a message
   */
  public static double getIntensity(Color color)
  {
    int r = color.getRed();
    int g = color.getGreen();
    int b = color.getBlue();
    return 0.299*r + 0.587*g + 0.114*b;
  }
  public void perfectSquareEncode(Picture messagePict){
    Pixel[][] currPixels = this.getPixels2D();
    Pixel[][] messagePixels = messagePict.getPixels2D();
    Pixel currPixel = null;
    Pixel messagePixel = null;
    for(int row = 0; row < this.getHeight(); row++){
      for(int col = 0; col < this.getWidth(); col++){
        currPixel = currPixels[row][col];
        currPixel.setRed((int) Math.pow(Math.round(Math.sqrt(currPixel.getRed())), 2));
        currPixel.setBlue((int) Math.pow(Math.round(Math.sqrt(currPixel.getBlue())), 2));
        currPixel.setGreen((int) Math.pow(Math.round(Math.sqrt((currPixel.getGreen()))), 2));
        messagePixel = messagePixels[row][col];
        if(messagePixel.colorDistance(Color.BLACK) < 50){
          currPixel.setRed((int) (currPixel.getRed() + Math.ceil(Math.sqrt(Math.sqrt(Math.sqrt(currPixel.getBlue())))) + Math.ceil(Math.sqrt(Math.sqrt(Math.sqrt(currPixel.getGreen()))))));
          currPixel.setBlue(currPixel.getBlue() + 1);
          currPixel.setGreen(currPixel.getGreen() + 1);
        }
      }
    }

  }
  public Picture perfectSquareDecode() {
    Pixel[][] currPixels = this.getPixels2D();
    Pixel currPixel = null;
    Pixel messagePixel = null;
    int height = this.getHeight();
    int width = this.getWidth();
    Picture messagePicture = new Picture(height,width);
    Pixel[][] messagePixels = messagePicture.getPixels2D();
    for(int row = 0; row < this.getHeight(); row++){
      for(int col = 0; col < this.getWidth(); col++){
        currPixel = currPixels[row][col];
        messagePixel = messagePixels[row][col];
        if(Math.sqrt(currPixel.getBlue()-1) == Math.round(Math.sqrt(currPixel.getBlue() -1))
                && Math.sqrt(currPixel.getGreen()-1) == Math.round(Math.sqrt(currPixel.getGreen() -1))
                && Math.sqrt(currPixel.getRed() - Math.ceil(Math.sqrt(Math.sqrt(Math.sqrt(currPixel.getBlue())))) - Math.ceil(Math.sqrt(Math.sqrt(Math.sqrt(currPixel.getGreen())))))
                == Math.round(Math.sqrt(currPixel.getRed() -Math.ceil(Math.sqrt(Math.sqrt(Math.sqrt(currPixel.getBlue())))) - Math.ceil(Math.sqrt(Math.sqrt(Math.sqrt(currPixel.getGreen())))))))
        {
          messagePixel.setColor(Color.BLACK);
        }
      }
    }
    return messagePicture;

  }
  public void encode(Picture messagePict)
  {
    Pixel[][] messagePixels = messagePict.getPixels2D();
    Pixel[][] currPixels = this.getPixels2D();
    Pixel currPixel = null;
    Pixel messagePixel = null;
    int count = 0;
    for (int row = 0; row < this.getHeight(); row++) {
      for (int col = 0; col < this.getWidth(); col++) {
        // if the current pixel red is odd make it even
        currPixel = currPixels[row][col];
        if (currPixel.getRed() % 2 == 1)
          currPixel.setRed(currPixel.getRed() - 1);
        messagePixel = messagePixels[row][col];
        if (messagePixel.colorDistance(Color.BLACK) < 50)
        {

          currPixel.setRed(currPixel.getRed() + 1);

          count++;
        }
      }
    }
    System.out.println(count);
  }
  /**
   * Method to decode a message hidden in the
   * red value of the current picture
   * @return the picture with the hidden message
   */
  public Picture decode()
  {
    Pixel[][] pixels = this.getPixels2D();
    int height = this.getHeight();
    int width = this.getWidth();
    Pixel currPixel = null;

    Pixel messagePixel = null;
    Picture messagePicture = new Picture(height,width);
    Pixel[][] messagePixels = messagePicture.getPixels2D();
    int count = 0;
    for (int row = 0; row < this.getHeight(); row++)
    {
      for (int col = 0; col < this.getWidth(); col++)
      {
        currPixel = pixels[row][col];
        messagePixel = messagePixels[row][col];
        if (currPixel.getRed() % 2 == 1)
        {
          messagePixel.setColor(Color.BLACK);
          count++;
        }
      }
    }

    System.out.println(count);
    return messagePicture;
  }
  public void chromakey()
  {
    Picture moonSurface = new Picture("src/images/moon-surface.jpg");
    Pixel[][] pixelsMark = this.getPixels2D();
    Pixel[][] pixelsMoon = moonSurface.getPixels2D();

    for (int r = 0; r< pixelsMark.length; r++)
    {
      for (int c = 0; c<pixelsMark[0].length; c++)
      {
        Pixel pixelObj = pixelsMark[r][c];
        if (pixelObj.getBlue() < 85 && (pixelObj.getRed() < 20 || pixelObj.getGreen() <15)) {
          pixelObj.setColor(pixelsMoon[r][c].getColor());
        }
      }
    }
  }
  /* Main method for testing - each class in Java can have a main
   * method
   */
  public static void main(String[] args)
  {
    Picture beach = new Picture("/Users/rahulrao/Downloads/Programming/Projects/rao_rahul_apcsa-fall2022/Unit16/src/Images/beach.jpg");
    //beach.explore();
    //beach.zeroBlue();
    //beach.explore();
    /*beach.keepOnlyBlue();
    beach.explore();
    beach.negate();
    beach.explore();
    beach.grayScale();
    beach.explore();
    beach.fixUnderwater();
    beach.explore();*/
  }

} // this } is the end of class Picture, put all new methods before this
