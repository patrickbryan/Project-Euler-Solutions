package euler.solutions;

import java.math.BigInteger;

/**
 *
 * @author Patrick Bryan
 */
public class Euler016 {
    
    public String solution() {
        BigInteger val = new BigInteger("1");
        BigInteger biTwo = new BigInteger("2");
        int sum = 0;
        String strVal;

        for (int i = 0; i < 1000; i++) {
            val = val.multiply(biTwo);
        }
        strVal = val.toString();

        for (int i = 0; i < strVal.length(); i++) {
            sum += Integer.parseInt(Character.toString(strVal.charAt(i)));
        }
        return String.valueOf(sum);
    }
}
