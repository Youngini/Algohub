#연속합
import sys
input = sys.stdin.readline
N = int(input())
sequence = [int(x) for x in input().split()]
dp = [0 for _ in range(N)]
dp[0] = sequence[0]

for i in range(1, N):
    dp[i] = max(dp[i - 1]+ sequence[i], sequence[i])

print(max(dp))