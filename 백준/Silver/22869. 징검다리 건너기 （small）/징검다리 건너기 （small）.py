import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = [ i for i in map(int, input().split())]

dp = [False] * n
dp[0] = True

for i in range(n):
    if dp[i] == True:
        for j in range(i + 1, n):
            temp = (j - i) * (abs(arr[i] - arr[j]) + 1)
            if temp <= k : dp[j] = True

print("YES" if dp[n - 1] == True else "NO")