import random

def solution(A: list) -> int:
    '''
        Find if edges can form a non-degenerate triangle.
        Conditions: 
            1. A + B > C
            2. B + C > A
            3. C + A > B
        When array is sorted, 2 and 3 can be omitted. 
    '''
    A.sort()
    B:list = A
    i = 0
    edges = []
    while i < len(B) -2 :
        if B[i] + B[i+1] > B[i+2]: 
            return 1
        i += 1
    return 0

# Driver code
A: list = [10, 2, 5, 1, 8, 20]
print(solution(A))

N: int = 1000
A2: list = [random.randint(1, N) for x in range(4)]
print(solution(A2))
