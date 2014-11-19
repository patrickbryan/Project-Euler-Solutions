package euler.solutions;

import euler.Euler;
import euler.EulerFunction;
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
            if (EulerFunction.isPrime(i)) {
                primes.add(0,i);
            } else {
                for (int k = 0; k < primes.size(); k++) {
                    if (EulerFunction.isPerfectSquare((i - primes.get(k))/2)) {
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
}
