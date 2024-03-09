# 전공책
import sys
from math import *
from itertools import *
input = sys.stdin.readline
T = input().strip()
N = int(input())
majors = [input().split() for _ in range(N)]
majors.sort(key=lambda x : (x[0]))
ans = inf # 최소 금액
intersection = [[] for _ in range(N)]
price = [int(major[0]) for major in majors]
i = 0
start = 0

def nCr(n, r):
    if r == 1:
        return
    cnt = comb(n, r)

    for i in range(cnt):

        return

for major in majors:
    for alphabet in T:
        if alphabet in major[1]:
            intersection[i].append(alphabet)
            T.replace(alphabet,'',1)
    i += 1

print(ans)