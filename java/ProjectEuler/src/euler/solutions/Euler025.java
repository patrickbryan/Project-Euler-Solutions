package euler.solutions;

import euler.Euler;
import java.math.BigInteger;

/**
 *
 * @author Patrick Bryan
 */
public class Euler025 implements Euler {
    
    @Override
    public String solution() {
        return String.valueOf(fibRec1000Digit(BigInteger.ONE,BigInteger.ONE,2));
    }
    private int fibRec1000Digit (BigInteger f1, BigInteger f2, int term) {
        BigInteger temp = f1;
        f1 = f2;
        f2 = f2.add(temp);
        term++;
        
        if (f2.toString().length() < 1000) {
            return fibRec1000Digit(f1,f2,term);
        }
        
        return term;
    }
}
