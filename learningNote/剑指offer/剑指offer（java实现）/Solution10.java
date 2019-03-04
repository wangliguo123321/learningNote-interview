
import java.util.ArrayList;

/**
 * @Author liguo
 * @Description 从上往下打印二叉树       这个算法是真的巧妙，漂亮的不像实力派；
 * @问题：从上往下打印二叉树
 * @思路：用arraylist模拟一个队列来存储相应的TreeNode
 * 1：两个ArrayList。一个作为结果返回值，一个用来储存TreeNode;
 * 2: 判断非空，空的话直接返回list；
 * 3：tArray.size不为零，就将赋值给temp=tArray.remove（0）；这里是精髓，每次都去掉已经加入的值；
 * 4：将temp.val加入list，两个非空判断，temp左右树非空，加入到tArray队列；
 * @Data 2018-08-14 15:31
 */
public class Solution10 {
    public ArrayList <Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList <Integer> list = new ArrayList <Integer>();             //保存返回结果；
        ArrayList <TreeNode> tArray = new ArrayList <TreeNode>();         //储存二叉树；
        if (root == null) return list;                         //为空直接返回空的list
        tArray.add( root );                                   
        while (tArray.size() != 0) {
            TreeNode temp = tArray.remove( 0 );          //精髓，每次去掉已经加入tArray队列的temp值
            //左右非空，则添加到tArray队列中；
            if (temp.left != null) tArray.add( temp.left );
            if (temp.right != null) tArray.add( temp.right );

            list.add( temp.val );
        }
        return list;
    }

}