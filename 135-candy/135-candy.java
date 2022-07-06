class Solution {
    public int candy(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] count=new int[n];
        int i=0;
        while(i<n){
            if(st.empty() || nums[st.peek()]>nums[i]){
                st.push(i++);
            }else{
                if(st.size()==1){
                    if(st.peek()>0){
                        if(nums[st.peek()]==nums[st.peek()-1]){
                            count[st.peek()]=1;
                        }else{
                            count[st.peek()]=count[st.peek()-1]+1;
                        }
                    }else{
                        count[st.peek()]=1;
                    }
                    st.pop();
                }else{
                    int j=0, index=-1;
                    while(!st.empty()){
                        index=st.pop();
                        count[index]=(++j);
                    }
                    while(index>0 && count[index]<=count[index-1] && nums[index]>nums[index-1]){
                        ++count[index];
                    }
                }
            }
        }
        if(st.size()==1){
            if(st.peek()>0){
                if(nums[st.peek()]==nums[st.peek()-1]){
                    count[st.peek()]=1;
                }else{
                    count[st.peek()]=count[st.peek()-1]+1;
                }
            }else{
                count[st.peek()]=1;
            }
            st.pop();
        }else{
            int j=0, index=-1;
            while(!st.empty()){
                index=st.pop();
                count[index]=(++j);
            }
            while(index>0 && count[index]<=count[index-1] && nums[index]>nums[index-1]){
                ++count[index];
            }
        }
        int res=0;
        for(int j=0;j<n;++j){
            res+=(count[j]);
        }
        return res;
    }
}