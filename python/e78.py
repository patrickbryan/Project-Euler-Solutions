def partition(number):
    answer = set()
    answer.add((number, ))
    for x in range(1, number):
        for y in partition(number - x):
            answer.add(tuple(sorted((x, ) + y)))
    return answer

def euler78():
    num = -1
    i = 30
    while True:
        i += 1
        print(str(i))
        t = len(partition(i))
        print(str(t))
        if t % 1000000 == 0:
            break

    return i
