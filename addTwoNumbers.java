/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = new ListNode(0);
        dummy.next = curr;
        int carry = 0;
        int currl1 = 0;
        int currl2 = 0;
        int sum = 0;
        while(l1 != null || l2 != null){
            if(l1 == null){
                currl1 = 0;
            }
            else{
                currl1 = l1.val;
            }
            if(l2 == null){
                currl2 =0;
                
            }
            else{
                currl2= l2.val;
            }
            sum = currl1+currl2+ carry;
            curr.next = new ListNode(sum % 10);
            carry= sum/10;
            
                curr = curr.next;
        
            
            if(l1 != null &&l1.next != null){
            l1 = l1.next;
            }
            else{l1 = null;
                 }
            if(l2!=null &&l2.next != null){
            l2= l2.next;
            }
            else{
                l2 = null;
            }
                    
            
        }
        if(carry> 0)
        {
            curr.next = new ListNode(1);
           
        }
        return dummy.next.next;
        
    }
}
