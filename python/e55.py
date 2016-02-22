def isPalindrome(n):
    n = str(n)
    isP = True
    for i in range(int(len(n)/2)):
        if n[i] != n[len(n) - 1 - i]:
            isP = False
            break
    return isP

def revNum(n):
    n = str(n)
    n = n[::-1]
    n = int(n)
    return n

def isLychrel(n):
    isL = True
    for i in range(50):
        n = n + revNum(n)
        if isPalindrome(n):
            isL = False
            break
    return isL

def euler55():
    lychrels = 0
    for i in range(10000):
        if isLychrel(i):
            lychrels += 1
    return lychrels

euler55()
