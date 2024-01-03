#인구이동
import sys
input = sys.stdin.readline
N, L, R = map(int, input().split())
countries = []
check = [[0] * N] * N
for i in range(N):
    temp = [int(x) for x in input().split()]
    countries.append(temp)

def up_down_left_right(a, b):
    if(a == N -1 and b == N - 1):
        return
    if(b == N - 1):
        sub = abs(countries[a][b] - countries[a + 1][b])
