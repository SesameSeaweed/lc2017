import java.util.*;
import java.util.stream.Collectors;

public class DupSubtree652 {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

//    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        Stack<TreeNode> tree = new Stack<>();
//        tree.push(root);
//        Map<Integer, List<TreeNode>> map = new HashMap<>();
//        List<TreeNode> out = new ArrayList<>();
//        List<Integer> traverse = new ArrayList<>();
//        TreeNode curr = tree.pop();
//        while (curr != null || !tree.isEmpty()) {
//
//         while(curr != null) {
//             tree.push(curr);
//             curr = curr.left;
//         }
//         boolean found = false;
//         curr = tree.pop();
//            traverse.add(curr.val);
//
//            if(map.containsKey(curr.val)) {
//                List<TreeNode> currList = map.get(curr.val);
//                for(TreeNode currNode : currList) {
//                    if(sameTree(currNode, curr)) {
//                        if(!out.contains(currNode)) out.add(currNode);
//                        found = true;
//                        break;
//                    }
//                }
//            }
//            if(!map.containsKey(curr.val) || !found) {
//                List<TreeNode> firstPut = map.get(curr.val);
//                if(firstPut == null || firstPut.isEmpty()) firstPut = new ArrayList<>();
//                firstPut.add(curr);
//                map.put(curr.val, firstPut);
//            }
//            curr = curr.right;
//        }
//        return out;
//    }


    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> out = new ArrayList<>();
        postOrder(root, new HashMap<>(), out);
        return out;
    }

    private static String postOrder(TreeNode root, HashMap<String, Integer> map, List<TreeNode> out) {
        if(root == null) return "#";
        StringBuilder serial = new StringBuilder("");
        serial.append(root.val).append(",").append(postOrder(root.left, map, out)).append(",").append(postOrder(root.right, map, out));
        if(map.containsKey(serial.toString()) && map.get(serial.toString()) == 1) {
            out.add(root);
            map.put(serial.toString(), 2);
        }else {
            map.put(serial.toString(), 1);
        }
        return serial.toString();
    }


    private static boolean sameTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        if(t1.val != t2.val) return false;
        return sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
    }

    public static void main(String[] args) {
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(2);
//        TreeNode t6 = new TreeNode(4);
//        TreeNode t7 = new TreeNode(4);
//
//        t1.left = t2;
//        t1.right = t3;
//        t2.left = t4;
//        t3.left = t5;
//        t3.right = t6;
//        t5.left = t7;


        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;


        List<TreeNode> out = findDuplicateSubtrees(t1);
        out.stream().map(a->a.val).collect(Collectors.toList()).forEach(System.out::print);
    }
}
