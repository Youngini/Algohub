import sys
import heapq

input = sys.stdin.readline

n = int(input())

rails = []

for _ in range(n):
    a, b = map(int, input().split())
    if a > b : 
        a, b = b, a
    rails.append([a, b])

d = int(input())

# 끝점만 오름차순
rails.sort(key = lambda x : (x[1]))

# 시작점 담음
heap = []
ans = 0

for s,e in rails:
    if e - s > d:
        continue

    heapq.heappush(heap, s)

    while heap and heap[0] < e - d:
        heapq.heappop(heap)
    
    ans = max(ans, len(heap))

print(ans)