#1,2,3 더하기
import sys
input = sys.stdin.readline
T = int(input())
n = [int(input()) for _ in range(T)]

arr = [0 for _ in range(12)]
arr[1] = 1
arr[2] = 2
arr[3] = 4

for i in range(4, 12):
    arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3]

for i in n:
    print(arr[i])