def isPerm(a, b):
	a = str(a)
	b = str(b)
	isP = True
	for num in a:
		if num not in b:
			isP = False
	return isP

def euler52(a):
	a2 = a*2
	a3 = a*3
	a4 = a*4
	a5 = a*5
	a6 = a*6
	found = False
	while(not found):
		a += 1
		a2 += 2
		a3 += 3
		a4 += 4
		a5 += 5
		a6 += 6
		if isPerm(a, a2) and isPerm(a, a3) and isPerm(a, a4) and isPerm(a, a5) and isPerm(a, a6):
			found = True
	return a

print(str(euler52(100000)))
