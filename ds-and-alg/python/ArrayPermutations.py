
def solution(a: list, l:int, r : int) -> list:
    perms = []
    if l==r:
        perms.append(a[:])
    else: 
        for i in range(l, r):
            a[l], a[i] = a[i], a[l]
            perms = perms + solution(a, l+1, r)
            a[l], a[i] = a[i], a[l] # backtrack
    return perms

s:str = "ABC"
n = len(s)
a = list(s)
print(solution(a, 0, n))

ns:list = [1,2,6,7,4]
print(solution(ns, 0, len(ns)))