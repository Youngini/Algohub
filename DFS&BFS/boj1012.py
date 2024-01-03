# 유기농 배추
import sys
from collections import deque
input = sys.stdin.readline
T = int(input())

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    graph[x][y] = 0 # 탐색한 부분 재탐색 안하려고

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            #탐색 범위 넘어가지 않도록 주의
            if(nx < 0 or ny <0 or nx >= M or ny >= N):
                continue

            if(graph[nx][ny] == 1):
                queue.append((nx, ny))
                graph[nx][ny] = 0 # 탐색한 부분 재탐색 안하려고



for _ in range(T):
    M, N, K = map(int, input().split())
    graph = [[0 for _ in range(N)] for _ in range(M)]
    cnt = 0
    for _ in range(K):
        x, y = map(int, input().split())
        graph[x][y] = 1
    
    for i in range(M):
        for j in range(N):
            if(graph[i][j] == 1):
                cnt += 1
                bfs(i, j)
    print(cnt)