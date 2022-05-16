class Node{
    int i, j, currVal;
    public Node(int i, int j, int currVal){
        this.i=i;
        this.j=j;
        this.currVal=currVal;
    }
}

class Solution {
    
    private int shortestVal=Integer.MAX_VALUE;
    
    private boolean isValid(int i, int j, int[][] grid, boolean[][] vis, int n){
        if(i<0 || i>=n || j<0 || j>=n || grid[i][j]==1 || vis[i][j]) return false;
        return true;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        boolean[][] vis=new boolean[n][n];
        for(int i=0;i<n;++i){
            Arrays.fill(vis[i], false);
        }
        LinkedList<Node> q=new LinkedList<>();
        q.add(new Node(0, 0, 1));
        vis[0][0]=true;
        while(!q.isEmpty()){
            Node node=q.poll();
            int i=node.i, j=node.j, currVal=node.currVal;
            if(i==n-1 && j==n-1){
                return currVal;
            }
            if(isValid(i-1, j, grid, vis, n)){
                q.add(new Node(i-1, j, currVal+1));
                vis[i-1][j]=true;
            }
            if(isValid(i+1, j, grid, vis, n)){
                q.add(new Node(i+1, j, currVal+1));
                vis[i+1][j]=true;
            }
            if(isValid(i, j-1, grid, vis, n)){
                q.add(new Node(i, j-1, currVal+1));
                vis[i][j-1]=true;
            }
            if(isValid(i, j+1, grid, vis, n)){
                q.add(new Node(i, j+1, currVal+1));
                vis[i][j+1]=true;
            }
            if(isValid(i-1, j-1, grid, vis, n)){
                q.add(new Node(i-1, j-1, currVal+1));
                vis[i-1][j-1]=true;
            }
            if(isValid(i+1, j+1, grid, vis, n)){
                q.add(new Node(i+1, j+1, currVal+1));
                vis[i+1][j+1]=true;
            }
            if(isValid(i-1, j+1, grid, vis, n)){
                q.add(new Node(i-1, j+1, currVal+1));
                vis[i-1][j+1]=true;
            }
            if(isValid(i+1, j-1, grid, vis, n)){
                q.add(new Node(i+1, j-1, currVal+1));
                vis[i+1][j-1]=true;
            }
        }
        return -1;
    }
}