package euler.solutions;

/**
 *
 * @author Patrick Bryan
 */
public class Euler001 {

    public String solution() {
        int sum = 0;
        
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        
        return String.valueOf(sum);
    }
}
