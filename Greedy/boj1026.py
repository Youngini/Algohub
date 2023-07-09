#보물
import sys
input = sys.stdin.readline
n = int(input())
A = [int(x) for x in input().split()]
B = [int(x) for x in input().split()]

copy_B = [ x for x in B]
re_A = [0 for _ in range(n)]

for i in range(n):
    b = -1
    index = 0
    for j in range(n):
        if(b < copy_B[j]):
            b = copy_B[j]
            index = j
    copy_B[index] = -1
    re_A[index] = min(A)
    A.remove(min(A))

ans = 0
for i in range(n):
    ans += B[i] * re_A[i]

print(ans)