import numpy as np
import sys

matrix = np.zeros((80, 80))
matrix = matrix.astype(int)
#matrix[row][col]

f = open('matrix.txt', 'r')
i = 0

for line in f:
    line = line.replace('\n', '').split(',')
    matrix[i] = line
    i += 1

curCol = 79

while (curCol != -1):
    lowestNum = sys.maxsize
    lowestNumRow = 80

    for k in range(0,80):
        if matrix[k][curCol] < lowestNum:
            lowestNum = matrix[k][curCol]
            lowestNumRow = k

    if (curCol == 0):
        break
    
    curCol -= 1

    matrix[lowestNumRow][curCol] += matrix[lowestNumRow][curCol + 1]

    #down
    for k in range(lowestNumRow + 1, 80):
        if (matrix[k - 1][curCol] > matrix[k][curCol + 1]):
            matrix[k][curCol] += matrix[k - 1][curCol]
        else:
            matrix[k][curCol] += matrix[k][curCol + 1]

    #up
    for k in range(lowestNumRow - 1, -1, -1):
        if (matrix[k + 1][curCol] > matrix[k][curCol + 1]):
            matrix[k][curCol] += matrix[k][curCol + 1]
        else:
            matrix[k][curCol] += matrix[k + 1][curCol]

#---------Find lowest in cur column (start at rightmost ie 79)
#---------CHECK IF THERE IS A COLUMN TO THE LEFT (if not, lowest is ans)
#---------Add item in next column in lowest row. (ie. add the right number)
#---------Move Up/Down adding the lower of the down/up or right numbers
#---------Continue until done column
#---------Repeat

print(lowestNum)

f.close()
