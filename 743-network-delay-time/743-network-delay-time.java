class Edge implements Comparable<Edge>{
    int v, wt;
    public Edge(int v, int wt){
        this.v=v;
        this.wt=wt;
    }
    
    public int compareTo(Edge e){
        return this.wt-e.wt;
    }
    
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph=new ArrayList<>(n+1);
        for(int i=0;i<=n;++i){
            graph.add(new ArrayList<Edge>());
        }
        for(int i=0;i<times.length;++i){
            graph.get(times[i][0]).add(new Edge(times[i][1], times[i][2]));
        }
        boolean[] vis=new boolean[n+1];
        int[] dist=new int[n+1];
        for(int i=1;i<=n;++i){
            dist[i]=Integer.MAX_VALUE;
            vis[i]=false;
        }
        dist[k]=0;
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(k, 0));
        int countVis=0, res=Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            Edge e=pq.poll();
            vis[e.v]=true;
            res=Math.max(res, dist[e.v]);
            ++countVis;
            List<Edge> adjList=graph.get(e.v);
            for(int i=0;i<adjList.size();++i){
                if(vis[adjList.get(i).v]) continue;
                int newDist=dist[e.v]+adjList.get(i).wt;
                if(newDist<dist[adjList.get(i).v]){
                    dist[adjList.get(i).v]=newDist;
                    pq.add(new Edge(adjList.get(i).v, dist[adjList.get(i).v]));
                }
            }
        }
        if(countVis<n) return -1;
        return res;
    }
}