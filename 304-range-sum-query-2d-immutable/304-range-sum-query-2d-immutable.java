class NumMatrix {

    int[][] matrix;
    int[][] dp;
    int m, n;
    
    public NumMatrix(int[][] matrix) {
        this.m=matrix.length;
        this.n=matrix[0].length;
        this.matrix=matrix;
        this.dp=new int[m][n];
        sum();
    }
    
    private boolean isValid(int i, int j, int m, int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
    
    private void sum(){
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(j==0){
                    dp[i][j]=matrix[i][j];
                }else{
                    int left=isValid(i, j-1, m, n)?dp[i][j-1]:0;
                    dp[i][j]=matrix[i][j]+left;
                }
            }
        }
        for(int i=1;i<m;++i){
            for(int j=0;j<n;++j){
                dp[i][j]+=dp[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int up=0, left=0, common=0;
        if(col1-1>=0){
            left=dp[row2][col1-1];
        }
        if(row1-1>=0){
            up=dp[row1-1][col2];
        }
        if(row1-1>=0 && col1-1>=0){
            common=dp[row1-1][col1-1];
        }
        return dp[row2][col2]-left-up+common;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */