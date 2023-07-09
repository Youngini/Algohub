#계단 오르기
import sys
input = sys.stdin.readline
n = int(input())
stairs = [int(input()) for _ in range(n)]

arr = [[stairs[0], 0]]
if(n >= 2):
    arr.append([stairs[1], arr[0][0] + stairs[1]])
    for i in range(2, n):
        arr.append([max(arr[i - 2]) + stairs[i], arr[i - 1][0] + stairs[i]])

print(max(arr[n - 1]))