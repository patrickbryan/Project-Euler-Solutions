package euler.solutions;

import euler.Euler;

/**
 *
 * @author Patrick Bryan
 */
public class Euler021 implements Euler {
    
    final int TOP_LIMIT = 10000;
    
    @Override
    public String solution() {
        int sum = 0, d;
        
        for (int i = 4; i < TOP_LIMIT; i++) {
            d = sumFactors(i);
            if (d < TOP_LIMIT && sumFactors(d) == i &&
                    d > i) {
                sum += i + d;
            }
        }
        
        return String.valueOf(sum);
    }
    
    private int sumFactors(int n) {
        int sum = 1, cond = (int)Math.floor(Math.sqrt(n));
        
        for (int i = 2; i <= cond; i++) {
            sum += n % i == 0 ? i + (n/i) : 0;
        }
        
        return sum;
    }
}
