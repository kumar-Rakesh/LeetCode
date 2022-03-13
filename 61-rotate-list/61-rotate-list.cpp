class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if(!head){
            return NULL;
        }
        int size = getSize(head);
        k %= size;
        if(k == 0){
            return head;
        }
        int index = size - k, i = 1;
        ListNode* temp = head;
        while(temp && i < index){
            ++i;
            temp = temp->next;
        }
        ListNode* newHead = temp->next;
        temp->next = NULL;
        temp = newHead;
        while(temp->next){
            temp = temp->next;
        }
        temp->next = head;
        return newHead;
    }
    
    int getSize(ListNode* head){
        int count = 0;
        while(head){
            ++count;
            head = head->next;
        }
        return count;
    }
};