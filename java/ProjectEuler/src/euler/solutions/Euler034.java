package euler.solutions;

import euler.Euler;

/**
 *
 * @author Patrick Bryan
 */
public class Euler034 implements Euler {

    int[] factorials = new int[10]; //0! to 9!

    @Override
    public String solution() {
        int sum = 0;

        factorials[0] = 1; //0!
        for (int i = 1; i < 10; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        for (int i = 10; i < 100000000; i++) {
            int factorialSum = 0;
            String num = String.valueOf(i);
        
            for (int k = 0; k < num.length(); k++) {
                    factorialSum += factorials[num.charAt(k) - 48];
            }

            if (factorialSum == i) {
                sum += i;
            }
        }

        return String.valueOf(sum);
    }
}
