from collections import defaultdict

adj = {}
vis = defaultdict(bool)

MAX = 1001
depth = [0]*(2*MAX)
Euler = [0]*(2*MAX)

def add_edge(u, v):
    if u not in adj:
        adj[u] = []
    if v not in adj:
        adj[v] = []
    adj[u].append(v)
    adj[v].append(u)

def eulerTree(u, index, curr_depth):
    vis[u] = True
    curr_depth = curr_depth + 1
    depth[index] = curr_depth
    Euler[index]= u
    index +=1
    for nbr in adj[u]:
        if not vis[nbr]:
            index = eulerTree(nbr, index, curr_depth)
            Euler[index] = u
            index += 1
    curr_depth = curr_depth -1
    depth[index] = curr_depth
    return index


def eulerTour(root, N):
    index = 0
    curr_depth = -1
    eulerTree(root, index, curr_depth)
    for i in range((2* N)-1):
        print(Euler[i], end=" ")
    print(" ")
    for i in range((2* N)-1):
        print(depth[i], end=" ")

# Driver
N = 4
add_edge(1, 2)
add_edge(2,3)
add_edge(2,4)

print(eulerTour(1, N))