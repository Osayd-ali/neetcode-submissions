/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// input: we are given the head of a linkelist
// output: return the nth node from the end of the list and return the head of our new linkedlist
// nth node to be deleted should be reached from the end
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // the concept of deleting is, essentially make the previous element of nth node point to the next element of nth node
        // no node should have the reference of nth node
        // but how do we reach till nth node?
        // we can't traverse from back like array
        // also the previous element of nth node would be at position n+1 from back
        // finding the node which comes before the nth node
        // how to traverse the linkedlist from back??
        // what if we just reverse our linkedlist? then traverse just like a normal linkedlist till we reach n + 1
        // Reversing a linkedlist
        // make each node's next pointer point to the previous element
        // Reverse the linked list
       ListNode curr = head;
       ListNode prev = null;
       while(curr != null){
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
       }
       ListNode reversedHead = prev;

       curr = reversedHead;
       prev = null;
       // now we need to access the nth node so that it can be deleted
       for(int i=1; i<n; i++){
        prev = curr;
        curr = curr.next;
       }
       // so now curr will be pointing to nth node
       // and prev will be pointing to n-1th node
       //if the element that was supposed to be deleted was at index 1, then that would be our last element and in this case our reversedHead
       if(prev == null){
        reversedHead = curr.next; // to avoid null pointer exception 
       } else {
        prev.next = curr.next;
       }

       // reverse the linked list again
       curr = reversedHead;
       prev = null;

       while(curr != null){
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
       }

       return prev;
       
    }
}
