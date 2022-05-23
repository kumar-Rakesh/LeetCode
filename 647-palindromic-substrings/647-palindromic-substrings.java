class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        int res=n;
        for(int i=0;i<n;++i){
            dp[i][i]=1;
        }
        for(int i=0;i<n-1;++i){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
                ++res;
            }else{
                dp[i][i+1]=0;
            }
        }
        for(int len=3;len<=n;++len){
            for(int i=0;i<n-len+1;++i){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    dp[i][j]=1;
                    ++res;
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return res;
    }
}