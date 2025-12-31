import sys
input = sys.stdin.readline

INF = 10**15  # 충분히 큰 값

# 1) 입력
N, R = map(int, input().split())
city_names = input().split()
# 중복 있는 경우 같은 도시로 처리
# map으로 이름 -> 인덱스 매핑
name_to_idx = {}
idx = 0
for city in city_names:
    if city not in name_to_idx:
        name_to_idx[city] = idx
        idx += 1
N = len(name_to_idx)

M = int(input())
trip_list = input().split()

K = int(input())

# 2) 거리 배열 초기화
dist_no_ticket = [[INF]*N for _ in range(N)]
dist_ticket = [[INF]*N for _ in range(N)]
for i in range(N):
    dist_no_ticket[i][i] = 0
    dist_ticket[i][i] = 0

# 3) 교통 정보 입력
for _ in range(K):
    type_, s, e, cost = input().split()
    cost = int(cost)
    
    u = name_to_idx[s]
    v = name_to_idx[e]
    
    # 일반 거리
    dist_no_ticket[u][v] = min(dist_no_ticket[u][v], cost)
    dist_no_ticket[v][u] = min(dist_no_ticket[v][u], cost)
    
    # 티켓 적용 거리
    if type_ in ["Mugunghwa", "ITX-Saemaeul", "ITX-Cheongchun"]:
        new_cost = 0
    elif type_ in ["S-Train", "V-Train"]:
        new_cost = cost / 2
    else:
        new_cost = cost
    
    dist_ticket[u][v] = min(dist_ticket[u][v], new_cost)
    dist_ticket[v][u] = min(dist_ticket[v][u], new_cost)

# 4) 플로이드-워셜 (All pairs shortest paths)
for k in range(N):
    for i in range(N):
        for j in range(N):
            dist_no_ticket[i][j] = min(dist_no_ticket[i][j],
                                      dist_no_ticket[i][k] + dist_no_ticket[k][j])
            dist_ticket[i][j] = min(dist_ticket[i][j],
                                    dist_ticket[i][k] + dist_ticket[k][j])

# 5) 여행 경로 비용 계산
cost_no = 0
cost_ticket = R  # 티켓 가격 포함

for i in range(M-1):
    u = name_to_idx[trip_list[i]]
    v = name_to_idx[trip_list[i+1]]
    cost_no += dist_no_ticket[u][v]
    cost_ticket += dist_ticket[u][v]

# 6) 비교 & 출력
if cost_ticket < cost_no:
    print("Yes")
else:
    print("No")
