#잃어버린 괄호
import sys
input = sys.stdin.readline
form = input().replace("\n", "").split("-")
n = []

if(len(form) == 1):
    temp = form[0].split("+")
    n = map(int, temp)
    ans = sum(n)

else:
    for i in form:
        temp = i.split("+")
        if(len(temp) == 1):
            n.append(int(temp[0]))
        else:
            ans = 0
            for j in temp:
                ans += int(j)
            n.append(ans)
    ans = 2*n[0] - sum(n)

print(ans)