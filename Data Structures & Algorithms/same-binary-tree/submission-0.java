/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // edge case if both of the tree is empty then return true
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        // recursively visit each node of p and q
        // compare each node value in each iteration 
        // return true if equal
        if(p.val != q.val){
            return false;
        }

        // if values are equal, keep recursively calling the function like below
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
