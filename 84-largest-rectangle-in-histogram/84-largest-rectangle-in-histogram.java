class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st = new Stack<>();
        int top=0, areaWithTop=0, maxArea=0, i=0;
        while(i<n){
            if(st.isEmpty() || heights[i]>=heights[st.peek()]){
                st.push(i++);
            }else{
                top=st.peek();
                st.pop();
                areaWithTop=(st.isEmpty()?i:i-st.peek()-1)*heights[top];
                maxArea=Math.max(maxArea, areaWithTop);
            }
        }
        while(!st.isEmpty()){
            top=st.peek();
            st.pop();
            areaWithTop=(st.isEmpty()?i:i-st.peek()-1)*heights[top];
            maxArea=Math.max(maxArea, areaWithTop);
        }
        return maxArea;
    }
}