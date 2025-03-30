import sys
input = sys.stdin.readline

a, b, c = map(int, input().split())
reward = 0

if(a == b and b == c) :
    reward = 10000 + a * 1000
elif (a != b and b != c and c != a):
    reward = max(a, b, c) * 100
elif (a == b or a == c):
    reward = 1000 + a * 100
elif (b == c):
    reward = 1000 + b * 100

print(reward)