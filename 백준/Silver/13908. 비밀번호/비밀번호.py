import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(str, input().split()))
ans = 0

for i in range(10 ** n):
    check = True
    tmp = str(i)
    idx = len(tmp)
    if idx < n:
        tmp = '0' * (n - idx) + tmp
    
    for j in arr:
        if j not in tmp:
            check = False
            break
    
    if check:
        ans += 1

print(ans)