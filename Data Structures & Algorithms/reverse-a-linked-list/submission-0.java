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

// input: we are given head part of our linked list which points to the first node
// we need to reverse the list and return the new beginning of the list
// output: return the starting node of our linkedlist
class Solution {
    public ListNode reverseList(ListNode head) {
        // so essentially we will maintain three pointers
        // curr, prev and temp
        // we will need to traverse our given linked list from right to left by accessing the next part of where the given head is pointing to
        // we will visit each node and our current pointer will point to that node and we will start processing
        // essentially what we will do is, we will visit a node, access it's reference part and make it point towards the previous node
        // so this way as we are moving forward we are reversing our linked list
        ListNode curr = head; // our current node will point to the same node as our head reference is pointing to
        ListNode prev = null; // initially prev pointer will point to null as we do not have any nodes before our very first node
        // we will now start a loop, and start traversing from left to right until our current pointer is pointing to null, this means we have reached the end of the list and crossed the last node
        while(curr != null){
            // the temp node will keep track of the next node which comes after the current node
            ListNode temp = curr.next;
            // now make our current node's reference part point towards previous node, core logic of reversing.
            curr.next = prev;
            // now we will make our previous pointer point to curr
            prev = curr;
            curr = temp;
        }
        // as soon as our curr pointer has crossed the last node of the list, and now pointing to null
        // by our algorithm, prev pointer will be pointing to our last node which is our head for the newly reversed linked list
        // now just return this prev node
        return prev;
    }
}
