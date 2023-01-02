import collections

def maxSubsetSum(arr) -> int:
    n = len(arr)
    elements = collections.deque()

    if n == 0 or n == 1: 
        return 0
    
    # lookup table - DP - bottom up approach
    lookup = [None] * n

    # base cases
    lookup[0] = arr[0]
    lookup[1] = max(arr[0], arr[1])

    for i in range(2, n):
        lookup[i] = max(lookup[i-1], lookup[i-2] + arr[i])
        lookup[i] = max(lookup[i-1], arr[i])
        
    print(lookup)
    return lookup[n-1]

arr = [-1, -1, 4, 6, 5]
print(maxSubsetSum(arr))
