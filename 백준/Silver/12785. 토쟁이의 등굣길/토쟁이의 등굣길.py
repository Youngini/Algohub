import sys
input = sys.stdin.readline
MOD = 1000007

w, h = map(int, input().split())
x, y = map(int, input().split())

def DP(a, b):
    dp = [[0] * (b + 1) for _ in range(a + 1)]
    for i in range(1, a + 1):
        for j in range(1, b + 1):
            if i == 1 or j == 1:
                dp[i][j] = 1
            else:
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD
    return dp[a][b]

a = DP(x, y)
b = DP(w - x + 1, h - y + 1)

print((a * b) % MOD)