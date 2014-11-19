package euler.solutions;

/**
 *
 * @author Patrick Bryan
 */
public class Euler045 {
    public String solution() {
        long t, p = 40755, h = 40755, value = -1;
        long a = 165, b = 143;
        
        for(long n = 286; n < Long.MAX_VALUE; n++) {
            t = n*(n+1)/2;
            while (t > p) {
                a++;
                p = a*(3*a-1)/2;
            }
            while (t > h) {
                b++;
                h = b*(2*b-1);
            }
            if (t == p && t == h) {
                value = t;
                break;
            }
        }
        return String.valueOf(value);
    }
}
