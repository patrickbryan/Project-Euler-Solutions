package euler.solutions;

import euler.Euler;
import euler.EulerFunction;

/**
 *
 * @author Patrick Bryan
 */
public class Euler024 implements Euler {

    @Override
    public String solution() {
        String result = "", numbers = "0123456789";
        int cur = 0, temp, count;
        final int max = 1000000;

        for (int i = 10; i >= 1; i--) {
            count = 0;
            temp = EulerFunction.factorial(i) / i;
            while (cur + temp < max) {
                cur += temp;
                count++;
            }
            result += String.valueOf(numbers.charAt(count));
            numbers = count == 0 ? numbers.substring(1) : 
                    numbers.substring(0, count) + numbers.substring(count + 1);
        }

        return result;
    }
}
