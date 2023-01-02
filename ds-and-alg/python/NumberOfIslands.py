
class Graph:
    def __init__(self, row, col, grid):
        self.ROW = row
        self.COL = col
        self.grid = grid

    def dfs(self, i, j):
        if i< 0 or i>= self.ROW  or j< 0 or j >= self.COL or self.grid[i][j] != 1:
            return
        self.grid[i][j] = -1

        self.dfs(i - 1, j)
        self.dfs(i, j - 1)
        self.dfs(i, j + 1)
        self.dfs(i + 1, j)
        # uncomment to find graphs adjcent diagonally
        #self.dfs(i - 1, j - 1)
        #self.dfs(i - 1, j + 1)
        #self.dfs(i + 1, j - 1)
        #self.dfs(i + 1, j + 1)


    def countIslands(self):
        count= 0
        for i in range(self.ROW):
            for j in range(self.COL):
                if self.grid[i][j] == 1:
                    self.dfs(i, j)
                    count += 1
        return count



sea = [
    [1,1,0,0,0],
    [1,1,0,0,0],
    [0,0,1,0,0],
    [0,0,0,1,1]
]
g = Graph(len(sea), len(sea[0]),  sea)
print(g.countIslands())