import sys
input = sys.stdin.readline

cow = [ -1 for _ in range(11)] #현재 위치
N = int(input()) # 관찰 횟수
cnt = 0

for _ in range(N):
    a, b = map(int, input().split())
    # 한번도 이동하지 않은 소 -1
    if cow[a] == -1 : cow[a] = b
    elif cow[a] != b: 
        cow[a] = b
        cnt += 1

print(cnt) 