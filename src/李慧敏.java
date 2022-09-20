import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class 李慧敏 {

    static int re;
    public static void main(String[] args) {
        TreeNode root = creatTree("3 # #");
//        List<List<MyNode>> lists = levelOrder(root);
//        System.out.println(re);
    }

    public static TreeNode creatTree(String str){
        int i = 1; TreeNode root;
        String[] strArr = str.trim().split(" ");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root = new TreeNode(Integer.parseInt(strArr[0])));
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode node = queue.poll();
                if(!strArr[i].equals("#"))
                    queue.add(node.left = new TreeNode(Integer.parseInt(strArr[i])));
                i++;
                if(!strArr[i].equals("#"))
                    queue.add(node.right = new TreeNode(Integer.parseInt(strArr[i])));
                i++;
                size--;
            }
        }
        return root;
    }

    public static List<List<MyNode>> levelOrder(TreeNode root) {
        // 结果集
        List result = new ArrayList();
        // 待遍历的层级节点列表
        LinkedList<MyNode> list = new LinkedList();
        int temp = root.left.val>root.right.val?root.left.val:root.right.val;
        temp = root.val>temp?root.val:temp;
        if (root != null) list.add(new MyNode(temp-root.val,root,null));
        int size = list.size();
        while (size > 0) {
            // 创建保存当前层序的结果集列表
            List item = new ArrayList();
            // 遍历当前层序，加入结果集及获取下一层级的节点
            int sum = 0;//层总数
            int Maxadd =0;//每层最大增益
            for (int i = 0; i < size; i++) {
                MyNode mynode = list.remove();
                item.add(mynode);
                sum+=mynode.node.val;
                Maxadd = mynode.MaxAdd>Maxadd?mynode.MaxAdd:Maxadd;
                if (mynode.node.left != null) {
                    TreeNode node = mynode.node.left;
                    PriorityQueue que = new PriorityQueue<Integer>((o1,o2)->o2-o1);
                    que.add(node.val);//本节点
                    que.add(mynode.node.val);// 父节点
                    if (node.left!=null) que.add(node.left.val);
                    if (node.right!=null) que.add(node.right.val);
                    int max = (int) que.poll();
                    list.add(new MyNode(max-node.val,node,mynode.node));
                }
                if (mynode.node.right != null) {
                    TreeNode node = mynode.node.right;
                    PriorityQueue que = new PriorityQueue<Integer>((o1,o2)->o2-o1);
                    que.add(node.val);//本节点
                    que.add(mynode.node.val);// 父节点
                    if (node.left!=null) que.add(node.left.val);
                    if (node.right!=null) que.add(node.right.val);
                    int max = (int) que.poll();
                    list.add(new MyNode(max-node.val,node,mynode.node));
                }
            }
            size = list.size();
            result.add(item);
            int all = sum+Maxadd;
            re = re>all?re:all;
        }
        return result;
    }
    public static class MyNode{
        int MaxAdd;
        TreeNode node;
        TreeNode parent;
        public MyNode(int maxAdd, TreeNode node, TreeNode parent) {
            MaxAdd = maxAdd;
            this.node = node;
            this.parent = parent;
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}



