package euler.solutions;

import euler.Euler;
import euler.EulerFunction;

/**
 *
 * @author Patrick Bryan
 */
public class Euler033 implements Euler {

    @Override
    public String solution() {

        int totalNumer = 1, totalDenom = 1;
        int ans;
        int found = 0;

        for (int numer = 11; numer < 100; numer++) {
            for (int denom = numer + 1; denom < 100; denom++) {
                // Shouldn't be testing decimals for ==
                if ((numer / 10 == denom % 10 && (double) (numer % 10) / (denom / 10)
                        == (double) numer / denom) || (denom / 10 == numer % 10 && (double) (numer / 10) / (denom % 10)
                        == (double) numer / denom)) {
                    totalNumer *= numer;
                    totalDenom *= denom;
                    found++;
                }
            }
        }

        if (found != 4) {
            return "Error, decimal compare failed";
        }
        ans = EulerFunction.lowestFormDenom(totalNumer, totalDenom);

        return "" + ans;
    }
}
