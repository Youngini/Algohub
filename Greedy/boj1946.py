#신입 사원
import sys
input = sys.stdin.readline
N = int(input())

def passnum(arr, n):
    arr.sort(key = lambda x : x[0])
    count = 0
    min = n + 1
    for i in range(n):
        if arr[i][1] < min:
            min = arr[i][1]
            count += 1
    print(count)

for i in range(N):
    n = int(input())
    arr = [[int(x) for x in input().split()] for _ in range(n)]
    passnum(arr, n)