import sys
from collections import deque
input = sys.stdin.readline

N, M, K = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(sx, sy):
    q = deque()
    q.append((sx, sy))
    graph[sx][sy] = 1
    size = 1

    while q:
        x, y = q.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] == 0:
                graph[nx][ny] = 1
                q.append((nx, ny))
                size += 1
    return size

total = 0

for i in range(N):
    for j in range(N):
        if graph[i][j] == 0:
            t = bfs(i, j)
            total += (t + K - 1) // K   # 구역 전체에 필요한 포자 수

if total > M or total == 0:
    print("IMPOSSIBLE")
else:
    print("POSSIBLE")
    print(M - total)
