package euler.solutions;

import euler.Euler;
import euler.EulerFunction;

/**
 *
 * @author Patrick Bryan
 */
public class Euler038 implements Euler {

    @Override
    public String solution() {
        StringBuilder setOfNumbers = new StringBuilder();
        int maxPandigital = 0;
        mainLoop: for (int i = 9999; i > 0; i--) {
            if (i%10 == 0 || i%10 == 5)
                continue;
            setOfNumbers.setLength(0);
            setOfNumbers.append(Integer.toString(i)).append(Integer.toString(i*2));
            int loopMax = 2;
            
            if (i <= 333) { loopMax++; }
            if (i <= 33) { loopMax++; }
            if (i <= 3) { loopMax++; }
            if (i == 1) { loopMax+=4; }
            
            for (int k = 3; k <= loopMax; k++) {
                if (EulerFunction.numberOfDigits(Integer.parseInt(setOfNumbers.toString())) < 9) {
                    setOfNumbers.append(Integer.toString(i*k));
                }
            }
            
            if (EulerFunction.numberOfDigits(Integer.parseInt(setOfNumbers.toString())) != 9) {
                continue;
            }
            
            if (EulerFunction.isNPandigital(setOfNumbers.toString(), 9) && 
                    Integer.parseInt(setOfNumbers.toString()) > maxPandigital) {
                maxPandigital = Integer.parseInt(setOfNumbers.toString());
            }
        }
        
        return String.valueOf(maxPandigital);
    }
}
