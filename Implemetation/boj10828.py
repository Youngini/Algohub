#스택
import sys
input = sys.stdin.readline
N = int(input())
stack = []

def push(stack, x):
    stack.append(x)

def pop(stack):
    if(len(stack) == 0):
        print(-1)
    else:
        print(stack.pop())

def size(stack):
    print(len(stack))

def empty(stack):
    if(len(stack) == 0):
        print(1)
    else:
        print(0)

def top(stack):
    if(len(stack) == 0):
        print(-1)
    else:
        print(stack[-1])

for i in range(N):
    temp = [x for x in input().split()]
    if(temp[0] == "push"):
        push(stack, int(temp[1]))
    elif(temp[0] == "pop"):
        pop(stack)
    elif(temp[0] == "size"):
        size(stack)
    elif(temp[0] == "empty"):
        empty(stack)
    else:
        top(stack)