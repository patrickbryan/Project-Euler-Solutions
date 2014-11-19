package euler.solutions;

import euler.Euler;

/**
 *
 * @author Patrick Bryan
 */
public class Euler037 implements Euler {
    
    @Override
    public String solution() {
        int count = 0;
        int sum = 0;
        
        for (int i = 11; ; i+=2) {
            if(isPrime(i) && rightToLeftPrime(i) && leftToRightPrime(i)) {
                count++;
                sum += i;
            }
            if (count == 11) {
                break;
            }
        }
        return "" + sum;
    }
    
    private boolean rightToLeftPrime(int n) {
        int loop = String.valueOf(n).length() - 1;
        for (int i = 0; i < loop; i++) {
            n /= 10;
            if (!isPrime(n))
                return false;
        }
        return true;
    }
    
    private boolean leftToRightPrime(int n) {
        int loop = String.valueOf(n).length() - 1;
        for (int i = 0; i < loop; i++) {
            n -= (int)Math.pow(10,String.valueOf(n).length() - 1) * 
                    (String.valueOf(n).charAt(0) - 48);
            if (!isPrime(n))
                return false;
        }
        return true;
    }
    
    private boolean isPrime(long n) {
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
