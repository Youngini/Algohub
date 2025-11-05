import sys
input = sys.stdin.readline

baduk = [[0] * 20 for _ in range(20)]
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

for i in range(1, n + 1):
    x, y = arr[i - 1][0], arr[i - 1][1]
    color = 1 if i % 2 == 1 else 2
    baduk[x][y] = color

    # 가로 탐사
    cnt = 1  # 자기 자신 포함
    nx = x - 1
    while nx > 0 and baduk[nx][y] == color:
        cnt += 1
        nx -= 1
    nx = x + 1
    while nx < 20 and baduk[nx][y] == color:
        cnt += 1
        nx += 1
    if cnt == 5:
        print(i)
        break

    # 세로 탐사
    cnt = 1
    ny = y - 1
    while ny > 0 and baduk[x][ny] == color:
        cnt += 1
        ny -= 1
    ny = y + 1
    while ny < 20 and baduk[x][ny] == color:
        cnt += 1
        ny += 1
    if cnt == 5:
        print(i)
        break

    # ↘ 대각선 탐사
    cnt = 1
    nx, ny = x - 1, y - 1
    while nx > 0 and ny > 0 and baduk[nx][ny] == color:
        cnt += 1
        nx -= 1
        ny -= 1
    nx, ny = x + 1, y + 1
    while nx < 20 and ny < 20 and baduk[nx][ny] == color:
        cnt += 1
        nx += 1
        ny += 1
    if cnt == 5:
        print(i)
        break

    # ↗ 대각선 탐사
    cnt = 1
    nx, ny = x - 1, y + 1
    while nx > 0 and ny < 20 and baduk[nx][ny] == color:
        cnt += 1
        nx -= 1
        ny += 1
    nx, ny = x + 1, y - 1
    while nx < 20 and ny > 0 and baduk[nx][ny] == color:
        cnt += 1
        nx += 1
        ny -= 1
    if cnt == 5:
        print(i)
        break

else:
    print(-1)
