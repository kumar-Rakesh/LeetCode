import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Edge implements Comparable<Edge>{
    
    int src, dest, wt;
    
    public Edge(int src, int dest, int wt){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
    
    public int compareTo(Edge edge){
        return this.wt - edge.wt;
    }
}

class PR{
    
    int parent, rank;
    
    public PR(int parent, int rank){
        this.parent = parent;
        this.rank = rank;
    }
}

class Solution {
    
    private int getDist(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
    
    private List<Edge> initGraph(int[][] points){
        int n = points.length;
        List<Edge> edges = new ArrayList<>();
        for(int i=0;i<n;++i){
            for(int j=i+1;j<n;++j){
                int dist = getDist(points[i][0], points[i][1], points[j][0], points[j][1]);
                edges.add(new Edge(i, j, dist));
            }
        }
        return edges;
    }
    
    private int find(PR[] pr, int x){
        if(pr[x].parent!=x){
            pr[x].parent = find(pr, pr[x].parent);
        }
        return pr[x].parent;
    }
    
    private void union(PR[] pr, int x, int y){
        int xRoot = find(pr, x);
        int yRoot = find(pr, y);
        if(pr[xRoot].rank < pr[yRoot].rank){
            pr[xRoot].parent = yRoot;
        }else if(pr[xRoot].rank > pr[yRoot].rank){
            pr[yRoot].parent = xRoot;
        }else{
            pr[xRoot].parent = yRoot;
            pr[yRoot].rank++;
        }
    }
    
    private int getMSTWt(List<Edge> edges, PR[] pr){
        int mstWt = 0;
        for(Edge edge : edges){
            int x = find(pr, edge.src);
            int y = find(pr, edge.dest);
            if(x != y){
                mstWt += edge.wt;
                union(pr, x, y);
            }
        }
        return mstWt;
    }
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = initGraph(points);
        Collections.sort(edges);
        PR[] prs = new PR[n];
        for(int i=0;i<n;++i){
            prs[i] = new PR(i, 0);
        }
        return getMSTWt(edges, prs);
    }
}