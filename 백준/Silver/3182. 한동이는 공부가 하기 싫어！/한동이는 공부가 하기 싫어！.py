import sys
input = sys.stdin.readline

N = int(input())
arr = [0] + [int(input()) for _ in range(N)]
cycle = [ [] for _ in range(N + 1)]
M = 0
ans = 1

for i in range(1, N + 1):
    idx = i
    while(1):
        tmp = arr[idx]
        if tmp not in cycle[i] and tmp != i:
            cycle[i].append(tmp)
            idx = tmp
        else:
            break

for i in range(1, N + 1):
    if(M < len(cycle[i])):
        M = len(cycle[i])
        ans = i

print(ans)