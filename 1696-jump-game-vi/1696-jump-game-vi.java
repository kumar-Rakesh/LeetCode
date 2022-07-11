class Pair implements Comparable<Pair>{
    int val, i;
    Pair(int val, int i){
        this.val=val;
        this.i=i;
    }
    
    public int compareTo(Pair p){
        return p.val-this.val;
    }
}
class Solution {
    public int maxResult(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[n-1]=nums[n-1];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(dp[n-1], n-1));
        int i=n-2;
        while(i>=0){
            Pair p=pq.peek();
            int bound=i+k>=n-1?n-1:i+k;
            if(p.i<=bound){
                dp[i]=nums[i]+p.val;
                pq.add(new Pair(dp[i], i));
                --i;
            }else{
                pq.poll();
            }
        }
        return dp[0];
    }
}