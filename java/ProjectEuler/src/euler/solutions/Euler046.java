package euler.solutions;

import euler.Euler;
import java.util.ArrayList;

/**
 *
 * @author Patrick Bryan
 */
public class Euler046 implements Euler {
    
    @Override
    public String solution() {
        ArrayList<Integer> primes = new ArrayList<>();
        int smallest = 0;
        boolean smallestHit = false;
        
        for (int i = 3; i < Integer.MAX_VALUE; i+=2) {
            if (isPrime(i)) {
                primes.add(0,i);
            } else {
                for (int k = 0; k < primes.size(); k++) {
                    if (isPerfectSquare((i - primes.get(k))/2)) {
                        smallestHit = false;
                        break;
                    } else {
                        smallestHit = true;
                    }
                }
                if (smallestHit) {
                    smallest = i;
                    break;
                }
            }
        }
        
        return String.valueOf(smallest);
    }
    
    public boolean isPerfectSquare(long n) {
        return Math.pow(((long)Math.sqrt(n)), 2) == n;
    }
    
    public boolean isPrime(long n) {
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
