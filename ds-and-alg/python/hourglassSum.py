

R = 5
C = 5

def hourglassSum(arr):
    max_sum = -50000

    if (R< 3 or C< 3):
        print("Not Possible")
        exit()
    
    for i in range(0, R-2):
        for j in range(0, C-2):

            SUM = (arr[i][j] + arr[i][j+1] + arr[i][j+2]) + (arr[i+1][j+1]) + (arr[i+2][j+1] + arr[i+2][j+2] + arr[i+2][j])
        
            if (SUM > max_sum):
                max_sum = SUM
            else: 
                continue
    return max_sum

arr = [[1, 2, 3, 0, 0],
       [0, 0, 0, 0, 0],
       [2, 1, 4, 0, 0],
       [0, 0, 0, 0, 0],
       [1, 1, 0, 1, 0]]
res = hourglassSum(arr)
print(res)