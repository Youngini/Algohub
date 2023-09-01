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
