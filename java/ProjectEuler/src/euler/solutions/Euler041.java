package euler.solutions;

import euler.EulerFunction;
import euler.Euler;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Patrick
 */
public class Euler041 implements Euler {

    @Override
    public String solution() {
        String highestPandigital = "987654321";

        for (int i = 0; i < 9; i++) {
            ArrayList<String> perms = EulerFunction.permutation(highestPandigital);
            for (String s : perms) {
                if (EulerFunction.isPrime(Integer.parseInt(s))) {
                    return s;
                }
            }
            highestPandigital = highestPandigital.substring(1);
        }

        return "No value found";
    }
}
