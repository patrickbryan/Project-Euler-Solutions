package euler.solutions;

import euler.Euler;
import euler.EulerFunction;
import java.util.ArrayList;

/**
 *
 * @author Patrick
 */
public class Euler043 implements Euler {

    @Override
    public String solution() {
        ArrayList<String> allPandigitals = EulerFunction.permutation("9876543210");
        int num;
        int primes[] = {2,3,5,7,11,13,17};
        long sum = 0;
        
        for (String pandigital : allPandigitals) {
            if (pandigital.charAt(0) != '0') {
                for (int i = 1; i < 8; i++) {
                    num = Integer.parseInt(pandigital.substring(i, i+3));
                    
                    if (num % primes[i-1] != 0) {
                        break;
                    } else if (i == 7) {
                        sum += Long.parseLong(pandigital);
                    }
                }
            } else {
                break;
            }
        }
        
        return String.valueOf(sum);
    }

}
