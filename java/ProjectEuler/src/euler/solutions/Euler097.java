package euler.solutions;

import euler.Euler;

/**
 *
 * @author Patrick
 */
public class Euler097 implements Euler {

    @Override
    public String solution() {
        int twosPower = 7830457;
        short mult[] = {2,8,4,3,3};
        short result[] = new short[10];
        short carries[] = new short[10];
        short finalResult[] = new short[10];
        String ans = "";
        
        //Haskell solution: (28433*2^7830457 + 1) `mod` 10000000000
        //2^7830457 calculation
        result[9] = 1;
        for (int i = 0; i < twosPower; i++) {
            for (int k = 9; k >= 0; k--) {
                result[k] *= 2;
                if (result[k] > 9) {
                    result[k] -= 10;
                    carries[k] = 1;
                }
            }
            //Carry loop
            for (int k = 8; k >= 0; k--) {
                result[k] += carries[k+1];
                carries[k+1] = 0;
            }
        }
        
        //multiplying by 28433 calculation
        for (int multIndex = mult.length - 1; multIndex >= 0; multIndex--) {
            for (int resultIndex = 9; resultIndex >= 0; resultIndex--) {
                int finalResultIndex = resultIndex - ((mult.length - 1) - multIndex);
                if (finalResultIndex < 0) {
                    break;
                }
                finalResult[finalResultIndex] += (short)(result[resultIndex] * mult[multIndex]);
                if (finalResult[resultIndex] > 9) {
                    carries[finalResultIndex] += finalResult[finalResultIndex]/10;
                    finalResult[finalResultIndex] %= 10;
                }
            }
        }
        for (int k = 8; k >= 0; k--) {
            finalResult[k] += carries[k+1];
            if (finalResult[k] > 9) {
                    carries[k] += finalResult[k]/10;
                    finalResult[k] %= 10;
                }
        }
        
        //+1
        finalResult[9]++;
        
        for (int k = 0; k < 10; k++) {
            ans += "" + finalResult[k];
        }
        
        return ans;
    }

}
