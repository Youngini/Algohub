#로프
import sys
input = sys.stdin.readline
N = int(input())
weight = [int(input()) for x in range(N)]
weight.sort()
ans = 0

for i in range(N):
    temp = (N - i) * weight[i]
    if(temp > ans):
        ans = temp
print(ans)