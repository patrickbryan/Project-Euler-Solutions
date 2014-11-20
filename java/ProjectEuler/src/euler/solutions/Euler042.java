package euler.solutions;

import euler.Euler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Patrick
 */
public class Euler042 implements Euler {

    @Override
    public String solution() {
        int wordSum;
        int triangleWords = 0;
        String word;
        Scanner sc;
        try {
            File treeFile = new File("p042_words.txt");
            sc = new Scanner(treeFile);
        } catch (FileNotFoundException e) {
            return "File not found";
        }
        sc.useDelimiter("\",\"|\\n|\"");

        while (sc.hasNext()) {
            word = sc.next();
            word = word.toUpperCase();
            wordSum = 0;
            
            for (int i = 0; i < word.length(); i++) {
                wordSum += word.charAt(i) - 64;
            }
            //wordSum*2 from initial equation to get x^2 + x - wordSum
            //wordSum*4 + 1 to find roots. If roots are integers, wordSum is a
            //triangle number
            wordSum = wordSum * 8 + 1;
            int sqrt = (int) Math.sqrt(wordSum);
            if (sqrt * sqrt == wordSum && sqrt % 2 == 1) {
                triangleWords++;
            }
        }

        return String.valueOf(triangleWords);
    }

}
