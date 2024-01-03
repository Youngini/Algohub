# 집합의 표현
import sys
sys.setrecursionlimit(10**6) # 파이썬 Recursion Error 피하려고
input = sys.stdin.readline
n, m = map(int, input().split())
Set = [i for i in range(n + 1)]

def root(t):
    if Set[t] == t:
        return t
    # 시간초과 안뜨려면 root 찾을 때 root 바로바로 업데이트 해서 tree 깊이 낮추기
    r = root(Set[t])
    Set[t] = r
    return Set[t]

def union(a, b):
    r1 = root(a)
    r2 = root(b)

    if r1 == r2:
        return
    elif r1 > r2:
        Set[r1] = r2
    elif r2 > r1:
        Set[r2] = r1

for _ in range(m):
    op, a, b = map(int, input().split())
    if op == 0: # 합집합
        union(a, b)
    else: # 같은 집합인지 확인하기
        if(root(a) == root(b)):
            print("yes")
        else:
            print("no")