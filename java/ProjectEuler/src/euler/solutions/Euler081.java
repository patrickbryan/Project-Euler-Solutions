package euler.solutions;

import euler.Euler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Patrick Bryan
 */
public class Euler081 implements Euler{

    final int MATRIX_SIZE = 80;

    @Override
    public String solution() {
        /**
         * 1 2 3
         * 4 5 6
         * 7 8 9
         * length = size + (size - 2) start at 8 & 6. Check to see which value
         * before it is less (9) and add. go to 7, 5, 3. Which is less for each
         * (8+9 or 6+9) and add. Rinse and repeat.
         */
        Scanner sc;
        try {
            File treeFile = new File("matrix81.txt");
            sc = new Scanner(treeFile);
        } catch (FileNotFoundException e) {
            return "File not found";
        }
        
        int x = 0;
        int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
        sc.useDelimiter(",|\\n");

        while (sc.hasNextInt()) {
            for (int y = 0; y < MATRIX_SIZE; y++) {
                matrix[x][y] = sc.nextInt();
            }
            x++;
        }

        for (int i = 1; i <= 2 * (MATRIX_SIZE - 1); i++) {
            int rightX, rightY, downX, downY;
            if (i >= MATRIX_SIZE) {
                for (int k = 0; k < (MATRIX_SIZE * 2) - i - 1; k++) {
                    rightX = MATRIX_SIZE - k - 2 - (i - MATRIX_SIZE);
                    rightY = k + 1;
                    downX = MATRIX_SIZE - k - 1 - (i - MATRIX_SIZE);
                    downY = k;

                    if (matrix[rightX][rightY] < matrix[downX][downY]) {
                        matrix[rightX][downY] += matrix[rightX][rightY];
                    } else {
                        matrix[rightX][downY] += matrix[downX][downY];
                    }
                }
            } else {
                for (int k = 1; k <= i + 1; k++) {
                    rightX = MATRIX_SIZE - k;
                    rightY = MATRIX_SIZE - 1 + k - i;
                    downX = MATRIX_SIZE - k + 1;
                    downY = MATRIX_SIZE - 2 + k - i;
                    
                    if (k == 1) {
                        downX = MATRIX_SIZE - k;
                        downY = MATRIX_SIZE - 1 + k - i;
                    } else if (k == i + 1) {
                        rightX = MATRIX_SIZE - k + 1;
                        rightY = MATRIX_SIZE - 2 + k - i;
                    }
                    
                    if (matrix[rightX][rightY] < matrix[downX][downY]) {
                        matrix[MATRIX_SIZE - k][MATRIX_SIZE - 2 + k - i] += 
                                matrix[rightX][rightY];
                    } else {
                        matrix[MATRIX_SIZE - k][MATRIX_SIZE - 2 + k - i] += 
                                matrix[downX][downY];
                    }
                }
            }
        }

        return String.valueOf(matrix[0][0]);
    }
}
