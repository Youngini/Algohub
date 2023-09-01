#바이러스
from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
computer = [[] for _ in range(N + 1)]

for i in range(M):
    x, y = map(int, input().split())
    computer[x].append(y)
    computer[y].append(x)

for i in range(1, N + 1):
    computer[i].sort()

visited = [False for _ in range(N + 1)]
def BFS():
    queue = deque()
    queue.append(1) 
    infection = 0
    visited[1] = True
    while queue:
        x = queue.popleft()
        for i in computer[x]:
            if(visited[i] == False):
                visited[i] = True
                queue.append(i)
                infection += 1
    print(infection)

BFS()