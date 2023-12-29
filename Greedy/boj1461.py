#도서관
import sys
input = sys.stdin.readline
N, M = map(int, input().split())
locations = [int(x) for x in input().split()]
minus_loca = []
plus_loca = []
steps = 0

for i in locations:
    if(i < 0): minus_loca.append(i * -1)
    else: plus_loca.append(i)
minus_loca.sort(reverse = True) # 오름차순 정렬
plus_loca.sort(reverse = True) # 내림차순 정렬

def find_step(loca):
    list = []
    for i in range(0, len(loca), M):
        list.append(loca[i])
    return list

minus_step = find_step(minus_loca)
plus_step = find_step(plus_loca)

# case1 : 음수 위치가 없음
if(len(minus_step) == 0):
    steps += plus_step.pop(0) # 멈추는 위치
    steps += sum(plus_step) * 2

# case2 : 양수 위치가 없음
elif(len(plus_step) == 0):
    steps += minus_step.pop(0) # 멈추는 위치
    steps += sum(minus_step) * 2

# case3 : 둘 다 있음
else:
    # 멈추는 위치는 음수 양수 중 더 큰 쪽으로 함
    if(minus_step[0] > plus_step[0]):
        steps += minus_step.pop(0)
    else:
        steps += plus_step.pop(0)

    # 남은 위치들은 왕복하기 때문에 2배를 해줌
    steps += (sum(plus_step) + sum(minus_step)) * 2

print(steps)


