import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [ list(map(int, input().split())) for _ in range(N)]

ans = 0

for i in range(N):
    m = min(arr[i])
    ans = max(ans, m)

print(ans)