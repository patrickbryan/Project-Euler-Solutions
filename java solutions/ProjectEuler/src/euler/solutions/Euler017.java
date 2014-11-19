package euler.solutions;

/**
 *
 * @author Patrick Bryan
 */
public class Euler017 {

    public String solution() {
        int[] oneToNineteen = {3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8};
        int[] twentyToNinty = {6, 6, 5, 5, 5, 7, 6, 6};
        int hundred = 7;
        int thousand = 8;
        int and = 3;
        int letterSum = 0;

        for (int i = 1; i <= 1000; i++) {
            if (i < 20) {
                letterSum += oneToNineteen[i - 1];
            } else if (i < 100) {
                letterSum += twentyToNinty[(i / 10) - 2];
                letterSum += i % 10 != 0 ? oneToNineteen[i % 10 - 1] : 0;
            } else if (i < 1000) {
                letterSum += oneToNineteen[(i / 100) - 1];
                letterSum += hundred;
                letterSum += i % 100 != 0 ? and : 0;
                if (i % 100 >= 20) {
                    letterSum += twentyToNinty[((i % 100) / 10) - 2];
                    letterSum += i % 10 != 0 ? oneToNineteen[i % 10 - 1] : 0;
                } else {
                    letterSum += i % 20 != 0 ? oneToNineteen[i % 100 - 1] : 0;
                }
            } else {
                letterSum += oneToNineteen[0];
                letterSum += thousand;
            }
        }
        return String.valueOf(letterSum);
    }
}
