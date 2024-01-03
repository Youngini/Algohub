#트리의 부모 찾기
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
N = int(input())
graph = [[] for _ in range(N + 1)]
parents = [0 for i in range(N + 1)]

for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(v):
    for i in graph[v]:
        if not parents[i]:
            parents[i] = v
            dfs(i)

dfs(1)

for i in range(2, N + 1):
    print(parents[i])