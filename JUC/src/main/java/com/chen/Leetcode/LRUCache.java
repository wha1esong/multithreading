package com.chen.Leetcode;


import java.util.HashMap;

public class LRUCache {
    int size;
    int capacity;
    DLinkNode head;
    DLinkNode tail;
    HashMap<Integer, DLinkNode> cache = new HashMap<>();

    class DLinkNode {
        int key;
        int val;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public DLinkNode() {

        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkNode dLinkNode = cache.get(key);
        if (dLinkNode == null) {
            return -1;
        }
        moveToHead(dLinkNode);
        return dLinkNode.val;

    }

    private void moveToHead(DLinkNode dLinkNode) {
        removeNode(dLinkNode);
        addToHead(dLinkNode);
    }

    private void addToHead(DLinkNode dLinkNode) {
        dLinkNode.next = head.next;
        dLinkNode.prev = head;
        head.next.prev = dLinkNode;
        head.next = dLinkNode;
    }

    private void removeNode(DLinkNode dLinkNode) {
        dLinkNode.prev.next = dLinkNode.next;
        dLinkNode.next.prev = dLinkNode.prev;
    }

    public void put(int key, int val) {
        DLinkNode dLinkNode = cache.get(key);
        if (dLinkNode == null) {
            DLinkNode newNode = new DLinkNode(key, val);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DLinkNode ret = removeTail();
                cache.remove(ret.key);
                size--;
            }
        } else {
            dLinkNode.val = val;
            moveToHead(dLinkNode);
        }
    }

    private DLinkNode removeTail() {
        DLinkNode ret = tail.prev;
        removeNode(ret);
        return ret;
    }

}
