


def edit_distance(s1: str, s2: str, distance: int) -> bool: 
    if (type(s1) == type(s2) and type(s1) != str):
        raise Exception("Unsupported types")
    if distance < 0: 
        raise Exception("Distance should be a positive integer")
    
    c1 = 0
    c2 = 0
    while c1 < len(c1) and c2 < len(c2):
        if (c1 != c2 and distance > 0):
            distance -= 1
        elif distance == 0:
            return False
        c1 = next(s1, None)
        c2 = next(s2, None)

    while c1 != None:
        distance -= 1
        if (distance == 0):
            return False
        c1 = next(s1, None)
    while c2 != None:
        distance -= 1
        if (distance == 0):
            return False
        c2 = next(s2, None)


    return True

    


assert edit_distance("aa", "aaa", 1) == True
assert edit_distance("aaaa", "aaa", 1) == True
assert edit_distance("", "aaa", 1) == False
assert edit_distance("abcd", "defg", 1) == False

try:
    edit_distance(1, 2, 1)
    assert False, "Should have thrown an error"
except: 
    pass 

try:
    edit_distance("aa", "aaa", -1)
    assert False, "Should have thrown an error"
except: 
    pass 
