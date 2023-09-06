## Disjoint Set
: 서로 중복되지 않는 부분 집합들로 나누어진 원소들에 대한 정보를 저장하고 조작하는 자료 구조
=> 서로소 집합 자료 구조

## Union-find

1. union-find 란?<br>
: disjoint set을 표현하기 위해 사용하는 알고리즘<br>
노드들을 합치고(union), 부모를 찾고(find), 서로소 집합(disjoint set)을 찾아내는 알고리즘 <br>
ex) 비트 벡터, 배열, 연결 리스트, **트리 구조**<br><br>
2. union-find의 연산<br>
(1) union(x, y) <br>
   : x가 속한 집합과 y가 속한 집합을 합침 <br><br>
(2)find(x) <br>
   : x가 속한 집합의 대표값(루트 노드 값)을 반환한다. 즉, x가 어떤 집합에 속해 있는지 찾는 연산 <br> <br>
3. union-find code <br>
   ```python
   int root[MZX_SIZE]
   parent = [i for i in range(MAX_SIZE)]

   #union(x, y)
   def union(x,y):
     a = find(a)
     b = find(b)

     if(a < b):
       parent[a] = b
     else:
       parent[b] = a

   #find(x)
   def find(x):
     if parent[x] != x:
       parent[x] = find(parent[x])
   
     return parent[x]

   ```

   ## BOJ 문제 추천
   |순 번|문제 번호|문제 이름|풀 이|
   |---|---|---|---|
   |01|[1717](https://www.acmicpc.net/problem/1717)|[집합의 표현](https://www.acmicpc.net/problem/1717)||
   |02|[1976](https://www.acmicpc.net/problem/1976)|[여행 가자](https://www.acmicpc.net/problem/1976)||
   |03|[16562](https://www.acmicpc.net/problem/16562)|[친구비](https://www.acmicpc.net/problem/16562)||
   |04|[18116](https://www.acmicpc.net/problem/18116)|[로봇 조립](https://www.acmicpc.net/problem/18116)||
   |05|[4195](https://www.acmicpc.net/problem/4195)|[친구 네트워크](https://www.acmicpc.net/problem/4195)||
   |06|[10775](https://www.acmicpc.net/problem/10775)|[공항](https://www.acmicpc.net/problem/10775)||
   |07|[17352](https://www.acmicpc.net/problem/17352)|[여러분의 다리가 되어 드리겠습니다!](https://www.acmicpc.net/problem/17352)||
   |08|[7511](https://www.acmicpc.net/problem/7511)|[소셜 네트웨킹 어플리케이션](https://www.acmicpc.net/problem/7511)||
   |09|[20040](https://www.acmicpc.net/problem/20040)|[사이클 게임](https://www.acmicpc.net/problem/20040)||
   |10|[12893](https://www.acmicpc.net/problem/12893)|[적의 적](https://www.acmicpc.net/problem/12893)||
   |11|[1043](https://www.acmicpc.net/problem/1043)|[거짓말](https://www.acmicpc.net/problem/1043)||
   |12|[16168](https://www.acmicpc.net/problem/16168)|[퍼레이드](https://www.acmicpc.net/problem/16168)||
   |13|[20955](https://www.acmicpc.net/problem/20995)|[민서의 응급 수술](https://www.acmicpc.net/problem/20995)||
   |14|[15789](https://www.acmicpc.net/problem/15789)|[CTP 왕국은 한솔 왕국을 이길 수 있을까?](https://www.acmicpc.net/problem/15789)||
   |15|[11085](https://www.acmicpc.net/problem/11085)|[군사 이동](https://www.acmicpc.net/problem/11085)||
   |16|[17090](https://www.acmicpc.net/problem/17090)|[미로 탈출하기](https://www.acmicpc.net/problem/17090)||
   |17|[16724](https://www.acmicpc.net/problem/16724)|[피리 부는 사나이](https://www.acmicpc.net/problem/16724)||
   |18|[14595](https://www.acmicpc.net/problem/14595)|[동방 프로젝트 (Large)](https://www.acmicpc.net/problem/14595)||
   |19|[3108](https://www.acmicpc.net/problem/3108)|[로고](https://www.acmicpc.net/problem/3108)||
   |20|[17398](https://www.acmicpc.net/problem/17398)|[통신망 분할](https://www.acmicpc.net/problem/17398)||
   
