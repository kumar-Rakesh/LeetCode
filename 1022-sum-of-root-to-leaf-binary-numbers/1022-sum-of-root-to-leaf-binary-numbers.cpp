/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void sumRootToLeafUtil(TreeNode* root, string s, int& res){
        if(!root){
            return;
        }
        if(root->left==NULL && root->right==NULL){
            s+=root->val==0?"0":"1";
            int val=0, i=s.size()-1;
            while(i>=0){
                val+=(pow(2,s.size()-i-1)*(s[i]-'0'));
                --i;
            }
            res+=val;
            return;
        }
        s+=root->val==0?"0":"1";
        sumRootToLeafUtil(root->left, s, res);
        sumRootToLeafUtil(root->right, s, res);
    }
    
    int sumRootToLeaf(TreeNode* root) {
        string s="";
        int res=0;
        sumRootToLeafUtil(root, s, res);
        return res;
    }
};