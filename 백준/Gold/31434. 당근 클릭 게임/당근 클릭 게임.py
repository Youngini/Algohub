import sys
input = sys.stdin.readline

n, k = map(int, input().split())
A = []
B = []
for _ in range(n):
    a, b = map(int, input().split())
    A.append(a)
    B.append(b)

MAXS = 1 + 50 * k  # 속도 최대 가능치 (여유 있게 잡음)

# dp[t][s] = t초에 속도 s일 때 가능한 최대 당근
dp = [[-1] * (MAXS + 1) for _ in range(k + 1)]
dp[0][1] = 0  # 시작: t=0, 속도=1, 당근=0

for t in range(k):
    for s in range(1, MAXS + 1):
        if dp[t][s] == -1:
            continue
        
        m = dp[t][s]  # 현재 당근

        # 1. 클릭
        ns = s
        nm = m + s
        dp[t+1][ns] = max(dp[t+1][ns], nm)

        # 2. 스피드 효과 구매
        for i in range(n):
            if m >= A[i]:
                ns = s + B[i]
                nm = m - A[i]
                if ns <= MAXS:
                    dp[t+1][ns] = max(dp[t+1][ns], nm)

answer = max(dp[k])
print(answer)
