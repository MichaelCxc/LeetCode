/*
 *   因为这题不仅仅只是简单的先进先出或者先进后出，他是根据上一层是怎么来的所以下一层会倒过来
 *   因此采用deque最好
 *   而什么时候用先进先出什么时候用先进后出可以用一个boolean 变量flag来做记录，true的时候都是先进后出，false的时候都是先进先出
 *
 */


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        boolean flag = true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size;i++){
                if(flag){//先出后进
                    TreeNode cur = deque.pollFirst();
                    tmp.add(cur.val);
                    if(cur.left != null){
                        deque.offerLast(cur.left);
                    }
                    if(cur.right != null){
                        deque.offerLast(cur.right);
                    }
                }else{//后出先进
                    TreeNode cur = deque.pollLast();
                    tmp.add(cur.val);
                    if(cur.right != null){
                        deque.offerFirst(cur.right);
                    }
                    if(cur.left != null){
                        deque.offerFirst(cur.left);
                    }
                }

            }
            flag = flag? false:true;
            res.add(tmp);
        }
        return res;
    }
}
