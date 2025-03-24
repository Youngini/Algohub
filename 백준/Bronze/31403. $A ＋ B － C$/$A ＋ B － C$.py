import sys
input = sys.stdin.readline

a = input().strip()
b = input().strip()
c = input().strip()

ans1 = int(a) + int(b) - int(c)
ans2 = int(a + b) - int(c)

print(ans1)
print(ans2)