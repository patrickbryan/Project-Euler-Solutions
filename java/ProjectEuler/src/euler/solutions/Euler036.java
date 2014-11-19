package euler.solutions;

import euler.Euler;

/**
 *
 * @author Patrick Bryan
 */
public class Euler036 implements Euler {
    
    @Override
    public String solution(){
        int million = 1000000;
        int sum = 0;
        
        for (int i = 0; i < million; i++) {
            if (isPalindrome(String.valueOf(i)) && 
                    isPalindrome(Integer.toBinaryString(i))) {
                sum += i;
            }
        }
        return "" + sum;
    }
    
    private boolean isPalindrome(String s) {
        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf = strReverse(s.substring((int) Math.ceil(s.length() / 2.0)));
        return firstHalf.equals(secondHalf);
    }
    
    private String strReverse(String s) {
        String sReverse = "";
        for (int i = 1; i <= s.length(); i++) {
            sReverse += s.charAt(s.length() - i);
        }
        return sReverse;
    }
}
