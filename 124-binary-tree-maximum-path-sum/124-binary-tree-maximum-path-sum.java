class Solution {
    
    private int maxSum=Integer.MIN_VALUE;
    
    private int maxPathSumUtil(TreeNode root) {
        if(root==null) return 0;
        int leftSum=maxPathSumUtil(root.left);
        int rightSum=maxPathSumUtil(root.right);
        int midSum=root.val+leftSum+rightSum;
        maxSum=Math.max(maxSum, midSum);
        maxSum=Math.max(maxSum, root.val);
        maxSum=Math.max(maxSum, root.val+Math.max(leftSum, rightSum));
        return Math.max(root.val+Math.max(leftSum, rightSum), root.val);
    }
    
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxPathSumUtil(root);
        return maxSum;
    }
}