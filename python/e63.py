def euler63():
    powDigits = 0
    curPow = 1

    while(True):
        n = 1
        nPow = n**curPow
        powFound = False
        while(len(str(nPow)) <= curPow):
            if len(str(nPow)) == curPow:
                powFound = True
                powDigits += 1
            n += 1
            nPow = n**curPow
        curPow += 1
        if not powFound:
            break
    
    return powDigits

euler63()
