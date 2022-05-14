class Solution {
    
    private void swap(int[] nums, int i, int j){
        int x=nums[i];
        nums[i]=nums[j];
        nums[j]=x;
    }
    
    private int partition(int[] nums){
        int index=-1;
        for(int i=0;i<nums.length;++i){
            if(nums[i]<=0){
                swap(nums, ++index, i);
            }
        }
        return index+1;
    }
    
    private void firstMissingPositive(int[] nums, int pivot){
        for(int i=pivot;i<nums.length;++i){
            long index=pivot+Math.abs(nums[i])-1;
            if(index<nums.length && index>=0){
                if(nums[(int)index]>0){
                    nums[(int)index]=nums[(int)index]*-1;
                }
            }
        }
    }
    
    public int firstMissingPositive(int[] nums) {
        int pivot=partition(nums);
        if(pivot==nums.length) return 1;
        if(pivot<0){ 
            pivot=0;
        }
        firstMissingPositive(nums, pivot);
        for(int i=pivot;i<nums.length;++i){
            if(nums[i]>0){
                return i-pivot+1;
            }
        }
        return nums.length-pivot+1;
    }
}