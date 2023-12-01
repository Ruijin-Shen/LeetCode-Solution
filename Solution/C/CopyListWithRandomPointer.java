package Solution.C;

public class CopyListWithRandomPointer {
}

class Solution138 {
     private class Node {
     int val;
     Node next;
     Node random;

         public Node(int val) {
             this.val = val;
             this.next = null;
             this.random = null;
         }
     }

    public Node copyRandomList(Node head) {
        if(head == null) return null;

        // Copy the nodes.
        Node node = head;
        while(node != null){
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }

        // Create random ptr.
        node = head;
        while(node != null){
            node.next.random = (node.random == null) ? null : node.random.next;
            node = node.next.next;
        }

        node = head;
        Node result = node.next;
        Node newHead = result;
        while(node != null){
            node.next = node.next.next;
            node = node.next;
            newHead.next = (node == null) ? null : node.next;
            newHead = newHead.next;
        }
        return result;
    }
}