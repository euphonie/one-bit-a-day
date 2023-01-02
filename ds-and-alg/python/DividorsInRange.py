

def solution(A, B, K): 
    if A % K == 0:
        return (B//K) - (A//K) + 1
    return (B//K) - (A//K)

def solution2(A: int, B: int, K: int) -> int:
    return ((B//K) - (A//K)) + (1 if A % K == 0 else 0)

A:int = 10
B:int = 11
K:int = 2

print(solution(A, B, K), solution2(A, B, K))