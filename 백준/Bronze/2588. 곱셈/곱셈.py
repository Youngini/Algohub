import sys
input = sys.stdin.readline

a = int(input())
b = int(input())

ans1 = a * (b % 10)
ans2 = a * ((b % 100) // 10)
ans3 = a * ((b % 1000) // 100)
ans4 = a * b

print(ans1)
print(ans2)
print(ans3)
print(ans4)