package com.lin.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxiaojia
 * @date 2023/5/25 14:47
 * @Description:
 */
public class LeetCode146LRU缓存 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,2);
        cache.put(2,3);
        cache.put(3,4);
        cache.put(4,5);
    }

    static class LRUCache {

        static class DListNode{
            private int key;
            private int value;
            private DListNode prev;
            private DListNode next;

            public DListNode(){

            }

            public DListNode(int key, int value){
                this.key = key;
                this.value = value;
            }
        }

        private int capacity;
        private DListNode head;
        private DListNode tail;
        private Map<Integer, DListNode> map = new HashMap<>();
        private int size;

        public LRUCache(int capacity) {
            this.head = new DListNode();
            this.tail = new DListNode();
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
            this.size = 0;
        }

        public void addToHead(DListNode node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(DListNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void moveToHead(DListNode node){
            removeNode(node);
            addToHead(node);
        }

        public DListNode removeTail(){
            DListNode lastNode = tail.prev;
            removeNode(lastNode);
            return lastNode;
        }

        public int get(int key) {
            DListNode node = map.get(key);
            if(node == null) return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DListNode node = map.get(key);
            if(node == null){
                node = new DListNode(key, value);
                map.put(key, node);
                addToHead(node);
                size++;
                if(size > capacity){
                    DListNode lastNode = removeTail();
                    map.remove(lastNode.key);
                    size--;
                }
            }else{
                node.value = value;
                moveToHead(node);
            }
        }
    }
}
