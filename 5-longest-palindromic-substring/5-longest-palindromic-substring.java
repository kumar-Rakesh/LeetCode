class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;++i){
            dp[i][i]=true;
        }
        int res=1, startI=0, endI=0;
        for(int i=0;i<n-1;++i){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                res=2;
                startI=i;
                endI=i+1;
            }else{
                dp[i][i+1]=false;
            }
        }
        for(int len=3;len<=n;++len){
            for(int i=0;i<n-len+1;++i){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    if(len>res){
                        res=len;
                        startI=i;
                        endI=j;
                    }
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return s.substring(startI, endI+1);
    }
}