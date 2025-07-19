import sys
input = sys.stdin.readline

N = int(input())
arr = input().strip()
sum = 0

for i in arr:
    sum += int(i)

print(sum)