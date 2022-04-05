/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> solve(TreeNode A) {

        Queue<TreeNode> queue = new LinkedList<>();

        ArrayList<Integer> result = new ArrayList<>();

        queue.add(A);

        int size = 1;

        while(!queue.isEmpty()){

            for(int i=0; i<size; i++){

                TreeNode currNode = queue.remove();

                if(i==(size-1)){
                    result.add(currNode.val);
                }

                if(currNode.left!=null){
                    queue.add(currNode.left);
                }

                if(currNode.right!=null){
                    queue.add(currNode.right);
                }
            }

            size = queue.size();
        }

        return result;
    }

}
