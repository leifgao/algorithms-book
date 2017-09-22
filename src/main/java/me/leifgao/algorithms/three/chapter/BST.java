package me.leifgao.algorithms.three.chapter;

import java.security.Key;

/**
 * Created by leif on 2017/8/24
 */
public class BST <K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int N;

        public Node(K key, V value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    public V get(K key) {
        return get(root, key);
    }

    public V get(Node x, K key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    public Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;




//        if (x.N == 0) {
//            int cmp = key.compareTo(x.key);
//
//            if (cmp < 0) {
//                x.left = new Node(key, value, 0);
//            } else {
//                x.right = new Node(key, value, 0);
//            }
//            x.N++;
//        }
//        int cmp = key.compareTo(x.key);
//        if (cmp < 0) {
//            put(x.left, key, value);
//        } else if (cmp > 0) {
//            put(x.right, key, value);
//        } else {
//            //更新key的value
//            x.value = value;
//        }
    }

//    public void select();
//    public void rank();
//    public void delete();
//    public void deleteMin();
//    public void deleteMax();
//    public void keys();

}
