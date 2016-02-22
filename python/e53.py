from operator import mul    # or mul=lambda x,y:x*y
from fractions import Fraction
from functools import reduce

def nCr(n,r):
    return int( reduce(mul, (Fraction(n-i, i+1) for i in range(r)), 1) )

def euler53():
    valsExceed = 0
    for n in range(1,101):
        for r in range(n, 1, -1):
            if nCr(n, r) > 1000000:
                valsExceed += 1
    return valsExceed

print(str(euler53()))
