import sys
input = sys.stdin.readline

N, C = map(int, input().split())
weights = [int(i) for i in input().split()]
weights.sort()


def possible():
    # 1️⃣ 물건 한 개
    if C in weights:
        return True

    # 2️⃣ 물건이 두 개
    l, r = 0, N - 1
    while l < r:
        tmp = weights[l] + weights[r]
        if tmp == C:
            return True
        elif tmp < C:
            l += 1
        else:
            r -= 1

    # 3️⃣ 물건이 세 개
    for i in range(N):
        if weights[i] > C:
            break
        l, r = i + 1, N - 1
        while l < r:
            tmp = weights[i] + weights[l] + weights[r]
            if tmp == C:
                return True
            elif tmp < C:
                l += 1
            else:
                r -= 1

    return False


print(1 if possible() else 0)
