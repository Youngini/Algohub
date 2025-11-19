import sys
input = sys.stdin.readline

n, m = map(int, input().split())
V = [list(map(int, input().split())) for _ in range(m)]

# dp[d][t] d는 날짜, t는 디저트 종류
dp = [[0] * m for _ in range(n)]

for i in range(m):
    dp[0][i] = V[i][0]

for i in range(1, n):
    for j in range(m):
        for k in range(m):
            if(j == k):
                dp[i][j] = max(dp[i][j], dp[i-1][k] + V[j][i] // 2)
            else:
                dp[i][j] = max(dp[i][j], dp[i-1][k] + V[j][i])

print(max(dp[n - 1]))