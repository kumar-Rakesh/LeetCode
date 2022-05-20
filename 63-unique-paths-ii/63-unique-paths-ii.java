class Solution {
    
    private boolean isValid(int i, int j, int m, int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
    
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1){
            return 0;
        }
        int[][] dp=new int[m][n];
        for(int i=0;i<m;++i){
            Arrays.fill(dp[i], 0);
        }
        dp[0][0]=1;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(i==0 && j==0){
                    continue;
                }
                if(grid[i][j]==0){
                    int up=isValid(i-1, j, m, n)?dp[i-1][j]:0;
                    int left=isValid(i, j-1, m, n)?dp[i][j-1]:0;
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}