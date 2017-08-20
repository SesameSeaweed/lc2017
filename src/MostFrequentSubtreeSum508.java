import java.util.*;
import java.util.stream.Collectors;

public class MostFrequentSubtreeSum508 {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static int[] findFrequentTreeSum(TreeNode root) {

        Map<TreeNode, List<Integer>> map = new HashMap<>();
        treePath(root, map);
        List<Integer> temp = new ArrayList<>();
         int max = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for(Map.Entry<TreeNode, List<Integer>> entry : map.entrySet()) {
            for(Integer num : entry.getValue()) {
                if(countMap.containsKey(num)) {
                    countMap.put(num, countMap.get(num)+1);
                }else {
                    countMap.put(num, 1);
                }

                max = Math.max(max, countMap.get(num));
            }
        }

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == max) {
                temp.add(entry.getKey());
            }
        }
        int[] outArray = new int[temp.size()];

        for(int i = 0; i < temp.size(); i++) {
            outArray[i] = temp.get(i);
        }
        return outArray;
    }

    private static List<Integer> treePath(TreeNode root, Map<TreeNode, List<Integer>> map) {
        if(root == null) return new ArrayList<>();
        if(map.containsKey(root)) return map.get(root);
        if(root.left == null && root.right == null) {
            map.put(root, Arrays.asList(root.val));
            return Arrays.asList(root.val);
        }
        List<Integer> out = new ArrayList<>();

        if(root.left != null) {
            List<Integer> left = treePath(root.left, map);
            left = left.stream().map(t->t+root.val).collect(Collectors.toList());
            map.put(root, left);
            out.addAll(left);
        }

        if(root.right != null) {
            List<Integer> right = treePath(root.right, map);
            right = right.stream().map(t->t+root.val).collect(Collectors.toList());
            map.put(root, right);
            out.addAll(right);
        }
        map.put(root, out);
        return out;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(-3);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
//        t2.right = t4;
//        t3.left = t5;
//        List<Integer> path = treePath(t1);
        int[] out = findFrequentTreeSum(t1);;
//        System.out.println(path);
        System.out.println(Arrays.toString(out));
    }
}
