# 전공책
import sys
input = sys.stdin.readline
T = input().strip()
N = int(input())
majors = [input().split() for _ in range(N)]
majors.sort(key=lambda x : (x[0]))
ans = 100001
intersection = [[] for _ in range(N)]
i = 0
for major in majors:
    print(major)
    for alphabet in T:
        if alphabet in major[1]:
            intersection[i].append(alphabet)
    i += 1

for i in range(N):
    temp = 0 # 가격 임시 저장
    find = set(list(T)) - set(intersection[i])
    temp += int(majors[i][0])
    while len(find) != 0:
        for j in range(N):
            if i == j:
                continue
            tmp = find - set(intersection[j])
            if find - tmp != None:
                temp += int(majors[j][0])
                find = tmp
    ans = min(ans, temp)

print(ans)

