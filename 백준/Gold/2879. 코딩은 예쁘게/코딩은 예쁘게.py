import sys
input = sys.stdin.readline

n = int(input())
arr1 = list(map(int, input().split())) + [0]
arr2 = list(map(int, input().split())) + [0]

ans = 0
diff = []

for i in range(n + 1):
    diff.append(arr2[i] - arr1[i])

while(1):
    if min(diff) == 0 and max(diff) == 0:
        break
    m = 100
    s = 0
    e = -1

    for i in range(n):
        
        # 0인 경우
        if diff[i] == 0:
            s = i + 1
        
        # 부호가 다른 경우
        elif diff[i] * diff[i + 1] <= 0:
            m = min(m, abs(diff[i]))
            ans += m
            e = i + 1
            if diff[i] > 0:
                for j in range(s, e):
                    diff[j] -= m
            else:
                for j in range(s, e):
                    diff[j] += m
                
            m = 100
            s = i + 1



        # 부호가 같은 경우
        else:
            m = min(m, abs(diff[i]))


print(ans)