package euler.solutions;

import euler.Euler;
import euler.EulerFunction;

/**
 *
 * @author Patrick Bryan
 */
public class Euler026 implements Euler {
    
    @Override
    public String solution() {
        int maxPeriod = 0;
        int denom = 0;
        
        for (int i = 999; i > 1; i--) {
            if (EulerFunction.decimalPeriod(i, 1) > maxPeriod) {
                maxPeriod = EulerFunction.decimalPeriod(i, 1);
                denom = i;
            }
        }
        
        return String.valueOf(denom);
    }
}
