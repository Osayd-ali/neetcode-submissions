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
// input: given the heads of two sorted linked lists, lists list1 and list2
// Merge the two sorted lists into one sorted linked list.
// output: return the head of the new sorted linked list. 
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Approach: 
        // Create a dummy node to keep track of the head of our result linked list while iterating through the lists
        // we will also create a node iterator, that will first point to dummy at start.
        // through this iterator, we keep adding nodes into our linked list
        // Iterate through the lists list1 and list2 through their heads. this traversing of both lists happen simultaneously in a while loop
        // compare values in each iteration, for list1 value and list2 value, if list1.val < list2.val then 
        // then make our iterator's reference part (iterator.next) point to list1 (signifying that this element should be added first)
        ListNode dummy = new ListNode(0); //dummy will be the head of our resultant linkedlist
        ListNode node = dummy; // this is our node that will traverse our resultant linkedlist and keep adding elements into it
        // as long as the heads of both of our lists hasn't crossed the last node of their respective lists, keep running this loop
        while(list1 != null && list2 != null) {
            // compare the current values between both of the lists
            if(list1.val < list2.val){
                node.next = list1; // the next node in our resultant linkedlist should add the current list1 element
                list1 = list1.next; // now make our list1 head go to the next node of list 1
            } else { // when current l2 value is less than l1 value, add that into our resultant linked list
                node.next = list2;
                list2 = list2.next;
            }
            // once element for current iteration is added into our resultant list, then increment our resultant list node to go to the next position
            node = node.next;
        }
        //as soon as we finish traversing either of the lists, we add the remaining elements of the list which wasn't fully traversed
        if(list1 != null){ // if list 1 wasn't fully traversed and its head is not pointing to null
            node.next = list1; // add all elements of list1
        } else {
            node.next = list2;
        }

        return dummy.next;
    }
}