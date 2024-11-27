import sys
input = sys.stdin.readline

money = int(input())

cnt = 0

coin_type = [500, 100, 50, 10]

for i in range(len(coin_type)):
    cnt += money // coin_type[i]
    money = money % coin_type[i]

print(cnt)