def solve():
    result = list(map(int,input().split()))
    d,i,e=0,0,0
    for r in result:
        if r==0:
            d+=1
        elif r==1:
            i+=1
        else:
            e+=1
    if i>e:
        print("INDIA")
    elif e>i:
        print("ENGLAND")
    else:
        print("DRAW")
    return

t = int(input())
for _ in range(t):
    solve()