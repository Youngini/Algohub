import sys
input = sys.stdin.readline

N, HP = map(int, input().split())
cool = []
dmg = []

for _ in range(N):
    c, d = map(int, input().split())
    cool.append(c)
    dmg.append(d)

answer = float('inf')

def dfs(time, hp, cd):
    global answer
    
    # 몬스터 처치 완료
    if hp <= 0:
        answer = min(answer, time)
        return
    
    # 이미 최적해보다 오래 걸림 → 가지치기
    if time >= answer:
        return
    
    used_skill = False
    
    # 사용 가능한 모든 스킬 시도
    for i in range(N):
        if cd[i] == 0:        # 사용 가능
            used_skill = True

            new_cd = cd[:]    # 쿨타임 복사
            new_hp = hp - dmg[i]

            new_cd[i] = cool[i]  # 스킬 사용 → 쿨타임 설정

            # 1초 흐름 → 모든 쿨타임 감소
            for j in range(N):
                if new_cd[j] > 0:
                    new_cd[j] -= 1

            dfs(time + 1, new_hp, new_cd)

    # 스킬을 아무것도 못 쓰면 1초 기다리기
    if not used_skill:
        new_cd = cd[:]
        for j in range(N):
            if new_cd[j] > 0:
                new_cd[j] -= 1
        dfs(time + 1, hp, new_cd)


# 초기 쿨타임은 모두 0
dfs(0, HP, [0] * N)

print(answer)
