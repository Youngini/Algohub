import sys
iput = sys.stdin.readline

N, M= map(int, input().split()) # 전구의 개수, 명령어의 개수
state = list(map(int, input().split()))

for _ in range(M):
    a, b ,c = map(int, input().split())
    if(a == 1) : state[b - 1] = c
    elif(a == 2) : 
        for i in range(b - 1, c):
            state[i] = (state[i] + 1) % 2
    elif(a == 3):
        for i in range(b - 1, c):
            state[i] = 0
    else:
        for i in range(b - 1, c):
            state[i] = 1

for i in state:
    print(i, end = " ")