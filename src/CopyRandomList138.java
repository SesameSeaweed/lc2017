import java.util.HashMap;
import java.util.Map;

public class CopyRandomList138 {
    private static class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

    public static RandomListNode copyRandomList(RandomListNode head) {
       Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode node = head;

        while(node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        node = head;

        while(node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.random;
        }
        return map.get(head);
    }

}
