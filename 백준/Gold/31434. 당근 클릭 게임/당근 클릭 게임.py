import sys
input = sys.stdin.readline

n, k = map(int, input().split())
A = []
B = []
for _ in range(n):
    a, b = map(int, input().split())
    A.append(a)
    B.append(b)

dp = {1 : 0} # 속도 : 당근 수

for _ in range(k):
    next_dp = {}

    for s, m in dp.items():

        # 1. 클릭
        ns = s
        nm = m + s

        if nm > next_dp.get(ns, -1):
            next_dp[ns] = nm
        
         # 2) 스피드 구매
        for i in range(n):
            if m >= A[i]:
                ns = s + B[i]
                nm = m - A[i]
                if nm > next_dp.get(ns, -1):
                    next_dp[ns] = nm
    
    dp = next_dp

print(max(dp.values()))