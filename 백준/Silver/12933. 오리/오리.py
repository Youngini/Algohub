import sys
input = sys.stdin.readline

ori = "quack"
sound = input().strip()

if len(sound) % 5 != 0:
    print(-1)
    sys.exit()

# 오리 상태리스트: 각 오리가 지금 quack 문자열에서 어느 단계인지
ducks = []

for ch in sound:
    idx = ori.index(ch)
    placed = False

    if idx == 0:
        # 'q'인 경우: 끝난 상태(4)을 재사용 가능
        for i in range(len(ducks)):
            if ducks[i] == 4:
                ducks[i] = 0
                placed = True
                break
        if not placed:
            ducks.append(0)
            placed = True
    else:
        # 'quack'의 다음 단계에 있어야만 해당 문자 처리 가능
        for i in range(len(ducks)):
            if ducks[i] == idx - 1:
                ducks[i] = idx
                placed = True
                break

    if not placed:
        # 어떤 오리도 이 문자를 처리할 수 없음 → 오류
        print(-1)
        sys.exit()

# 문자열 끝난 이후 모두 quack 완성 상태(4)여야 함
for state in ducks:
    if state != 4:
        print(-1)
        sys.exit()

print(len(ducks))
