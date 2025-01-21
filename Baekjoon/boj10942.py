import sys
input = sys.stdin.readline

n = int(input())
arr = [0] + list(map(int, input().split()))
m = int(input())
questions = [list(map(int, input().split())) for _ in range(m)]

dp = [[0] * (n + 1) for _ in range(n + 1)]

for i in range(n, 0, -1):
    for j in range(i, n + 1):
        if i == j : dp[i][j] = 1
        elif arr[i] == arr[j]:
            if i == j - 1 : dp[i][j] = 1
            else : dp[i][j] = dp[i + 1][j - 1]

for s,e in questions:
    print(dp[s][e])