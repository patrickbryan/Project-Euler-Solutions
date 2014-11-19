package euler.solutions;

import euler.Euler;
import euler.EulerFunction;
import java.util.ArrayList;

/**
 *
 * @author Patrick Bryan
 */
public class Euler023 implements Euler {

    final int UPPER_LIMIT = 28123;

    @Override
    public String solution() {
        int sum = 0, count = 0;
        ArrayList<Integer> abundantNum = new ArrayList();
        boolean[] abundantSums = new boolean[UPPER_LIMIT];

        for (int i = 12; i <= UPPER_LIMIT; i++) {
            if (EulerFunction.sumFactors(i) > i) {
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

    
}
