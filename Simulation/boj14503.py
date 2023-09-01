#로봇 청소기
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
r, c, d = map(int, input().split())

room = [[int(x) for x in input().split()] for _ in range(N)]
visited = [[0 for _ in range(M)] for _ in range(N)]
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]  
cnt = 1
visited[r][c] = 1

while(1):
    bool = 0
    for _ in range(4):
        d = (d + 3) % 4
        nr = r + dr[d]
        nc = c + dc[d]

        if 0 <= nr < N and 0 <= nc < M and room[nr][nc] == 0:
            if visited[nr][nc] == 0:
                visited[nr][nc] = 1
                r = nr
                c = nc
                cnt += 1
                bool = 1
                break

    if(bool == 0):
        nr = r - dr[d]
        nc = c - dc[d]
        if(room[nr][nc] == 1):
            break
        else:
            r = nr
            c = nc

print(cnt)