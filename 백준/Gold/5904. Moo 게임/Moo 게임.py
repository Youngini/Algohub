import sys
input = sys.stdin.readline

n = int(input())
length = [3]
while(length[-1] < n):
    length.append(length[-1] * 2 + len(length) + 3)

def find_m(k, n):
    if k == 0:
        return "m" if n == 1 else "o"
    
    prev = length[k - 1]
    mid = k + 3

    if n <= prev :
        return find_m(k - 1, n)
    elif n <= prev + mid:
        return "m" if n - prev == 1 else "o"
    else:
        return find_m(k - 1, n - prev - mid)

print(find_m(len(length) - 1, n))
