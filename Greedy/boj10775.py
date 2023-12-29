#공항
import sys
input = sys.stdin.readline
G = int(input())
P = int(input())
airplane = [int(input()) for x in range(P)]
gate = [i for i in range(G + 1)]

def root(g):
    if gate[g] == g:
        return g
    gate[g] = root(gate[g])
    return root(gate[g])

def union(a, b):
    a,b = root(a), root(b)
    gate[b] = a
ans = 0

for i in airplane:
    plane = root(gate[i])
    if plane == 0:
        break
    union(plane-1, plane)
    ans += 1 

print(ans)