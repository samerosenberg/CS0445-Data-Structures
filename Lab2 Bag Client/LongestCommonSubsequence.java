
import java.io.*;
import java.util.*;

/**
 * LongestCommonSubsequence is a program that will determine the longest string that is
 * a subsequence of two input strings. This program applies a brute force solution technique.
 *
 * @author Charles Hoot
 * @version 4.0
 */
public class LongestCommonSubsequence {

    public static void main(String args[]) {
        BagInterface<String> toCheckContainer = new ArrayBag<String>();

        Scanner input;
        input = new Scanner(System.in);

        System.out.println("This program determines the longest string that is a subsequence of two input string.");
        System.out.println("Please enter the first string:");
        String first = input.next();
        toCheckContainer.add(first);

        System.out.println("Please enter the second string:");
        String second = input.next();



        // ADD CODE HERE TO CREATE THE BAG WITH THE INITIAL STRING

        System.out.println("The strings to check are: " + toCheckContainer);
        String bestSubsequence = new String("");



        while(!toCheckContainer.isEmpty()){
            String test = toCheckContainer.remove();
            if(bestSubsequence.length()<test.length())
                if(isSubsequence(test,second)){
                    bestSubsequence=test;
                }
                else if(test.length()>=bestSubsequence.length()+2){
                    for(int i=1;i<test.length()-1;i++){
                        String newString = test.substring(0,i);
                        newString+=test.substring(i+1);
                        toCheckContainer.add(newString);
                    }
                }
                System.out.println(toCheckContainer);
        }


        // ADD CODE HERE TO CHECK THE STRINGS IN THE BAG
        System.out.println("Found " + bestSubsequence + " for the longest common subsequence");

    }

    /**
     * Determine if one string is a subsequence of the other.
     *
     * @param check See if this is a subsequence of the other argument.
     * @param other The string to check against.
     * @return     A boolean if check is a subsequence of other.
     */
    public static boolean isSubsequence(String check, String against) {
        boolean result = false;
        if(check.length()==0)
            result = true;
        else if(check.length()<against.length()){
            for(int i=0; i<against.length();i++){
                if(check.substring(0,1).equals(against.substring(i,i+1))){
                    against = against.substring(i);
                    if(check.length()==1)
                        result=true;
                    else{
                        check = check.substring(1);
                        i=0;
                    }
                }
            }
        }

        /*
        if(check.length()<=against.length()){
            int i=0;
            for(int j=0; i<check.length()&&j<against.length();j++){
                if(check.charAt(i)==against.charAt(j)){
                    i++;
            }
        }
        result=(i==check.length());
    }


        */
        // ADD CODE HERE TO CHECK IF WE HAVE A SUBSEQUENCE
        return result;
    }
}
