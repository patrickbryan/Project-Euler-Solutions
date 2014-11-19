package euler.solutions;

import euler.Euler;
import euler.EulerFunction;
import java.math.BigInteger;

/**
 *
 * @author Patrick Bryan
 */
public class Euler025 implements Euler {
    
    @Override
    public String solution() {
        return String.valueOf(EulerFunction.fibRecNthDigit(BigInteger.ONE,
                BigInteger.ONE, 2, 1000));
    }
    
}
