package euler.solutions;

import euler.Euler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Patrick Bryan
 */
public class Euler022 implements Euler {

    @Override
    public String solution() {
        int sum = 0;
        File input = new File("names.txt");
        ArrayList<String> names = new ArrayList();

        try {
            Scanner sc = new Scanner(input);
            sc.useDelimiter("\",\"");
            while (sc.hasNext()) {
                names.add(sc.next());
            }
            names.set(0, names.get(0).substring(1));
            names.set(names.size() - 1,
                    names.get(names.size() - 1).substring(0,
                            names.get(names.size() - 1).length() - 1));

            Collections.sort(names, new Comparator<String>() {
                @Override
                public int compare(String name1, String name2) {

                    return name1.compareTo(name2);
                }
            });
            
            for (int i = 0; i < names.size(); i++) {
                sum += (i + 1) * nameSum(names.get(i));
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return String.valueOf(sum);
    }
    
    public int nameSum(String name) {
        int sum = 0;
        
        for (int i = 0; i < name.length(); i++) {
            sum += (int)name.charAt(i) - 64;
        }
        
        return sum;
    }
}
