package euler.solutions;

import euler.Euler;
import euler.EulerFunction;

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
            d = EulerFunction.sumFactors(i);
            if (d < TOP_LIMIT && EulerFunction.sumFactors(d) == i &&
                    d > i) {
                sum += i + d;
            }
        }
        
        return String.valueOf(sum);
    }
}
