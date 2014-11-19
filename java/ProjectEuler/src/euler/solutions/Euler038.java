package euler.solutions;

import euler.Euler;

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
                if (numberOfDigits(Integer.parseInt(setOfNumbers.toString())) < 9) {
                    setOfNumbers.append(Integer.toString(i*k));
                }
            }
            
            if (numberOfDigits(Integer.parseInt(setOfNumbers.toString())) != 9) {
                continue;
            }
            
            if (isPandigital(setOfNumbers) && 
                    Integer.parseInt(setOfNumbers.toString()) > maxPandigital) {
                maxPandigital = Integer.parseInt(setOfNumbers.toString());
            }
        }
        
        return String.valueOf(maxPandigital);
    }
    
    private boolean isPandigital(StringBuilder s) {
        boolean found[] = new boolean[9];
        
        for (int i = 0; i < s.length(); i++) {
            int num = Character.getNumericValue(s.charAt(i));
            if (num == 0 || found[num-1])
                return false;
            found[num-1] = true;
        }
        
        return true;
    }
    
    /**
     * Counts the amount of digits in i. Max length of 16
     * @param i integer whose digits will be counted
     * @return the amount of digits there are in i
     */
    private int numberOfDigits(int i) {
        int n = 1;
        if (i >= 100000000){i /= 100000000; n += 8;}
        if (i >= 10000){i /= 10000; n += 4;}
        if (i >= 100){i /= 100; n += 2;}
        if (i >= 10){i /= 10; n += 1;}
        
        return n;
    }
}
