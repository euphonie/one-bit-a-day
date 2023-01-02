import collections
from orderedset import OrderedSet
def printMatrix(M):
    for row in M:
        print(' '.join(map(str, row)))

def abbreviation(a, b):
    n = len(a)
    m = len(b)

    lookup = [[0] * (n+1) for i in range(m+1)]
    cant_delete = set()
    last_match = 0
    for i in range(m+1):
        for j in range(n+1):
            if i == 0 or j == 0:
                lookup[i][j] = 0
            elif a[j-1].upper() == b[i-1]:
                lookup[i][j] = lookup[i-1][j-1] + 1
                last_match = j
            else:
                lookup[i][j] = max(lookup[i-1][j], lookup[i][j-1])
            
            if i != 0 and lookup[i][j] == lookup[i-1][j] and a[j-1].isupper():
                cant_delete.add(a[j-1])
                

    for letter in a[last_match:]:
        if letter.isupper():
            cant_delete.add(letter)
    printMatrix(lookup)
    a_matches_b = lookup[m][n] == len(b)
    print(cant_delete)
    return "YES" if a_matches_b and len(cant_delete) == 0 else "NO"  




#b = "AbcDE"
#a = "AFDE"
#a = "daBcd"
#b = "ABC"
#a = "KXzQ"
#b = "K"
#a = "LLZOSYAMQRMBTZXTQMQcKGLR"
#b = "LLZOSYAMBTZXMQKLR"
#a = "beFgH"
#b = "EFG"
a = "QOTLYiFECLAGIEWRQMWPSMWIOQSEBEOAuhuvo"
b = "QOTLYFECLAGIEWRQMWPSMWIOQSEBEOA"
print(abbreviation(a,b))