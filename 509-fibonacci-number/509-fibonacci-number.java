class Solution {
    public int fib(int n) {
        if(n==0 || n==1) return n;
        int prev_1=1, prev_2=0, curr=0;
        for(int i=2;i<=n;++i){
            curr=prev_1+prev_2;
            prev_2=prev_1;
            prev_1=curr;
        }
        return curr;
    }
}