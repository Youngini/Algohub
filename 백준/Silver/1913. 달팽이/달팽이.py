import sys
input = sys.stdin.readline

N = int(input())
find = int(input())

arr = [[0] * N for _ in range(N)] 
dx = [-1, 0, 1, 0]# 상하좌우
dy = [0, 1, 0, -1] # 상하좌우

x = N // 2
y = N // 2
k = - 1

n = 1 # 한 방향으로 이동하는 칸 개수
cnt = 1 # 한 방향으로 이동한 횟수

for i in range(1, N * N + 1):
    arr[x][y] = i

    if(i == find):
        ans = [x + 1, y + 1]

    cnt += 1
    if(i == n * n):
        n += 1 # 이동하는 칸 갯수
    
    if(cnt == n):
        cnt = 1
        k = (k + 1) % 4
    
    x = x + dx[k]
    y = y + dy[k]

for i in range(N):
    for j in range(N):
        print(arr[i][j], end = " ")
    print()
    
print(ans[0], ans[1])