#dfs와 bfs
from collections import deque
import sys
input = sys.stdin.readline

def DFS(graph, V, visited):
    visited[V] = True
    print(V, end = ' ')

    for i in graph[V]:
        if(visited[i] == False):
            DFS(graph, i, visited)

def BFS(graph, V, visited):
    queue = deque([V])
    visited[V] = True

    while queue:
        v = queue.popleft()
        print(v, end = ' ')
    
        for i in graph[v]:
            if(visited[i] == False):
                queue.append(i)
                visited[i] = True

N, M, V = map(int, input().split())
graph = [[] for _ in range(N + 1)]
visited1 = [False] * (N + 1)
visited2 = [False] * (N + 1)

for _ in range(M):
    i, j = map(int, input().split())
    graph[i].append(j)
    graph[j].append(i)

for i in graph:
    i.sort()

DFS(graph, V, visited1)
print()
BFS(graph, V, visited2)
