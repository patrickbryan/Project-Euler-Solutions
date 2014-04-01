package euler.solutions;

/**
 *
 * @author Patrick Bryan
 */
public class Euler026 {
    public String solution() {
        int maxPeriod = 0;
        int denom = 0;
        
        for (int i = 999; i > 1; i--) {
            if (decimalPeriod(i) > maxPeriod) {
                maxPeriod = decimalPeriod(i);
                denom = i;
            }
        }
        
        return String.valueOf(denom);
    }
    
    private int decimalPeriod(int n) {
        boolean[] remaindersHit = new boolean[n];
        int[] remaindersPos = new int[n];
        int numerator = 1;
        
        for (int i = 0; i < n; i ++) {
            numerator = numerator%n;
            if (numerator == 0) {
                break;
            } else if (remaindersHit[numerator] == true) {
                return i - remaindersPos[numerator];
            }
            remaindersHit[numerator] = true;
            remaindersPos[numerator] = i;
            numerator *= 10;
        }
        
        return 0;
    }
}
