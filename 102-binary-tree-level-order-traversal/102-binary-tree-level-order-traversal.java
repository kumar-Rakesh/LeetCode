class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        List<Integer> curr=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                res.add(curr);
                if(!q.isEmpty()){
                    curr=new ArrayList<>();
                    q.add(null);
                }
            }else{
                curr.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }
        return res;
    }
}