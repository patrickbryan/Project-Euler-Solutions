package euler.solutions;

import euler.Euler;

/**
 *
 * @author Patrick Bryan
 */
public class Euler027 implements Euler {
    
    @Override
    public String solution() {
        boolean valid = false;
        int product = 0, n, max = 0;
        
        for (int b = 1000; b > -1000; b--) {
            if (isPrime(b)) {
                for (int a = 1000; a > -1000; a--) {
                    n = 0;
                    while (isPrime(n*n + a*n + b)) {
                        n++;
                    }
                    if (n > max) {
                        max = n;
                        product = a * b;
                    }
                }
            }
        }
        
        return String.valueOf(product);
    }
    
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
