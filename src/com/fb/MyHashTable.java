package com.fb;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a hash table
 *
 */
public class MyHashTable<K, V> {
    private List<Node<K, V>> list;
    private int size;

    public MyHashTable(int size){
        list = new ArrayList<Node<K, V>>(size);
        this.size = size;
        for(int i = 0; i < size; i++){
            list.add(null);
        }
    }

    public V get(K key){
        int hashCode = key.hashCode() % size;

        Node<K, V> node = list.get(hashCode);
        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void put(K key, V value){
        int hashCode = key.hashCode() % size;
        Node<K, V> node = list.get(hashCode);
        if(node == null){
            list.set(hashCode, new Node<K, V>(key, value));
        }else{
            Node<K, V> prev = null;
            while(node != null){
                if(node.key.equals(key)){
                    node.value = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node<K, V>(key, value);
        }
    }

    public static class Node<K, V>{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args){
        MyHashTable<Integer, Integer> map = new MyHashTable<Integer, Integer>(5);
        map.put(2, 4);
        map.put(3, 6);
        map.put(4, 8);
        map.put(3, 9);

        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
    }
}
