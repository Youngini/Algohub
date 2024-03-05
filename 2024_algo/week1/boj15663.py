import sys
input = sys.stdin.readline
n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

visited = [False] * n
ans = []

def dfs():
    if len(ans) == m:
        print(*ans)
        return
    temp = 0
    for i in range(n):
        if not visited[i] and temp != arr[i]:
            visited[i] = True
            ans.append(arr[i])
            temp = arr[i]
            dfs()
            visited[i] = False
            ans.pop()

dfs()