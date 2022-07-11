class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> pq=new LinkedList<>();
        pq.add(root);
        pq.add(null);
        int prev=-101;
        while(!pq.isEmpty()){
            TreeNode node=pq.poll();
            if(node==null){
                res.add(prev);
                if(pq.size()!=0){
                    pq.add(null);
                }
            }else{
                prev=node.val;
                if(node.left!=null){
                    pq.add(node.left);
                }
                if(node.right!=null){
                    pq.add(node.right);
                }
            }
        }
        return res;
    }
}