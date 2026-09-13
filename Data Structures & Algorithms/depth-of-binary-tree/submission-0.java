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
    int depth = 0;

    public int maxDepth(TreeNode root) {    
        if(root == null){
            return depth;
        }

        calcDepth(root, depth + 1);
        return depth;
    }

    public void calcDepth(TreeNode s, int d){
        depth = Math.max(depth, d);

        if(s.left == null && s.right == null){
            return;
        }

        if(s.left != null){
            calcDepth(s.left, d + 1);

        } 
        
        if(s.right != null){
            calcDepth(s.right, d + 1);
        } 
    }
}
