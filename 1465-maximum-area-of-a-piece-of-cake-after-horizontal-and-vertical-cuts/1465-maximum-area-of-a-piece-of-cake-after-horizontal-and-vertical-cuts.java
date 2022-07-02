class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        final long MOD=1000000007;
        int m=horizontalCuts.length;
        int n=verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxHDiff=horizontalCuts[0], maxVDiff=verticalCuts[0];
        for(int i=1;i<m;++i){
            maxHDiff=Math.max(horizontalCuts[i]-horizontalCuts[i-1], maxHDiff);
        }
        maxHDiff=Math.max(h-horizontalCuts[m-1], maxHDiff);
        for(int i=1;i<n;++i){
            maxVDiff=Math.max(verticalCuts[i]-verticalCuts[i-1], maxVDiff);
        }
        maxVDiff=Math.max(w-verticalCuts[n-1], maxVDiff);
        return (int)(((long)maxHDiff*(long)maxVDiff)%MOD);
    }
}