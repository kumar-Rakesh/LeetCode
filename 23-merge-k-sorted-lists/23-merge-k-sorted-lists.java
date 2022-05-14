class Solution {
    
    private ListNode mergeLists(ListNode list1, ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode head=null, prev=null;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                if(head==null){
                    head=list1;
                }else{
                    prev.next=list1;
                }
                prev=list1;
                list1=list1.next;
            }else{
                if(head==null){
                    head=list2;
                }else{
                    prev.next=list2;
                }
                prev=list2;
                list2=list2.next;
            }
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
        return head;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        for(int i=1;i<lists.length;++i){
            lists[0]=mergeLists(lists[0], lists[i]);
        }
        return lists[0];
    }
}