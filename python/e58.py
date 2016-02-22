import itertools

def check_prime(n, primes):
    for p in primes:
        if not n % p:
            return False
    return True

def prime_sieve():
    primes = set()
    for n in itertools.count(2):
        if check_prime(n, primes):
            primes.add(n)
            yield n


n = 2
ratio = 1.0
ratio_limit = 0.1
pCheck = [0, 0, 0]
curr_spiral = 1
total_primes = 0
spiral_primes = 0
p = prime_sieve()
next_p = 0

while(ratio > ratio_limit):
    s = curr_spiral * curr_spiral
    pCheck[0] = s + n
    pCheck[1] = pCheck[0] + n
    pCheck[2] = pCheck[1] + n

    i = 0
    getNextP = False
    while(i != 3):
        if(next_p == pCheck[i]):
            spiral_primes += 1
            i += 1
            getNextP = True
        elif(next_p > pCheck[i]):
            i += 1
            getNextP = False
            if(i != 3 and next_p > pCheck[i]):
                i += 1
        else:
            getNextP = True

        if(getNextP):
            next_p = next(p)
        total_primes += 1

    ratio = spiral_primes / total_primes

    n += 2
    curr_spiral += 2

print('-------------')
print(str(n-1))
print(ratio)
print(spiral_primes)
print(total_primes)

#26241
