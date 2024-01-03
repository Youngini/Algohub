# 단지번호붙이기
from collections import deque
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
N = int(input())
graph = [[0 for _ in range(N + 2)] for _ in range(N + 2)]
ans = []
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for i in range(1, N + 1):
    temp = input()
    for j in range(1, N + 1):
        graph[i][j] = int(temp[j - 1])

def bfs(a, b):
    queue = deque()
    queue.append((a, b))
    graph[a][b] = 0 #한번 탐색한 것은 다시 방문하지 않도록
    cnt = 1

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))
                cnt += 1
    
    return cnt

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if graph[i][j] == 1:
            ans.append(bfs(i, j))

ans.sort()
print(len(ans))
for i in range(len(ans)):
    print(ans[i])