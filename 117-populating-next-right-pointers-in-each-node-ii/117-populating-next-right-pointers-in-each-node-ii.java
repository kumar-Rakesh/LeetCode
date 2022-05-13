/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        LinkedList<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        Node prev=null;
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr==null){
                if(!q.isEmpty()){
                    q.add(null);
                }
            }else{
                if(prev!=null){
                    prev.next=curr;
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            prev=curr;
        }
        return root;
    }
}