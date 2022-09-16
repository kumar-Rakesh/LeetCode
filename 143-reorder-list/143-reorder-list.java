class Solution {
    
    private ListNode[] dissect(ListNode head){
        ListNode slow=head, fast=head.next;
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode[] lists=new ListNode[2];
        lists[0]=head;
        lists[1]=slow.next;
        slow.next=null;
        return lists;
    }
    
    private ListNode reverse(ListNode list){
        ListNode curr=list, prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return;        
        ListNode[] lists=dissect(head);
        ListNode list1=lists[0], list2=reverse(lists[1]), newHead=null, prev=null;
        boolean flag=true;
        while(list1!=null && list2!=null){
            if(flag){
                if(newHead==null){
                    newHead=list1;
                }else{
                    prev.next=list1;
                }
                prev=list1;
                list1=list1.next;
            }else{
                if(newHead==null){
                    newHead=list2;
                }else{
                    prev.next=list2;
                }
                prev=list2;
                list2=list2.next;
            }
            flag=!flag;
        }
        while(list1!=null){
            prev.next=list1;
            prev=list1;
            list1=list1.next;
        }
        while(list2!=null){
            prev.next=list2;
            prev=list2;
            list2=list2.next;
        }
        head=newHead;
    }
}