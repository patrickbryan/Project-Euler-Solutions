package euler.solutions;

/**
 *
 * @author Patrick Bryan
 */
public class Euler040 {
    public String solution() {
        int product = 1;
        int pos = 0;
        int d = 1;
        
        for (int i = 1; i <= 1000000; i++) {
            if (pos + String.valueOf(i).length() >= d) {
                product *= (int)String.valueOf(i).charAt(d - pos - 1) - 48;
                d *= 10;
            }
            pos += String.valueOf(i).length();
        }
        
        return String.valueOf(product);
    }
}
