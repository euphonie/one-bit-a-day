


def find_next(n: int) -> int:
    h = [0 for i in range(10)]
    i = 0
    msb = n
    rem = 0
    next_num = -1
    count = 0

    while (msb > 9) :
        rem= msb % 10
        h[rem] = 1
        msb //= 10
        count +=1 
    
    h[msb] = 1
    count +=1

    print(h, count, msb)

    # get most-left next digit, sets if msb < 9 
    for i in range(msb + 1, 10):
        if (h[i] == 0):
            next_num = i
            break

    print(next_num)
    
    if (next_num == -1):
        for i in range(1, msb):
            if (h[i] == 0):
                next_num = i
                count += 1
                break
    
    print(next_num, count)


    if (next_num > 0):
        for i in range(0, 10, 1):
            if (h[i] == 0):
                msb = i
                break
    
    print (msb)

    for i in range(1, count,1):
        next_num = ((next_num * 10) + msb)

    print (next_num)

    if (next_num > n):
        print(next_num)
    else:
        print("not possible")

print(find_next(901))