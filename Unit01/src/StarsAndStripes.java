//© A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class StarsAndStripes
{
   public StarsAndStripes()
   {
      out.println("StarsAndStripes");
      printTwoBlankLines();
      printASmallBox();
      out.println("");
      out.println("");
      printABigBox();
   }

   public void printTwentyStars()
   {
      out.println("*******************");
   }

   public void printTwentyDashes()
   {
      out.println("-------------------");
   }

   public void printTwoBlankLines()
   {
      out.println("                   ");
      out.println("                   ");
   }
   
   public void printASmallBox()
   {
      for(int i = 0; i < 3; i++){
         printTwentyDashes();
         printTwentyStars();
      }
      printTwentyDashes();
   }
 
   public void printABigBox()
   {
      for(int i = 0; i < 2; i++) {
         printASmallBox();
      }
   }   
}