package me.leifgao.algorithms.three.chapter;

/**
 * Created by leif on 2017/8/22
 */
public class SequentialSearchST<K, V> {

    private Node first;

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> sst = new SequentialSearchST<>();
        sst.put("s",0);
        sst.put("e",1);
        sst.put("a",2);
        sst.put("r",3);
        sst.printSST();
        sst.delete("e");
        sst.printSST();

    }

    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public V get(K key) {
        for (Node n=first; n!= null; n=n.next) {
            if (key.equals(n.key)) {
                return n.value;
            }
        }
        return null;
    }

    /**
     * 顺序插入 <k,v>, 当key相同时更新key对应的键值,否则新建节点
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        for (Node n=first; n!=null; n=n.next) {
            if (key.equals(n.key)) {
                n.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException("delete key is null");
        }
        first = delete(first, key);
    }

    public Node delete(Node n, K key) {
        if (n == null) {
            return null;
        }
        if (key.equals(n.key)) {
            return n.next;
        }
        n.next = delete(n.next, key);
        return n;
    }

    private void printSST() {
        for (Node n=first; n!=null; n=n.next) {
            System.out.print("|"+n.key+":"+n.value + "|" + (n.next == null ? "\n" : "--->"));
        }
    }
    //commit测试

}
