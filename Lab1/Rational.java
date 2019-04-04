/**
 * A class that represents a rational number.
 *
 * @author Charles Hoot
 * @version 4.0
*/

public class Rational
{
    // PUT PRIVATE DATA FIELDS HERE
    private int num;
    private int denom;


    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    public Rational()
    {
        num = 1;
        denom = 1;
    }

    /**
     * The alternate constructor for objects of class Rational.  Creates a rational number equivalent to n/d.
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */
    public Rational(int n, int d)
    {
        if(d == 0){
            throw new ZeroDenominatorException("Denominator is zero");
        }
        else{
        num = n;
        denom = d;
        }
        normalize();
    }

    /**
     * Get the value of the Numerator
     *
     * @return     the value of the numerator
     */
    public int getNumerator()
    {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return num;
    }

    /**
     * Get the value of the Denominator
     *
     * @return     the value of the denominator
     */
    public int getDenominator()
    {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return denom;
    }


    /**
     * Negate a rational number r
     *
     * @return a new rational number that is negation of this number -r
     */
    public Rational negate()
    {
        Rational r = new Rational(0-num,denom);
        r.normalize();
        return r;
    }


    /**
     * Invert a rational number r
     *
     * @return a new rational number that is 1/r.
     */
    public Rational invert()
    {
        Rational r = new Rational(denom,num);
        return r;
    }





    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */
    public Rational add(Rational other)
    {
        return new Rational(num*other.getDenominator()+other.getNumerator()*denom,denom*other.getDenominator());
    }

     /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */
    public Rational subtract(Rational other)
    {
        return new Rational(num*other.getDenominator()-other.getNumerator()*denom,denom*other.getDenominator());
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other rational.
     */
    public Rational multiply(Rational other)
    {
        Rational r = new Rational(num*other.getNumerator(),denom*other.getDenominator());
        r.normalize();
        return r;
    }


     /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */
    public Rational divide(Rational other)
    {
        Rational r = new Rational(num*other.getDenominator(),denom*other.getNumerator());
        r.normalize();
        return r;
    }



 /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * is negative.
     *
     */
    private void normalize()
    {

        if(num%gcd(num,denom)==0 && denom%gcd(num,denom)==0){
            int gcd = gcd(num,denom);
            num = num/gcd;
            denom = denom/gcd;
        }
        if(denom<0){
            denom = 0-denom;
            num = 0-num;
        }
    }

    /**
     * Recursively compute the greatest common divisor of two positive integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b)
    {
        a= Math.abs(a);
        b=Math.abs(b);
        int result = 0;
        if(a<b)
            result = gcd(b,a);
        else if(b==0)
            result = a;
        else
        {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }




}
