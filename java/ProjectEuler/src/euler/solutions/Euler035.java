package euler.solutions;

import euler.Euler;
import java.util.ArrayList;

/**
 *
 * @author Patrick Bryan
 */
public class Euler035 implements Euler {
    
    @Override
    public String solution() {
        ArrayList<Integer> primes = new ArrayList();
        int count = 13;
        
        for (int i = 101; i < 1000000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        
        while (!primes.isEmpty()) {
            int circular = 0;
            while (circular != primes.get(0)) {
                if (circular == 0) {
                    circular = (primes.get(0)/10) + ((primes.get(0) % 10) * 
                            (int)Math.pow(10, primes.get(0).toString().length() - 1));
                } else {
                    circular = (circular/10) + ((circular % 10) * 
                            (int)Math.pow(10, String.valueOf(circular).length() - 1));
                }
                if (circular == primes.get(0)) {
                    count+=String.valueOf(circular).length();
                } else if (!primes.contains(circular)) {
                    break;
                } else {
                    primes.remove(Integer.valueOf(circular));
                }
            }
            primes.remove(0);
        }
        
        return "" + count;
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
