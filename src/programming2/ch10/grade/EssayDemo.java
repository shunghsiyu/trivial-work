package programming2.ch10.grade;

/**
   This program demonstrates a solution to 
   the Essay Class programming challenge.
*/

public class EssayDemo
{
   public static void main(String[] args)
   {
      // Create an Essay object.
      Essay termPaper = new Essay();
      
      // Assign scores to the object.
      // Grammer = 25 points, Spelling = 18 points,
      // Length = 20 points, and Content = 25 points.
      termPaper.setScore(25.0, 18.0, 20.0, 25.0);
      
      // Display the score details.
      System.out.println("Term paper:");
      System.out.println("Grammar points: " + termPaper.getGrammar());
      System.out.println("Spelling points: " + termPaper.getSpelling());
      System.out.println("Length points: " + termPaper.getCorrectLength());
      System.out.println("Content points: " + termPaper.getContent());
      System.out.println("Total points: " + termPaper.getScore());
      System.out.println("Grade: " + termPaper.getGrade());
   }
}
