package euler.solutions;

import java.util.ArrayList;

/**
 * Brute force technique
 * @author Patrick Bryan
 */
public class Euler032 {
    
    public String solution() {
        int sum = 0;
        int product;
        String s;
        ArrayList<Integer> products = new ArrayList();
        
        for (int i = 2; i < 99; i++) {
            for (int k = 123; k < 9876; k++) {
                product = i*k;
                s = String.valueOf("" + i + k + product);
                if (s.length() > 9)
                    break;
                if (s.length() == 9) {
                    if (s.contains("1") && s.contains("2") && s.contains("3") &&
                            s.contains("4") && s.contains("5") && s.contains("6")
                            && s.contains("7") && s.contains("8") && s.contains("9")) {
                        if (!products.contains(product)) {
                            sum += product;
                            products.add(product);
                        }
                    }
                }
            }
        }
        
        return String.valueOf(sum);
    }
}
