import sys
input = sys.stdin.readline

N = int(input())
time_tables = [list(map(int, input().split())) for _ in range(N)]
dp = [0] * N

if N == 1:
    dp[0] = time_tables[0][2]

elif N == 2:
    dp[0] = time_tables[0][2]
    dp[1] = time_tables[1][2]

elif N == 3:
    dp[0] = time_tables[0][2]
    dp[1] = time_tables[1][2]
    dp[2] = dp[0] + time_tables[2][2]

else:
    dp[0] = time_tables[0][2]
    dp[1] = time_tables[1][2]
    dp[2] = dp[0] + time_tables[2][2]
    for i in range(3, N):
        dp[i] = max(dp[i - 2], dp[i - 3]) + time_tables[i][2]
    
print(max(dp))