package euler.solutions;

import euler.Euler;

/**
 *
 * @author Patrick Bryan
 */
public class Euler028 implements Euler {
    
    @Override
    public String solution() {
        int sum = 1;
        int max = 1001;
        int k = 2;
        
        for (int i = 3; i <= max; i+=2) {
            sum += (i * i);
            sum += (i * i) - ((i - k) * 2);
            sum += (i * i) - ((i - k) * 4);
            sum += (i * i) - ((i - k) * 6);
            k++;
        }
        
        return String.valueOf(sum);
    }
}
