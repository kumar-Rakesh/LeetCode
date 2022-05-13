class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return null;
        int count=0;
        ListNode curr=head;
        while(count<k && curr!=null){
            curr=curr.next;
            ++count;
        }
        if(count<k) return head;
        curr=head;
        count=0;
        ListNode next=null, prev=null;
        while(curr!=null && count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            ++count;
        }
        head.next=reverseKGroup(curr, k);
        return prev;
    }
}