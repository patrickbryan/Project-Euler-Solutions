package euler.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Patrick Bryan
 */
public class Euler067 {
    
    final int TREE_DEPTH = 100;
    
    public String solution() throws FileNotFoundException {
        File treeFile = new File("tree67.txt");
        Scanner sc = new Scanner(treeFile);
        int[][] bTree = new int[TREE_DEPTH][];
        int curDepth = 0;

        while (sc.hasNextInt()) {
            bTree[curDepth] = new int[curDepth + 1];
            for (int i = 0; i < curDepth + 1; i++) {
                bTree[curDepth][i] = sc.nextInt();
            }
            curDepth++;
        }

        for (int d = --curDepth; d > 0; d--) {
            for (int i = 0; i < d; i++) {
                bTree[d - 1][i] += bTree[d][i] > bTree[d][i + 1]
                        ? bTree[d][i] : bTree[d][i + 1];
            }
        }

        return String.valueOf(bTree[0][0]);
    }
}
