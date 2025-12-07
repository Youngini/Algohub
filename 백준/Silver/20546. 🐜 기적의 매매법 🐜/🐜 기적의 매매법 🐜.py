import sys
input = sys.stdin.readline

money = int(input())
stocks = list(map(int, input().split()))

# BNP
jun_money = money
jun_stock = 0

for i in range(14):
    jun_stock += jun_money // stocks[i]
    jun_money = jun_money % stocks[i]

jun_total = jun_money + jun_stock * stocks[-1]

# TIMING
sung_money = money
sung_stock = 0
up = 0
down = 0

for i in range(1, 14):
    if(stocks[i] > stocks[i - 1]):
        up += 1
        down = 0
    elif(stocks[i] < stocks[i - 1]):
        down += 1
        up = 0
    else:
        up = 0
        down = 0
    
    if(up > 2):
        sung_money += sung_stock * stocks[i]
        sung_stock = 0
    
    if(down > 2):
        sung_stock += sung_money // stocks[i]
        sung_money = sung_money % stocks[i]

sung_total = sung_money + sung_stock * stocks[-1]

if jun_total > sung_total: print("BNP")
elif jun_total == sung_total : print("SAMESAME")
else : print("TIMING")