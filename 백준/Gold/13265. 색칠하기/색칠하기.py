from collections import deque
import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    n, m = map(int, input().split())
    graph = [[] for _ in range(n + 1)]
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    color = [0] * (n + 1)
    possible = True

    for start in range(1, n + 1):
        if color[start] != 0:
            continue
        q = deque([start])
        color[start] = 1
        while q:
            cur = q.popleft()
            for nxt in graph[cur]:
                if color[nxt] == 0:
                    color[nxt] = -color[cur]
                    q.append(nxt)
                elif color[nxt] == color[cur]:
                    possible = False
                    break
            if not possible:
                break
        if not possible:
            break

    print("possible" if possible else "impossible")
