package euler.solutions;

import euler.Euler;
import euler.EulerFunction;

/**
 *
 * @author Patrick Bryan
 */
public class Euler037 implements Euler {
    
    @Override
    public String solution() {
        int count = 0;
        int sum = 0;
        
        for (int i = 11; ; i+=2) {
            if(EulerFunction.isPrime(i) && rightToLeftPrime(i) && leftToRightPrime(i)) {
                count++;
                sum += i;
            }
            if (count == 11) {
                break;
            }
        }
        return "" + sum;
    }
    
    private boolean rightToLeftPrime(int n) {
        int loop = String.valueOf(n).length() - 1;
        for (int i = 0; i < loop; i++) {
            n /= 10;
            if (!EulerFunction.isPrime(n))
                return false;
        }
        return true;
    }
    
    private boolean leftToRightPrime(int n) {
        int loop = String.valueOf(n).length() - 1;
        for (int i = 0; i < loop; i++) {
            n -= (int)Math.pow(10,String.valueOf(n).length() - 1) * 
                    (String.valueOf(n).charAt(0) - 48);
            if (!EulerFunction.isPrime(n))
                return false;
        }
        return true;
    }
}
