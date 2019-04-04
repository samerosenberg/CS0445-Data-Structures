
/**
 * A class that has a methond to recursively replaces characters in a String.
 *
 * @author Charles Hoot
 * @version 4.0
 */
public class RecursiveStringReplace
{

    /**
     * replace - Replace all instances of one character by another.
     *
     * @param  s   The string to do the replacement on.
     * @param  from   The character to be replaced.
     * @param  to   the character to change to.
     * @return     A new string with the appropriate characters replaced.
     */
    public String replace(String s, char from, char to)
    {
        String result = "";
        char last = '\u0000';
        if(s.length()==0){
            return result = "";
        }else if(s.length()>=1){
            last = s.charAt(0);
            if(last==from)
                result += to;
            else
                result +=last;
        }
        // IMPLEMENT THIS RECURSIVE METHOD
        return result + replace(s.substring(1),from,to);
    }


}
