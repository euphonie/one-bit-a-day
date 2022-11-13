


def solution(n:int) -> str:

    S = {}
    solution = []
    S['('] = (1,0)
    while True:
        if len(S.keys()) == 0:
            break
        str, tup = S.popitem()
        o, c = tup
        if o == n:
            if c == n:
                solution.append(str)
                continue
            else:
                S[str+')'] = (o, c+1)
        elif o == c:
            S[str+'('] = (o+1, c)
        else:
            S[str+'('] = (o+1, c)
            S[str+ ')'] = (o, c+1)
    return solution


print(solution(2))
