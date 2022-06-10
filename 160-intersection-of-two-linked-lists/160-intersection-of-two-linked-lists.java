/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    private int size(ListNode list){
        int size=0;
        while(list!=null){
            ++size;
            list=list.next;
        }
        return size;
    }
    
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        if(A==null || B==null) return null;
        int sizeA=size(A);
        int sizeB=size(B);
        ListNode large=null, small=null;
        if(sizeA>sizeB){
            large=A;
            small=B;
        }else{
            large=B;
            small=A;
        }
        int diff=Math.abs(sizeA-sizeB), count=0;
        while(count<diff){
            ++count;
            large=large.next;
        }
        while(large!=null && small!=null){
            if(large==small) return large;
            large=large.next;
            small=small.next;
        }
        return null;
    }
}