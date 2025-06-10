/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        // 1st pass: create all nodes and store mapping (original -> clone)
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // 2nd pass: assign next and random pointers
        curr = head;
        while (curr != null) {
            Node clone = map.get(curr);
            clone.next = map.get(curr.next);     // may be null
            clone.random = map.get(curr.random); // may be null
            curr = curr.next;
        }

        return map.get(head);  // return cloned head
    }
}
