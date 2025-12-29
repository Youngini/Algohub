import sys
input = sys.stdin.readline

# dp 배열 미리 채우기
dp = [0] * 251
dp[0] = 1
dp[1] = 1
dp[2] = 3

for i in range(3, 251):
    dp[i] = dp[i - 1] + 2 * dp[i - 2]

# 여러 줄 입력 끝까지 처리
for line in sys.stdin:
    n = int(line.strip())
    print(dp[n])