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

//input: reorder the nodes of the linked list in the following pattern
// 0, n, 1, n-1, 2, n-3, 3
// intuition, copy the nodes of our linked list into an array list
// now we can access our nodes through their exact index.
// so using two pointers approach start traversing our list from left pointer from 0th and index simultaneously our right pointer from nth index
// so link the node i's next pointer to the reference of node j, 
// then link node j's next pointer to node i
// keep doing this until i>=j.
class Solution {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        // storing all elements of the linked list into an array list
        ListNode curr = head;
        List<ListNode> arrlist = new ArrayList<>();
        while(curr != null){
            arrlist.add(curr);
            curr = curr.next;
        }
        // now we have stored all nodes in our list
        // start our two pointer logic now
        int i = 0;
        int j = arrlist.size()-1;
        while(i<j){
            arrlist.get(i).next = arrlist.get(j); // linking first node to last node
            i++;
            if(i >= j){
                break;
            }
            arrlist.get(j).next = arrlist.get(i);
            j--;
        }

        //now make our last node point to null
        arrlist.get(i).next = null;
    }
}
