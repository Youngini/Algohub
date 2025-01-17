import sys
from fractions import Fraction

input = sys.stdin.readline

def dp(remainder, visited):
    if visited == (1 << n) - 1:
        return 1 if remainder == 0 else 0, 1

    if memo[remainder][visited] != (-1, -1):
        return memo[remainder][visited]

    count, total = 0, 0
    for i in range(n):
        if not (visited & (1 << i)):
            new_remainder = (remainder * mod10[len_s[i]] + s[i]) % k
            new_count, new_total = dp(new_remainder, visited | (1 << i))
            count += new_count
            total += new_total

    memo[remainder][visited] = (count, total)
    return memo[remainder][visited]

n = int(input())
s = [int(input()) for _ in range(n)]
k = int(input())

len_s = [len(str(num)) for num in s]
mod10 = [pow(10, l, k) for l in range(max(len_s) + 1)]

memo = [[(-1, -1)] * (1 << n) for _ in range(k)]

cnt, total = dp(0, 0)
ans = Fraction(cnt, total)

if ans == 0:
    print("0/1")
elif ans == 1:
    print("1/1")
else:
    print(ans)
