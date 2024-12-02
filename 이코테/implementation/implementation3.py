# 왕실의 나이트
import sys
input = sys.stdin.readline

coor = input()

x = ord(coor[0]) - ord('a') + 1
y = int(coor[1])

dx = [-1, -1, 1, 1]
dy = [-1, 1, -1, 1]

ans = 0

for i in range(4):
    nx = x + dx[i] * 2
    ny = y + dy[i]

    if nx < 1 or nx > 8 or ny < 1 or ny > 8:
        continue
    ans += 1

for i in range(4):
    nx = x + dx[i] 
    ny = y + dy[i] * 2

    if nx < 1 or nx > 8 or ny < 1 or ny > 8:
        continue
    ans += 1

print(ans)