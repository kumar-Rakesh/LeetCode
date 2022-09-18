class Solution {
    
    private boolean[][] vis;
    private int m, n;
    
    private void fill(boolean[][] vis, boolean val){
        for(int i=0;i<m;++i){
            Arrays.fill(vis[i], val);
        }
    }
    
    private boolean isValid(int i, int j){
        if(i<0 || i>=m || j<0 || j>=n) return false;
        return true;
    }
    
    private boolean existUtil(char[][] board, String word, int i, int j, int index){
        if(index==word.length()) return true;
        if(!isValid(i, j) || vis[i][j] || word.charAt(index)!=board[i][j]) return false;
        vis[i][j]=true;
        boolean up=existUtil(board, word, i-1, j, index+1);
        if(up) return true;
        boolean down=existUtil(board, word, i+1, j, index+1);
        if(down) return true;
        boolean left=existUtil(board, word, i, j-1, index+1);
        if(left) return true;
        boolean right=existUtil(board, word, i, j+1, index+1);
        if(right) return true;
        vis[i][j]=false;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        vis=new boolean[m][n];
        fill(vis, false);
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(existUtil(board, word, i, j, 0)) return true;        
            }
        }
        return false;
    }
}