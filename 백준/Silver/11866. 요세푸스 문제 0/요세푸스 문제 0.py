from collections import deque

n, k = map(int, input().split())
dq = deque(range(1, n+1))
answer = []

while dq:
    dq.rotate(-(k-1))   # 왼쪽으로 k-1 만큼 회전
    answer.append(dq.popleft())

print("<" + ", ".join(map(str, answer)) + ">")
