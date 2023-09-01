#보석 도둑
import sys, heapq
input = sys.stdin.readline
N, K = map(int, input().split())
jewelry = [[int(x) for x in input().split()] for _ in range(N)]
bags = [int(input()) for _ in range(K)]
tmp = []
ans = 0

jewelry.sort()
bags.sort()

for i in bags:
    while jewelry and i >= jewelry[0][0]:
        heapq.heappush(tmp, -jewelry[0][1])
        heapq.heappop(jewelry)
    if tmp:
        ans -= heapq.heappop(tmp)
    elif not jewelry:
        break

print(ans)