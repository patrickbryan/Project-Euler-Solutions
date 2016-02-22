numList = [-1 for __ in range(10000000)]
#Takes too long (about 1 minute)
def sqDigitChain(n):
    tempList = [n]
    global numList
    while(n != 1 and n != 89):
        if numList[n] != -1:
           n = numList[n]
           break
        strN = str(n)
        n = 0
        for c in strN:
            n += int(c)**2
        tempList.append(n)

    for tl in tempList:
           numList[tl] = n

    return n

def euler92():
    eightyNineLoops = 0
    for i in range(1, 10000000):
        if sqDigitChain(i) == 89:
            eightyNineLoops += 1

    return eightyNineLoops

print(str(euler92()))
