#파도반 수열
import sys
input = sys.stdin.readline
n = int(input())
arr = [int(input()) for _ in range(n)]

P = [0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9]

for i in range(11, 101):
    P.append(P[i - 1] + P[i - 5])
for i in arr:
    print(P[i])
    