
def printMatrix(M):
    for row in M:
        print(' '.join(map(str, row)))

def lcs(X, Y):
    m = len(X)
    n = len(Y)

    L = [[None] * (n+1) for i in range(m+1)]
    print(L)
    for i in range(m+ 1):
        for j in range(n+1):
            
            if i == 0 or j == 0:
                L[i][j] = 0
            elif X[i-1] == Y[j-1]:
                L[i][j] = L[i-1][j-1]+1
            else:
                L[i][j] = max(L[i-1][j], L[i][j-1])
            print(X, Y, X[i-1], Y[j-1], i, j, L[i][j])
    
    printMatrix(L)
    return L[m][n]


X = "AGGTAB"
Y = "GXYXAYB"

print(lcs(X, Y))