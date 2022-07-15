class Solution {
    
    private int i=0;
    
    private int search(int[] inorder, int val, int l, int r){
        for(int i=l;i<=r;++i){
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int l, int r, int n){
        if(l>r || i==n) return null;
        TreeNode node=new TreeNode(preorder[i]);
        int index=search(inorder, preorder[i], l, r);
        ++i;
        node.left=buildTree(preorder, inorder, l, index-1, n);
        node.right=buildTree(preorder, inorder, index+1, r, n);
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return buildTree(preorder, inorder, 0, n-1, n);
    }
}