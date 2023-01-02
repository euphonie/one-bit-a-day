

def solution(A:list) -> int:
    """
        Dominant number: is a number that occurs more than half of the size of the array
    """
    A.sort()
    (count, max_ele, candidate, found) = [1, -100, A[0], False]
    for i in range(1, len(A)):

        if (candidate == A[i]): 
            count += 1
        else: 
            count = 1
            candidate = A[i]
        
        if (max_ele < count): 
            max_ele = count
            ele = A[i]

            if (max_ele > (len(A)//2)):
                found = True
                break
    
    return ele if found else -1



A:list = [3,4,3,2,3,-1,3,3]
print(solution(A))