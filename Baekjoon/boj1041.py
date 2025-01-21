import sys
input = sys.stdin.readline

n = int(input())
dice = list(map(int, input().split()))
min_dice = [min(dice[0],  dice[5]), min(dice[1], dice[4]), min(dice[2], dice[3])]
min_dice.sort()

m3 = sum(min_dice)
m2 = sum(min_dice[:2])
m1 = min_dice[0]

if n == 1 :
    ans = sum(dice) - max(dice)
elif n == 2 :
    ans = 4 * m3 + 4 * m2
else :
    ans = 4 * m3 + (8*n - 12) * m2 + (5*n*n - 16*n + 12) * m1

print(ans)