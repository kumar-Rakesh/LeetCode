class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(!l1)
            return l2;
        if(!l2)
            return l1;
        ListNode* head = NULL, *prev = NULL;
        int carry = 0;
        while(l1 && l2){
            int sum = l1->val + l2->val + carry;
            if(sum>9){
                carry = 1;
            }else{
                carry = 0;
            }
            ListNode* newNode = new ListNode(sum%10);
            if(!head){
                head = prev = newNode;
            }else{
                prev->next = newNode;
                prev = newNode;
            }
            l1 = l1->next;
            l2 = l2->next;
        }
        while(l1){
            int sum = l1->val + carry;
            if(sum > 9){
                carry = 1;
            }else{
                carry = 0;
            }
            ListNode* newNode = new ListNode(sum%10);
            prev->next = newNode;
            prev = newNode;
            l1 = l1->next;
        }
        while(l2){
            int sum = l2->val + carry;
            if(sum > 9){
                carry = 1;
            }else{
                carry = 0;
            }
            ListNode* newNode = new ListNode(sum%10);
            prev->next = newNode;
            prev = newNode;
            l2 = l2->next;
        }
        if(carry == 1){
            ListNode* newNode = new ListNode(1);
            prev->next = newNode;
        }
        return head;
    }
    
};