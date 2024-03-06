#후보 추천하기
from heapq import *
import sys
input = sys.stdin.readline
N = int(input())
total = int(input())
recommends = list(map(int, input().split()))
ans = {}

for recom in recommends:
    if recom not in ans:
        if len(ans) >= N:
            a = nsmallest(min(ans), ans, key = ans.get)
            ans.pop(a[0])
        
        ans[recom] = 1
    else:
        ans[recom] += 1

print(*sorted(ans.keys()))