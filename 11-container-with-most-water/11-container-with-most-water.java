class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0, r=n-1;
        int maxArea=0;
        while(l<r){
            maxArea=Math.max(maxArea, (r-l)*Math.min(height[l], height[r]));
            if(height[l]<height[r]){
                ++l;
            }else{
                --r;
            }
        }
        return maxArea;
    }
}