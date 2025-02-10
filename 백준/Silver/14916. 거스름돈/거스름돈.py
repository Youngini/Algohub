import sys
input = sys.stdin.readline

n = int(input())
ans = 0
while(n >= 2):
    if (n % 5 == 0):
        ans += n // 5
        n %= 5
        break
    ans += 1
    n -= 2

if n != 0 :
    print(-1)
else:
    print(ans)