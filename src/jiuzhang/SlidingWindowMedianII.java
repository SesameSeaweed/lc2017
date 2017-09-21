package jiuzhang;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class SlidingWindowMedianII {

    public static List<Integer> medianSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        List<Integer> out = new ArrayList<>();

        TreeSet<Node> maxHeap = new TreeSet<>(new Comparator<Node>() {
            @Override public int compare(Node o1, Node o2) {
                if(o2.label == o1.label) return o1.index - o2.index;
                return o2.label - o1.label;
            }
        });

        TreeSet<Node> minHeap = new TreeSet<>(new Comparator<Node>() {
            @Override public int compare(Node o1, Node o2) {
                if(o2.label == o1.label) return o1.index - o2.index;
                return o1.label - o2.label;
            }
        });

        int size = (k + 1) / 2;
        for(int i = 0; i < k-1; i++) {
            add(minHeap, maxHeap, size, new Node(nums[i], i));
        }

        for(int i = k-1; i < nums.length; i++) {
            add(minHeap, maxHeap, size, new Node(nums[i], i));
            out.add(minHeap.last().label);
            delete(minHeap, maxHeap, new Node(nums[i-k+1], i-k+1));
        }
        return out;
    }

    private static void add(TreeSet<Node> minHeap, TreeSet<Node> maxHeap, int size, Node node) {
        if(minHeap.size() < size) {
            minHeap.add(node);
        }else {
            maxHeap.add(node);
        }

        if(minHeap.size() == size) {
            if(maxHeap.size() > 0 && maxHeap.last().label < minHeap.last().label) {
                Node temp1 = minHeap.last();
                Node temp2 = maxHeap.last();

                minHeap.remove(temp1);
                maxHeap.remove(temp2);

                minHeap.add(temp2);
                maxHeap.add(temp1);
            }
        }
    }

    private static void delete(TreeSet<Node> minHeap, TreeSet<Node> maxHeap, Node node) {
        if(minHeap.contains(node)) {
            minHeap.remove(node);
        }else {
            maxHeap.remove(node);
        }
    }


    private static class Node {
        int label;
        int index;

        Node(int label, int index) {
            this.label = label;
            this.index = index;
        }
    }

    public static void main(String[] args){
//        int[] nums = {1,2,7,7,2};
        int[] nums = {142,38,100,53,22,84,168,50,194,136,111,13,47,45,151,164,126,47,106,124,183,8,87,38,91,121,102,46,82,195,53,18,11,165,61};
        int k = 35;
        List<Integer> out = medianSlidingWindow(nums, k);
        System.out.print(out);
    }
}
