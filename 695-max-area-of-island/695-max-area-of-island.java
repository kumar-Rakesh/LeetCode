class Solution {
    
    private int res=0;
    private int curr=0;
    
    private void maxAreaOfIsland(int[][] grid, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n) return;
        if(grid[i][j]==0 || grid[i][j]==-1) return;
        if(grid[i][j]==1){
            ++curr;
            grid[i][j]=-1;
            maxAreaOfIsland(grid, i+1, j, m, n);
            maxAreaOfIsland(grid, i-1, j, m, n);
            maxAreaOfIsland(grid, i, j+1, m, n);
            maxAreaOfIsland(grid, i, j-1, m, n);
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==1){
                    curr=0;
                    maxAreaOfIsland(grid, i, j, m, n);
                    res=Math.max(curr, res);
                }
            }
        }
        return res;
    }
}