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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if(!list1 && !list2){
            return NULL;
        }    
        if(!list1){
            return list2;
        }
        if(!list2){
            return list1;
        }
        ListNode* head=NULL,*prev=NULL;
        while(list1 && list2){
            if(list1->val < list2->val){
                if(!head){
                    head=prev=list1;
                }else{
                    prev->next=list1;
                    prev=list1;
                }
                list1=list1->next;
            }else{
                if(!head){
                    head=prev=list2;
                }else{
                    prev->next=list2;
                    prev=list2;
                }
                list2=list2->next;
            }
        }
        while(list1){
            prev->next=list1;
            prev=list1;
            list1=list1->next;
        }
        while(list2){
            prev->next=list2;
            prev=list2;
            list2=list2->next;
        }
        return head;
    }
};