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
 // Input: the root of a binary tree
 // Invert the binary tree and return its root
 // Invert means the right child of a node takes the position of the left child 
 // and the left child takes the position of the right child at every level 
 // we can solve this using breadth first search
 // Breadth first search means level by level traversal in the tree using a queue
 // we will track if each node is visited through a queue
 // as soon as we visit a node, we insert it in the queue and now that node's children are supposed to be swapped
 // when we are starting with our logic of swapping children, we poll or remove visited node from our queue and now access its left and right childs and swap them. 

class Solution {
    public TreeNode invertTree(TreeNode root) {
        //every node must swap its left and right children
        // using BFS, we process the tree level by level. 
        // we are traversing through our tree level by level
        // starting from the root
        // for each node, swap its children.
        // then push the new left and right children into the queue
        // continue until every node has been processed. 
        // Algorithm: 
        // 1. if the tree is empty, then return null
        // 2. intialize the queue and insert the root

        if(root == null){
            return null;
        }
        // initializing a queue and inserting tree node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            // now we will remove the node that we just visited and then swap its children
            TreeNode node = queue.poll();
            TreeNode temp = node.left; //storing left child of our visited node into temp variable, as we are making our left child go to the right child's place
            node.left = node.right;
            node.right = temp; // here swapping is done
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return root;
    }
}
