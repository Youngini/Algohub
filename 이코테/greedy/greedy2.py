import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())
arr = [int(x) for x in input().split()]
arr.sort(reverse=True)

ans = 0

for i in range(1, M + 1):
    if(i % K == 0):
        ans += arr[1]
    else:
        ans += arr[0]

print(ans)