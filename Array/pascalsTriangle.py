# Problem:

'''
Time complexity O(n)
Space complexity O()
'''


def solve(numRows: int):
    result = [[1]]
    for i in range(1, numRows):
        temp = []
        for j in range(i+1):
            # print(j)
            if j == 0 or j == i:
                temp.append(1)
                # print("temp: ",temp)
            else:
                # print(result[i-1][j])
                temp.append(result[i-1][j-1]+result[i-1][j])
                # print(temp)
        result.append(temp.copy())
        # print("result: ",result)

    return result


# !driver code
if __name__ == '__main__':
    print(solve(int(input())))
