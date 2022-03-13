class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(!head){
            return NULL;
        }
        Node* tr = head;    
        Node *newHead = NULL, *prev = NULL;
        vector<Node*> l1;
        vector<Node*> l2;
        while(tr){
            Node* next = tr->next;
            Node* newNode = new Node(tr->val);
            if(!newHead){
                newHead = prev = newNode;
            }else{
                prev->next = newNode;
                prev = newNode;
            }
            tr->next = newNode;
            l1.push_back(tr);
            l2.push_back(newNode);
            tr = next;
        }
        for(int i = 0;i < l1.size(); ++i){
            l2[i]->random = l1[i]->random == NULL ? NULL : l1[i]->random->next;
        }
        for(int i = 1;i < l1.size(); ++i){
            l1[i-1]->next = l1[i];
            if(i == l1.size()-1){
                l1[i]->next = NULL;
            }
        }
        if(l1.size() == 1){
            l1[0]->next = NULL;
        }
        return newHead;
        
    }
};