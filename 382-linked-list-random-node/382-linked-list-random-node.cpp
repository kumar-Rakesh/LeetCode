/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* head;
    Solution(ListNode* head) {
        this->head=head;
    }
    
    int getRandom() {
        ListNode* curr=this->head;
        int val=0, scope=1;
        while(curr!=NULL){
            if(rand()%scope==0){
                val=curr->val;
            }
            curr=curr->next;
            ++scope;
        }
        return val;
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(head);
 * int param_1 = obj->getRandom();
 */