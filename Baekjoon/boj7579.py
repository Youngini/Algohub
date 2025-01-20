import sys
input = sys.stdin.readline

n, m = map(int, input().split())
apps = [0] + list(map(int, input().split()))
costs = [0] + list(map(int, input().split()))
sum_cost = sum(costs)
dp = [[0] * (sum_cost + 1) for _ in range(n + 1)]
result = sum_cost

for i in range(1, n + 1):
    app = apps[i]
    cost = costs[i]
    
    for j in range(sum_cost + 1):
        if j >= cost:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - cost] + app)
        else:
            dp[i][j] = dp[i - 1][j]
        
        if dp[i][j] >= m:
            result = min(result, j)

if(m != 0):
    print(result)
else:
    print(0)