class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) return 0;
        LinkedList<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        int sum=0;
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                if(!q.isEmpty()){
                    q.add(null);
                    sum=0;
                }
            }else{
                sum+=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        return sum;
    }
}