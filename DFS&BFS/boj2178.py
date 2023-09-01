#미로 탐색
from collections import deque
import sys
input = sys.stdin.readline
N, M = map(int, input().split())

maze = [[] for _ in range(N + 2)]
visited = [[False for _ in range(M + 2)] for _ in range(N + 2)]

for i in range(N + 2):
    if(i == 0 or i == N + 1):
        for _ in range(M + 2):
            maze[i].append(0)
    else:
        maze[i].append(0)
        for j in input().strip():
            maze[i].append(int(j))
        maze[i].append(0)

def BFS():
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque()
    queue.append((1,1))
    
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if(maze[nx][ny] == 1 and 0 < nx < N + 1 and 0 < ny < M + 1):
                queue.append((nx, ny))
                maze[nx][ny] = maze[x][y] + 1
        
    return maze
    
maze = BFS()

print(maze[N][M])