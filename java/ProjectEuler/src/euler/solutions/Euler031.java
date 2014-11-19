package euler.solutions;

import euler.Euler;

/**
 *
 * @author Patrick Bryan
 */
public class Euler031 implements Euler {

    @Override
    public String solution() {
        int comb = 0;

        for (int f = 0; f <= 1; f++) { //200
            int eEnd = 2 - 2*f;
            for (int e = 0; e <= eEnd; e++) { //100
                int dEnd = 4 - 4*f - 2*e;
                for (int d = 0; d <= dEnd; d++) { //50
                    int cEnd = 10 - 10*f - 5*e - (int)(2.5*d);
                    for (int c = 0; c <= cEnd; c++) { //20
                        int bEnd = 20 - 20*f - 10*e - 5*d - 2*c;
                        for (int b = 0; b <= bEnd; b++) { //10
                            int aEnd = 40 - 40*f - 20*e - 10*d - 4*c - 2*b;
                            for (int a = 0; a <= aEnd; a++) { //5
                                int change = f*200 + e*100 + d*50 + c*20 + b*10
                                        + a*5;
                                comb += ((200 - change)/2) + 1;
                            }
                        }
                    }
                }
            }
        }

        return String.valueOf(comb);
    }
}
