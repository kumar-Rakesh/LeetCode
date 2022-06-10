class Solution {
    
    private boolean isValid(List<StringBuffer> curr, int row, int col, int n){
        for(int k=row-1, l=col-1;k>=0 && l>=0;--k,--l){
            if(curr.get(k).charAt(l)=='Q') return false;
        }
        for(int k=row-1, l=col+1;k>=0 && l<n;--k,++l){
            if(curr.get(k).charAt(l)=='Q') return false;
        }
        return true;
    }
    
    private void solveNQueensUtil(int row, int n, boolean[] vis, List<StringBuffer> curr, List<List<String>> res){
        if(row==n){
            List<String> r=new ArrayList<>();
            for(int i=0;i<n;++i){
                r.add(curr.get(i).toString());
            }
            res.add(r);
            return;
        }
        for(int col=0;col<n;++col){
            if(!vis[col] && isValid(curr, row, col, n)){
                curr.get(row).setCharAt(col, 'Q');
                vis[col]=true;
                solveNQueensUtil(row+1, n, vis, curr, res);
                vis[col]=false;
                curr.get(row).setCharAt(col, '.');
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        List<StringBuffer> curr=new ArrayList<>();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<n;++i){
            sb.append(".");
        }
        for(int i=0;i<n;++i){
            curr.add(new StringBuffer(sb));
        }
        boolean [] vis=new boolean[n];
        Arrays.fill(vis, false);
        solveNQueensUtil(0, n, vis, curr, res);
        return res;
    }
}