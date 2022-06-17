 class Solution {
    
    private int minOp=0; 
     
    private void distributeCoins(TreeNode root, TreeNode parent){
        if(root==null) return;
        distributeCoins(root.left, root);
        distributeCoins(root.right, root);
        if(root.val<=0){
            int val=1-root.val;
            parent.val=parent.val-val;
            root.val+=val;
            minOp+=Math.abs(val);
        }else if(root.val>1){
            int val=root.val-1;
            parent.val+=val;
            root.val=1;
            minOp+=val;
        }
    }
    
    public int distributeCoins(TreeNode root) {
        if(root==null) return 0;
        distributeCoins(root, null);
        return this.minOp;
    }
}