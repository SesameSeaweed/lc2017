package jiuzhang;

import java.util.*;

public class SlidingWindowMedian {
       /*
        * @param nums: A list of integers
        * @param k: An integer
        * @return: The median of the element inside the window at each moving
        */
    public static List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> out = new ArrayList<>();
        TreeSet<Node> maxHeap = new TreeSet<>();

        TreeSet<Node> minHeap = new TreeSet<>();

        int size = (k+1)/2;
        for(int i = 0; i < k-1; i++) {
            add(maxHeap, minHeap, size, new Node(nums[i], i));
        }

        for(int i = k-1; i < nums.length; i++) {
            add(maxHeap, minHeap, size, new Node(nums[i], i));
            out.add(minHeap.last().label);
            remove(maxHeap, minHeap, new Node(nums[i-k+1], i-k+1));
        }
        return out;
    }

    private static void add(TreeSet<Node> maxHeap, TreeSet<Node> minHeap, int size, Node node) {
        if(minHeap.size() < size) {
            minHeap.add(node);
        }else {
            maxHeap.add(node);
        }

        if(minHeap.size() == size) {
            if(maxHeap.size() > 0 && maxHeap.first().label < minHeap.last().label) {
                Node s = minHeap.last();
                Node b = maxHeap.first();
                minHeap.remove(s);
                maxHeap.remove(b);
                minHeap.add(b);
                maxHeap.add(s);
            }
        }
    }

    private static void remove(TreeSet<Node> maxHeap, TreeSet<Node> minHeap, Node node) {
        if(minHeap.contains(node)) {
            minHeap.remove(node);
        } else {
            maxHeap.remove(node);
        }
    }

    private static class Node implements Comparable<Node>{
        int label;
        int index;

        Node(int label, int index) {
            this.label = label;
            this.index = index;
        }
        public int compareTo(Node other) {
            Node a =(Node)other;
            if (this.label == a.label) {
                return this.index - a.index;
            }
            return this.label - a.label;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,7,7,2};
        List<Integer> out = medianSlidingWindow(nums, 3);
        System.out.println(out);
    }

}
