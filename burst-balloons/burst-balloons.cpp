class Solution {
public: 
    int maxCoinsUtil(vector<int>& nums, vector<vector<int>>& dp, int left, int right){
        if(left > right){
            return 0;
        }
        if(dp[left][right] > 0){
            return dp[left][right];
        }
        int res = 0;
        for(int i = left;i <= right;++i){
            int curr = maxCoinsUtil(nums, dp, left, i - 1) + (nums[left - 1] * nums[i] * nums[right + 1]) + maxCoinsUtil(nums, dp, i + 1, right);
            res = max(res, curr);
        }
        dp[left][right] = res;
        return res;
    }
    
    int maxCoins(vector<int>& nums) {
        nums.insert(nums.begin(), 1);
        nums.insert(nums.end(), 1);
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        int res = maxCoinsUtil(nums, dp, 1, n - 2);
        return res;
    }
};