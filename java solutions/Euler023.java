package euler.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Patrick Bryan
 */
public class Euler023 {

    final int UPPER_LIMIT = 28123;

    public String solution() {
        int sum = 0, count = 0;
        ArrayList<Integer> abundantNum = new ArrayList();
        boolean[] abundantSums = new boolean[UPPER_LIMIT];

        for (int i = 12; i <= UPPER_LIMIT; i++) {
            if (sumFactors(i) > i) {
                abundantNum.add(i);
            }
        }
        
        for (int i = 0; i < abundantNum.size(); i++) {
            for (int k = i; k < abundantNum.size(); k++) {
                if (abundantNum.get(i) + abundantNum.get(k) <= UPPER_LIMIT)
                    abundantSums[abundantNum.get(i) + abundantNum.get(k) - 1] = true;
            }
        }

        for (int i = 1; i <= UPPER_LIMIT; i++) {
              if (abundantSums[i-1] == false)
                  sum += i;
        }

        return String.valueOf(sum);
    }

    private int sumFactors(int n) {
        int sum = 1, cond = (int) Math.floor(Math.sqrt(n));

        for (int i = 2; i <= cond; i++) {
            if (n % i == 0) {
                sum +=  i;
                if (i != n/i) {
                    sum += n/i;
                }
            }
        }

        return sum;
    }
}
