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
// input: root of a binary tree
// output: return the maximum depth of the binary tree
// the depth of a binary tree is defined as the number of nodes along the longest path from the root node to the farthest leaf node.
// you might have to track the visited nodes, when you're exploring the longest path
// finally when you're doing reaching the leaf node through the longest path, you will already have tracked the visited nodes, just return the length of the data structure you used to track. 
// we could consider the max depth of the root node's subtrees first and then proceed to get the max depth of root

// approach: We can use a bfs approach to solve this problem, visit each nodes level by level
// intially when we are starting from the root node, we will intialize our level as 0
// then as we keep visiting the left and right child of current node in consideration we will keep incrementing our level
// we will again use a queue to track the visited nodes
// before we start visiting children, we remove the most recently added node from our queue and then visit its children
// we keep adding the left and right children of a node into our queue as long as they dont become null
class Solution {
    public int maxDepth(TreeNode root) {
        // edge case if binary tree is null then return null
        if(root == null){
            return 0;
        }
        // initializing our counter which tracks our level
        int level = 0;
        //Initializing a queue which tracks the visited nodes, and also which nodes to be visited next
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null){
            q.offer(root);
        }
        while(!q.isEmpty()){
            int size = q.size(); 
            for(int i=0; i<size; i++){ // this loop only runs as long as all the nodes of one level are visited
                // remove the most recently added node and start exploring its children
                TreeNode node = q.poll();
                // for the left child, if its not null add it to our queue as we will be exploring its children later
                if(node.left != null){
                    q.offer(node.left);
                }
                // for the right child, if its not null add it to our queue as we will be exploring its children later
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            level++;
        }
        return level;
    }
}
