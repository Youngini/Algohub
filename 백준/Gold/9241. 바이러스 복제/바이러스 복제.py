import sys
input = sys.stdin.readline

DNA1 = input().strip()
DNA2 = input().strip()

n1 = len(DNA1)
n2 = len(DNA2)

# 앞에서 부터
i = 0
s = 0
while(i < n1 and i < n2 and DNA1[i] == DNA2[i]):
    i += 1
    s += 1

# 뒤에서 부터
i = 1
e = 0
while(i < n1 and i < n2 and DNA1[n1 - i] == DNA2[n2 - i]):
    i += 1
    e += 1

ans = n2 - (s + e)

if s >= min(n1, n2) - e:
    # 겹침 (즉, 삽입 없음)
    if n1 > n2:
        print(0)
    else:
        print(n2 - n1)
else:
    print(ans)