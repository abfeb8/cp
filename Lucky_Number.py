def solve():
    a,b,c = map(int, input().split())
    if(a==7 or b==7 or c==7):
        print("Yes")
    else:
        print("No")
    return

t = int(input())
for _ in range(t):
    solve()