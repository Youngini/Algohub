import sys
input = sys.stdin.readline

w, h = map(int, input().split())
p, q = map(int, input().split())
t = int(input())

# x축 계산
nx = (p + t) % (2 * w)
if nx > w:
    nx = 2 * w - nx

# y축 계산
ny = (q + t) % (2 * h)
if ny > h:
    ny = 2 * h - ny

print(nx, ny)