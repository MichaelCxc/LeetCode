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

    public int countNodes(TreeNode root) {
        return countNodes(root,-1,-1);
    }

    private int countNodes(TreeNode root, int lheight, int rheight){
        //count left side height
        if(lheight == -1){
            lheight = 0;
            TreeNode cur = root;
            while(cur != null){
                lheight++;
                cur = cur.left;
            }
        }

        //count right side height
        if(rheight == -1){
            rheight = 0;
            TreeNode cur = root;
            while(cur != null){
                rheight++;
                cur = cur.right;
            }
        }

        if(lheight == rheight) return (1<<lheight) - 1;
        return 1 + countNodes(root.left, lheight -1, -1) + countNodes(root.right, -1, rheight-1);
    }
}
