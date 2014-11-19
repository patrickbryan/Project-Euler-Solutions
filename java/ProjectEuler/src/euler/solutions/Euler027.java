package euler.solutions;

import euler.Euler;
import euler.EulerFunction;

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
            if (EulerFunction.isPrime(b)) {
                for (int a = 1000; a > -1000; a--) {
                    n = 0;
                    while (EulerFunction.isPrime(n*n + a*n + b)) {
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
}
