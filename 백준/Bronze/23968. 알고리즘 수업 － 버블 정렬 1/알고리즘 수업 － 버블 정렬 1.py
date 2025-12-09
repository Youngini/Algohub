import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))
cnt = 0

for i in range(N, 0, -1):
    a = arr[0]
    for j in range(1, i):
        b = arr[j]
        if(a > b):
            cnt += 1
            arr[j] = a
            arr[j - 1] = b
            if(cnt == K):
                print(b, a)
        else:
            a = arr[j]

if cnt < K:
    print(-1)