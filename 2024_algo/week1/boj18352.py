from collections import deque
import sys
input = sys.stdin.readline
N, M, K, X = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b) 

visited = [False] * (N + 1)
distance = [0] * (N + 1)

def bfs(start):
    ans = []
    que = deque([start])
    visited[start] = True

    while que:
        cur = que.popleft()
        for i in graph[cur]:
            if not visited[i]:
                visited[i] = True
                que.append(i)
                distance[i] = distance[cur] + 1
                if distance[i] == K:
                    ans.append(i)
    
    if len(ans) == 0:
        print(-1)
    else:
        ans.sort()
        for i in ans:
            print(i)

bfs(X)
