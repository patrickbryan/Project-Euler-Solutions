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
            if (isDigitFactorial(String.valueOf(i))) {
                sum += i;
            }
        }

        return "" + sum;
    }

    private boolean isDigitFactorial(String num) {
        int sum = 0;
        
        for (int i = 0; i < num.length(); i++) {
            sum += factorials[num.charAt(i) - 48];
        }
        
        return sum == Integer.parseInt(num);
    }
}
