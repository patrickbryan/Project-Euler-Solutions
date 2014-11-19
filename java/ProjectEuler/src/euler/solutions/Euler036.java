package euler.solutions;

import euler.Euler;
import euler.EulerFunction;

/**
 *
 * @author Patrick Bryan
 */
public class Euler036 implements Euler {
    
    @Override
    public String solution(){
        int million = 1000000;
        int sum = 0;
        
        for (int i = 0; i < million; i++) {
            if (EulerFunction.isPalindrome(String.valueOf(i)) && 
                    EulerFunction.isPalindrome(Integer.toBinaryString(i))) {
                sum += i;
            }
        }
        return "" + sum;
    }
}
