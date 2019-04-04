import java.util.*;
import java.io.*;

public class Assign3{
  private static int finishx,finishy, startx,starty;
  public static void main(String[] args) throws Exception {
    Scanner inScan = new Scanner(System.in);
Scanner fReader;
File fName;
    String fString = "";

    // Make sure the file name is valid
    while (true)
    {
       try
       {
           System.out.println("Please enter grid filename:");
           fString = inScan.nextLine();
           fName = new File(fString);
           fReader = new Scanner(fName);

           break;
       }
       catch (IOException e)
       {
           System.out.println("Problem " + e);
       }
    }

// Parse input file to create 2-d grid of characters
String [] dims = (fReader.nextLine()).split(" ");
int rows = Integer.parseInt(dims[0]);
int cols = Integer.parseInt(dims[1]);

char [][] theBoard = new char[rows][cols];

for (int i = 0; i < rows; i++)
{
  String rowString = fReader.nextLine();
  for (int j = 0; j < rowString.length(); j++)
  {
    theBoard[i][j] = Character.toLowerCase(rowString.charAt(j));
  }
}

// Show user the grid
for (int i = 0; i < rows; i++)
{
  for (int j = 0; j < cols; j++)
  {
    System.out.print(theBoard[i][j] + " ");
  }
  System.out.println();
}

System.out.println("Please enter phrase");
    String[] word = inScan.nextLine().split(" ");

    int num=0;
  while(word.length>0){


      int x = 0, y = 0;

      // Search for the word.  Note the nested for loops here.  This allows us to
      // start the search at any of the locations in the board.  The search itself
      // is recursive (see findWord method for details).  Note also the boolean
      // which allows us to exit the loop before all of the positions have been
      // tried -- as soon as one solution has been found we can stop looking.
      boolean found = false;
      for (int r = 0; (r < rows && !found); r++)
      {
        for (int c = 0; (c < cols && !found); c++)
        {

        // Start search for each position at index 0 of the word

          found = findPhrase(r, c, word, theBoard, 0);
          if (found)
          {
            startx = r;  // store starting indices of solution
            starty = c;
            System.out.print("The phrase: ");
            print(word);
            System.out.println();
            /*System.out.println("was found: ");
            System.out.println(word[num]+" ("+startx+","+starty+") to ("+finishx+","+finishy+")");*/
          }
        }
      }

      if (found)
      {
        /*for(int i=1;i<word.length;i++){
          if (findWord(finishx,finishy+1,word[i],0,theBoard,0))
          {
            x = finishx;
            y = finishy+1;
            System.out.println(word[i]+" ("+x+","+y+") to ("+finishx+","+finishy+")");
          }
          else if (findWord(finishx+1,finishy,word[i],0,theBoard,1))
          {
            x =finishx+1;
            y = finishy;
            System.out.println(word[i]+" ("+x+","+y+") to ("+finishx+","+finishy+")");
          }
          else if (findWord(finishx,finishy-1,word[i],0,theBoard,2))
          {
            x = finishx;
            y = finishy-1;
            System.out.println(word[i]+" ("+x+","+y+") to ("+finishx+","+finishy+")");
          }
          else if (findWord(finishx-1,finishy,word[i],0,theBoard,3))
          {
            x = finishx-1;
            y =finishy;
            System.out.println(word[i]+" ("+x+","+y+") to ("+finishx+","+finishy+")");
          }
          else{

          }
        }*/

        for (int i = 0; i < rows; i++)
        {
          for (int j = 0; j < cols; j++)
          {
            System.out.print(theBoard[i][j] + " ");
            theBoard[i][j] = Character.toLowerCase(theBoard[i][j]);
          }
          System.out.println();
        }
      }
      else
      {
        System.out.println("The phrase: ");
        print(word);
        System.out.println("was not found");
      }
      finishx=0;
      finishy=0;

      System.out.println("Please enter the phrase to search for:");
          word = inScan.nextLine().split(" ");
    }
  }


  public static boolean findWord(int r, int c, String word, int loc, char [][] bo, int direction)
	{
		//System.out.println("findWord: " + r + ":" + c + " " + word + ": " + loc); // trace code

		// Check boundary conditions
		if (r >= bo.length || r < 0 || c >= bo[0].length || c < 0)
			return false;
		else if (bo[r][c] != word.charAt(loc))  // char does not match
			return false;
		else   	// current character matches
		{
			bo[r][c] = Character.toUpperCase(bo[r][c]);  // Change it to
				// upper case.  This serves two purposes:
				// 1) It will no longer match a lower case char, so it will
				//    prevent the same letter from being used twice
				// 2) It will show the word on the board when displayed

			boolean answer = false;
			if (loc == word.length()-1){	// base case - word found and we
				answer = true;
        finishx = r;
        finishy = c;
      }// are done!

			else	// Still have more letters to match, so recurse.
			{		// Try all four directions if necessary (but only if necessary)
        if(!answer && direction ==0){
            answer = findWord(r, c+1, word, loc+1, bo, direction);
            direction++;
          }  // Right
				if (!answer && direction ==1){
					answer = findWord(r+1, c, word, loc+1, bo,direction);
          direction++;
        }  // Down
				if (!answer&& direction ==2){
					answer = findWord(r, c-1, word, loc+1, bo,direction);
          direction++;
        }  // Left
				if (!answer && direction==3){
					answer = findWord(r-1, c, word, loc+1, bo,direction);
        } // Up

				// If answer was not found, backtrack.  Note that in order to
				// backtrack for this algorithm, we need to move back in the
				// board (r and c) and in the word index (loc) -- these are both
				// handled via the activation records, since after the current AR
				// is popped, we revert to the previous values of these variables.
				// However, we also need to explicitly change the character back
				// to lower case before backtracking.
				if (!answer)
					bo[r][c] = Character.toLowerCase(bo[r][c]);
			}
			return answer;
		}
	}
  public static boolean findPhrase(int r, int c, String [] word, char[][] bo,int num){
    boolean phraseFound=false;
    if (r >= bo.length || r < 0 || c >= bo[0].length || c < 0)
      return false;
    if(num==word.length){
    //  System.out.println("here1");
      phraseFound = true;
      return phraseFound;
    }
    if(num==0){
      if(word[num].equals(""))
        return false;
      if(findWord(r,c,word[num],0,bo,0)){
        //  System.out.println("here");
          if(findPhrase(r,c,word,bo,num+1)){
            finishx =r;
            finishy=c;
            phraseFound=true;
            startx = r;
            starty = c;
            System.out.println(word[num]+" ("+startx+","+starty+") to ("+finishx+","+finishy+")");
            return true;
          }
          return false;
      }
    }else{
    //  System.out.println("here2");
      if (findWord(finishx,finishy+1,word[num],0,bo,0))
      {
        phraseFound=true;
        startx = r;
        starty = c;
        System.out.println(word[num]+" ("+startx+","+starty+") to ("+finishx+","+finishy+")");
        findPhrase(r,c,word,bo,num+1);
      }
      if (findWord(finishx+1,finishy,word[num],0,bo,1))
      {
        phraseFound=true;
        startx = r;
        starty = r;
        System.out.println(word[num]+" ("+startx+","+starty+") to ("+finishx+","+finishy+")");

        findPhrase(r,c,word,bo,num+1);
      }
      if (findWord(finishx,finishy-1,word[num],0,bo,2))
      {
        phraseFound=true;
        startx = r;
        starty = c;
        System.out.println(word[num]+" ("+startx+","+starty+") to ("+finishx+","+finishy+")");

        findPhrase(r,c,word,bo,num+1);
      }
      if (findWord(finishx-1,finishy,word[num],0,bo,3))
      {
        System.out.println("here");
        phraseFound=true;
        startx = r;
        starty =c;
        System.out.println(word[num]+" ("+startx+","+starty+") to ("+finishx+","+finishy+")");

        findPhrase(r,c,word,bo,num+1);
      }
    //  System.out.println("here3");
      else{
        phraseFound =false;
        findPhrase(startx,starty, word, bo ,num-1);
      }
    }
    return phraseFound;
  }



  public static void print(String[] arr){
    for(String str:arr){
      System.out.print(str+" ");
    }
  }
}
