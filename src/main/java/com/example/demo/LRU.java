package com.example.demo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * lru算法
 * <p>
 */
public class LRU {
    private Map<String, Node> map;
    private Node head;
    private Node tail;
    private int limit;

    public LRU(int limit) {
        this.map = new LinkedHashMap<>(limit);
        this.limit = limit;
    }

    class Node {
        private String key;

        private String value;

        private Node next;

        private Node prev;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public Map<String, Node> getMap() {
        return map;
    }

    public void setMap(Map<String, Node> map) {
        this.map = map;
    }

    public String get(String key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        moveNodeToLast(node);
        return node.value;
    }

    public void moveNodeToLast(Node node) {
        if (tail == node) {
            return;
        }
        if (node == head) {
            head = node.next;
            head.prev = null;
            tail.next = node;
            node.next = null;
            node.prev = tail;
        } else {
            node.prev.next = node.next;
            tail.next = node;
            tail = node;
            node.next = null;
        }
        map.remove(node.key);
        map.put(node.key, node);
    }

    public void put(String key, String value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            if (head == null) {
                head = node;
                tail = node;
            } else if (map.size() >= limit) {
                removeFirstNode();
            } else {
                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;
            }
        } else {
            node.value = value;
            moveNodeToLast(node);
            map.remove(node.key);
        }
        map.put(key, node);
    }

    public void removeFirstNode() {
        map.remove(head.key);
        head.next.prev = null;
        head = head.next;
    }

    public static void main(String[] args) {
        LRU ss = new LRU(5);
        ss.put("1", "3");
        ss.put("2", "4");
        ss.put("3", "6");
        ss.put("4", "1");
        ss.put("5", "5");
        System.out.println(ss.getMap().keySet());
        ss.get("1");
        System.out.println(ss.getMap().keySet());
        ss.put("6","7");
        System.out.println(ss.getMap().keySet());
    }

}
