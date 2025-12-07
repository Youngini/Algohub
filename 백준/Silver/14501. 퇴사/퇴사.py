import sys
input = sys.stdin.readline

n = int(input())
T = [0]
P = [0]
for _ in range(n):
    t, p = map(int, input().split())
    T.append(t)
    P.append(p)

dp = [0] * (n + 2)
for i in range(1, n + 1):
    # 일을 안해
    dp[i] = max(dp[i],  dp[i - 1])
    
    # 일을 해
    t = i + T[i]
    if(t <= n + 1):
        dp[t] = max(dp[i] + P[i], dp[t])

print(max(dp))