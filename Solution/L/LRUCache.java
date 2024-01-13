package Solution.L;

import java.util.HashMap;

public class LRUCache {
    private static class Node{
        public int key;
        public int value;
        public Node prev;
        public Node next;
    }

    private int size;
    private final int capacity;
    private final Node head;
    private final Node tail;
    private final HashMap<Integer, Node> map;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<>();
    }

    private void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node target = map.get(key);
        delete(target);
        insert(target);
        return target.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value = value;
            this.get(key);
        }else if(size < capacity){
            size++;
            Node target = new Node();
            target.key = key;
            target.value = value;
            insert(target);
            map.put(key, target);
        }else{
            Node lastNode = tail.prev;
            map.remove(lastNode.key);
            delete(lastNode);
            size--;
            put(key, value);
        }
    }
}