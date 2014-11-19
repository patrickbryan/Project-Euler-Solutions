package euler;

import java.math.BigInteger;

/**
 *
 * @author Patrick
 */
public class EulerFunction {
    
    /**
     * Finds the lowest form of the denominator of a fraction
     * @param numer the numerator for the fraction
     * @param denom the denominator for the fraction
     * @return the denominator for the lowest form of the fraction given
     */
    public static int lowestFormDenom(int numer, int denom) {

        for (int i = numer; i > 1; i--) {
            if (numer % i == 0 && denom % i == 0) {
                denom /= i;
                break;
            }
        }
        return denom;
    }
    
    /**
     * Calculates the period of repeating digits after the decimal of
     * the number 1/n
     * @param denom denominator of number
     * @param numerator numerator of number
     * @return the periodicity of numerator/denom
     */
    public static int decimalPeriod(int denom, int numerator) {
        boolean[] remaindersHit = new boolean[denom];
        int[] remaindersPos = new int[denom];
        
        for (int i = 0; i < denom; i ++) {
            numerator = numerator%denom;
            if (numerator == 0) {
                break;
            } else if (remaindersHit[numerator] == true) {
                return i - remaindersPos[numerator];
            }
            remaindersHit[numerator] = true;
            remaindersPos[numerator] = i;
            numerator *= 10;
        }
        
        return 0;
    }
    
    /**
     * Calculates and finds the first fibonacci number that has n digits.
     * The user defines where in the fibonacci they wish to start and with what
     * starting conditions
     * @param f1 the "first" term to be used in the fibonacci sequence
     * @param f2 the "second" term to be used in the fibonacci sequence
     * @param term what term f2 is of the fibonacci sequence
     * @param n how many digits they want to find
     * @return the place of first term that has n digits
     */
    public static int fibRecNthDigit (BigInteger f1, BigInteger f2, int term, int n) {
        BigInteger temp = f1;
        f1 = f2;
        f2 = f2.add(temp);
        term++;
        
        if (f2.toString().length() < 1000) {
            return fibRecNthDigit(f1,f2,term, n);
        }
        
        return term;
    }
    
    /**
     * Checks to see if a string is the same backwards as it is forwards
     * @param s the string to be checked
     * @return true if s is a palindrome
     */
    public static boolean isPalindrome(String s) {
        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf = strReverse(s.substring((int) Math.ceil(s.length() / 2.0)));
        return firstHalf.equals(secondHalf);
    }
    
    /**
     * Reverses a string character by character
     * @param s the string to be reveresed
     * @return the reverse string of s
     */
    public static String strReverse(String s) {
        String sReverse = "";
        for (int i = 1; i <= s.length(); i++) {
            sReverse += s.charAt(s.length() - i);
        }
        return sReverse;
    }
    
    /**
     * Checks if number n is a perfect square or not
     * @param n number to be checked
     * @return true if n is a perfect square
     */
    public static boolean isPerfectSquare(long n) {
        return Math.pow(((long)Math.sqrt(n)), 2) == n;
    }
    
    /**
     * Counts the amount of digits in i. Max length of 16
     * @param i integer whose digits will be counted
     * @return the amount of digits there are in i
     */
    public static int numberOfDigits(int i) {
        int n = 1;
        if (i >= 100000000){i /= 100000000; n += 8;}
        if (i >= 10000){i /= 10000; n += 4;}
        if (i >= 100){i /= 100; n += 2;}
        if (i >= 10){i /= 10; n += 1;}
        
        return n;
    }
    
    /**
     * Checks if a number is n-pandigital. n is how many digits s contains
     * @param s number to be checked
     * @return if number s is n-pandigital where n is s.length()
     */
    public static boolean isNPandigital(String s) {
        if (s.length() > 9)
            return false;
        
        boolean found[] = new boolean[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            int num = Character.getNumericValue(s.charAt(i));
            if (num > s.length() || num <= 0 || found[num-1])
                return false;
            found[num-1] = true;
        }
        
        return true;
    }
    
    /**
     * Checks if a number is n-pandigital. n is how many digits s contains
     * and is defined by the user
     * @param s number to be checked
     * @param n n-pandigital value
     * @return if number s is n-pandigital
     */
    public static boolean isNPandigital(String s, int n) {
        if (s.length() == n)
            return isNPandigital(s);
        return false;
    }
    
    /**
     * Sums all the factors of integer n
     * @param n the integer whose factors will be summed
     * @return the sum of n's factors
     */
    public static int sumFactors(int n) {
        int sum = 1, cond = (int) Math.floor(Math.sqrt(n));

        for (int i = 2; i <= cond; i++) {
            if (n % i == 0) {
                sum +=  i;
                if (i != n/i) {
                    sum += n/i;
                }
            }
        }

        return sum;
    }
    
    /**
     * Calculates the sum of a string by converting characters to their
     * integer index in the alphabet (ie. a = 1, b = 2, etc)
     * @param s the string to be summed 
     * @return the sum of all characters by their alphabet index
     */
    public static int stringSum(String s) {
        int sum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            sum += (int)s.charAt(i) - 64;
        }
        
        return sum;
    }

    /**
     * Calculates the factorial of n (ie. n!)
     * @param n the number to be used in the factorial calculation
     * @return the factorial of n
     */
    public static int factorial(int n) {
        int val = 1;
        for (int i = 2; i <= n; i++) {
            val *= i;
        }
        return val;
    }

    /**
     * Checks if number n is prime or not
     * @param n number to be checked
     * @return true if n is prime
     */
    public static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        if (n % 2 == 0) // n is an even, so return true iff n is exactly 2
        {
            return (n == 2);
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) // i divides evenly into n, so n is not prime
            {
                return false;
            }
        }
        return true;
    }
}
