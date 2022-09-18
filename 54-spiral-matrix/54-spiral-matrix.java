class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int up=0, down=m-1, left=0, right=n-1;
        List<Integer> res=new ArrayList<>();
        while(true){
            
            for(int i=left;i<=right;++i){
                res.add(matrix[up][i]);
            }
            
            ++up;
            
            if(up>down) break;
            
            for(int i=up;i<=down;++i){
                res.add(matrix[i][right]);
            }
            
            --right;
            
            if(left>right) break;
            
            for(int i=right;i>=left;--i){
                res.add(matrix[down][i]);
            }
            
            --down;
            
            if(up>down) break;
            
            for(int i=down;i>=up;--i){
                res.add(matrix[i][left]);
            }
            
            ++left;
            
            if(left>right) break;
            
        }
        
        return res;
    }
}