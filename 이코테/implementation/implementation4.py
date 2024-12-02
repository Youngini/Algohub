# 게임 게발
import sys
input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

n, m = map(int, input().split())
x, y, d = map(int, input().split())

check = [[0] * m for _ in range(n)]
check[x][y] = 1

game = [list(map(int, input().split())) for _ in range(n)]

def turn_letf():
    global d
    d = (d + 3) % 4

cnt = 1
turn_time = 0

while True:
    turn_letf()
    nx = x + dx[d]
    ny = y + dy[d]

    if check[nx][ny] == 0 and game[nx][ny] == 0:
        check[nx][ny] = 1
        x = nx
        y = ny
        cnt += 1
        turn_time = 0
        continue

    else : 
        turn_time += 1
    
    if turn_time == 4:
        nx = x - dx[d]
        ny = y - dy[d]

        if game[nx][ny] == 0:
            x = nx
            y = ny
        else:
            break
        turn_time = 0

print(cnt)