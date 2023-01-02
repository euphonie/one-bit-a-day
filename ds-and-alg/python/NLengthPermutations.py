
def get_lth_based(i: int, a: list, n: int, l:int) -> list:
    perms = []
    for i in range(l):
        perms.append(a[i%n])
        i //= n
    return perms



def solution(a: list, n: int, l: int) -> list:
    perms = []
    for i in range(pow(n, l)):
        perms.append(get_lth_based(i, a, n, l))
    return perms


a:list = [1,2,3]
n = len(a)
l = 2
print(solution(a, n, l))