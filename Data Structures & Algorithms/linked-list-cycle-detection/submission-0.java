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
// input: given the head of a linked list, return true if there is a cycle in the linked list
// otherwise return false.
// there is a cycle in the linkedlist if atleast one node can be visited again using the next pointer.  
class Solution {
    public boolean hasCycle(ListNode head) {
     // use a hashset for storing the reference of each node visited
     // if the reference of any node is a duplicate (i.e that node was already visited) which was already consisting in our set, then there is indeed a cyclce which exists
     // if not, then return false as all references are unique and we do not go back to any already visited node. 
    //  Set<ListNode> seen = new HashSet<>();
    //     ListNode curr = head;
    //     while(curr != null){ // keep running this until we visit a reference that points to null
    //         if(seen.contains(curr)){
    //             return true;
    //         }
    //         seen.add(curr); // add the full node, including its value and reference part. if the
    //         curr = curr.next;
    //     }
    //     return false;
    //     // now the optimal approach would be to use the fast and slow pointers technique.
    ListNode slow = head; // initially slow will point to the first node
        ListNode fast = head; // same case for fast pointer

        // Continue while the fast pointer can safely move two steps.
        // If fast becomes null or fast.next becomes null,
        // we've reached the end of the list, so no cycle exists.
        while(fast != null && fast.next != null){
            // increment our fast pointer two steps from the current node
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
