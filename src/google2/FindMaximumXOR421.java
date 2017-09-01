package google2;

public class FindMaximumXOR421 {
    private static class TrieNode {
        int val;
        TrieNode[] child = new TrieNode[2];
        public TrieNode(int val, TrieNode[] child) {
            this.val = val;
            this.child = child;
        }
    }

    private static TrieNode root = new TrieNode(Integer.MAX_VALUE, new TrieNode[2]);

    public static int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        for(int num : nums) {
            TrieNode curr = root;
            for(int i = 31; i >= 0; i--) {
                int currBit = ((num >>> i) & 1);
                if(curr.child[currBit]==null) {
                    curr.child[currBit] = new TrieNode(currBit, new TrieNode[2]);
                }
                curr = curr.child[currBit];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int num : nums ) {
            TrieNode curr = root;
            int sum = 0;
            for(int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if(curr.child[curBit ^ 1] != null) {
                    sum += (1 << i);
                    curr = curr.child[curBit ^ 1];
                }else {
                    curr = curr.child[curBit];
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(nums));
    }
}
