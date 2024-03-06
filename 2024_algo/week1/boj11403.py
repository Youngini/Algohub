# 경로 찾기
import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[0] * n for _ in range(n)]

def bfs(x): # x는 방문을 시작할 행 번호
    que = deque()
    que.append(x)
    check = [0] * n # 이미 방문한 열은 que에 안넣으려고 확인용

    while que:
        i = que.popleft()

        for j in range(n):
            if check[j] == 0 and graph[i][j] == 1:
                que.append(j)
                check[j] = 1
                visited[x][j] = 1
    
for x in range(n):
    bfs(x)

for route in visited:
    print(*route)
