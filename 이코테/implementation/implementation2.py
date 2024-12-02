# 시각
import sys
input = sys.stdin.readline

n = int(input())

cnt = 0

for i in range(n + 1):
    if i == 3 or i == 13 or i == 23 :
        cnt += 60 * 60
        continue
    cnt += (15 * 60 + 45 * 15 ) 

print(cnt)