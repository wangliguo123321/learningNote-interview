
import java.util.ArrayList;

/**
 * @Author liguo
 * @Description 二叉树中和为某一值的路径
 * @问题： 题目描述 二叉树中和为某一值的路径
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * @思路：
        1：根节点为空的极端情况；
        2：然后target减小根节点的值，从根节点往左右两个子树寻找；
        3：当target为零并且左右子树为null，加入两个路径；
        4：否则递归调用左右子树进行寻找；
        5：最后去除 list.remove(list.size()-1);，没找到的节点；
 * @Data 2018-09-24 0:31
 */
public class Solution26 {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);  //
        return listAll;
    }
}