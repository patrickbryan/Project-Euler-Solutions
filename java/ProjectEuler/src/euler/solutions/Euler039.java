package euler.solutions;

import static java.lang.Math.sqrt;

/**
 *
 * @author Patrick
 */
public class Euler039 {

    /**
     * Dumb solution that tries every single combination.
     * Could be refined to make only "smart" choices for a and b so
     * to reduce the checking in the if
     * @return 
     */
    public String solution() {
        int maxSolutions = 0;
        int maximizedP = 0;

        for (int p = 1000; p >= 12; p--) {
            int curSolutions = 0;
            for (int a = 1; a < 999; a++) {
                for (int b = a; b < 999; b++) {
                    int c = (int)sqrt((a*a) + (b*b));
                    //first check against perimeter. Second against c being a decimal
                    if (a + b + c == p && c*c == a*a + b*b) {
                        curSolutions++;
                    }
                }
            }

            if (curSolutions > maxSolutions) {
                maxSolutions = curSolutions;
                maximizedP = p;
            }
        }

        return String.valueOf(maximizedP);
    }
}
