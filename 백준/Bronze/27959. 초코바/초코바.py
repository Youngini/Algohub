import sys
input = sys.stdin.readline

n, m = map(int, input().split())

if(m > n * 100) : print("No")
else : print("Yes")