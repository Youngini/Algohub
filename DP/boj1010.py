#다리 놓기
import sys
input = sys.stdin.readline
T = int(input())
arr = [[int(i) for i in input().split()]for _ in range(T)]

def nCr(n, m):
    ans = 1
    d = 1
    for i in range(n):
        ans *= (m - i)
        d *= (i + 1)
    return int(ans/d)

for i in range(T):
    print(nCr(arr[i][0], arr[i][1]))