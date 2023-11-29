#집합의 연산
import sys
input = sys.stdin.readline

n,m = map(int, input().split())
command = [[int(x) for x in input().split()] for _ in range(m)]
parent = [[i for i in range(n + 1)] for _ in range(n + 1)]

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    
    return parent[x]

def union(x,y):
    a = find(x)
    b = find(y)

    if a < b:
        parent[a] = b
    else:
        parent[b] = a

for i in range(m):
    if command[i][0] == 0:
        union(command[i][1], command[i][2])
    else:
        a = find(command[i][1])
        b = find(command[i][2])
        if(a == b):
            print("YES")
        else:
            print("No")