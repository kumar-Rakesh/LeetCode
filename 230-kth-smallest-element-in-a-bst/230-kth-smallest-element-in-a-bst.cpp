class Solution {

private:
    int kthSmallest(TreeNode* root, int k, int& count){
        if(!root)
            return -1;
        int left = kthSmallest(root->left, k, count);
        if(left != -1)
            return left;
        if(++count == k){
            return root->val;
        }
        return kthSmallest(root->right, k, count);
    }    
    
public:    
    int kthSmallest(TreeNode* root, int k) {
        int count = 0;
        return kthSmallest(root, k, count);
    }
};