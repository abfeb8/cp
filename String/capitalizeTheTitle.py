'''
Time complexity O(n)
Space complexity O()
'''


def solve(title: str):
    result = ""
    for i in title.split(" "):
        if(len(i) < 3):
            result += i.lower()+" "
        else:
            result += i.title()+" "
    return result.strip()


# !driver code
if __name__ == "__main__":
    print(solve(input()))
