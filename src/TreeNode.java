import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static List bst(TreeNode p){
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode cur = p;
        List<Integer> res = new ArrayList<>();

        queue.offerLast(cur);
        while(queue.size() != 0){
            TreeNode tmp = queue.pollFirst();
            res.add(tmp.val);
            if(tmp.left != null){
                queue.offerLast(tmp.left);
            }
            if(tmp.right != null){
                queue.offerLast(tmp.right);
            }
        }
        return res;
    }
}
