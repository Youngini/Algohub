import sys
from decimal import Decimal, getcontext

input = sys.stdin.readline

a_str, b_str = input().split()
b = int(b_str)

getcontext().prec = len(a_str) * abs(b) + 10

a = Decimal(a_str)
ans = a ** b

ans_str = format(ans, 'f').rstrip('0').rstrip('.')
print(ans_str)