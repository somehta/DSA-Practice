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
    HashMap<Integer, Integer> inOrderMap = new HashMap<>();
    TreeNode root;
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        for(int i=0; i<B.size(); i++){
            inOrderMap.put(B.get(i), i);
        }

        return createTree(A,B,0,A.size()-1, 0, B.size()-1);

    }

    TreeNode createTree(ArrayList<Integer> A, ArrayList<Integer> B, Integer PrS, Integer PrE, Integer InS,Integer InE ){

       if(PrS>PrE || InS>InE){
           return null;
       }

       Integer valOfRoot = A.get(PrS);
       TreeNode newRoot = new TreeNode(A.get(PrS));

       int idx = inOrderMap.get(valOfRoot);
       int countLeft = idx - InS; 

       newRoot.left = createTree(A,B, PrS+1, PrS+countLeft, InS, idx-1);
       newRoot.right = createTree(A,B, PrS+countLeft+1, PrE , idx+1, InE);

       return newRoot;
    }
}
