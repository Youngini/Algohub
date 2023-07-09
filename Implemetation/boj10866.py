#덱
import sys
input = sys.stdin.readline
N = int(input())
stack = []

def push_front(stack, x):
    stack.insert(0, x)

def push_back(stack, x):
    stack.append(x)

def pop_front(stack):
    if(len(stack) == 0):
        print(-1)
    else:
        print(stack[0])
        stack.remove(stack[0])

def pop_back(stack):
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

def front(stack):
    if(len(stack) == 0):
        print(-1)
    else:
        print(stack[0])

def back(stack):
    if(len(stack) == 0):
        print(-1)
    else:
        print(stack[-1])

for i in range(N):
    command = [x for x in input().split()]
    if(command[0] == "push_front"):
        push_front(stack, int(command[1]))
    elif(command[0] == "push_back"):
        push_back(stack, int(command[1]))
    elif(command[0] == "pop_front"):
        pop_front(stack)
    elif(command[0] == "pop_back"):
        pop_back(stack)
    elif(command[0] == "size"):
        size(stack)
    elif(command[0] == "empty"):
        empty(stack)
    elif(command[0] == "front"):
        front(stack)
    elif(command[0] == "back"):
        back(stack)
    
