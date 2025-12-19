import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

K = int(input())
edges = [0] + list(map(int, input().split()))  # 1-indexed
ans = 0

# leaf 노드의 마지막 번호
leaf_start = 1 << K  # 2^K
leaf_end = (1 << (K+1)) - 1  # 2^(K+1)-1

def dfs(node):
    global ans

    # leaf 노드라면 경로 비용 0 리턴
    if node >= leaf_start:
        return 0

    # 간선 인덱스
    left_edge = edges[2 * node - 1]
    right_edge = edges[2 * node]

    # 자식 노드
    left = dfs(node * 2) + left_edge
    right = dfs(node * 2 + 1) + right_edge

    # 부족한 만큼 보정
    ans += abs(left - right)

    return max(left, right)

dfs(1)
print(sum(edges) + ans)