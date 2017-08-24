package me.leifgao.algorithms.three.chapter;

import java.security.Key;

/**
 * Created by leif on 2017/8/23
 */
public class BinarySearchST<K extends Comparable<K>, V>{

    private K[] keys;
    private V[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (K[]) new Comparable[capacity];
        values = (V[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0 ;
    }

    public V get(K key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    public void put(K key, V value) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j=N; j>i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public void delete(K key) {
        int i = rank(key);
        if (i<N && keys[i].compareTo(key) == 0) {
            if (i<N && keys[i].compareTo(key) == 0) {
                for (int j = i; j<N-1; j++) {
                    keys[i] = keys[i+1];
                    values[i] = values[i+1];
                }
                keys[N-1] = null;
                values[N-1] = null;
            }
        }
    }

    /**
     * 递归的二分查找
     * @param key
     * @param low
     * @param high
     * @return
     */
    public int rank(K key, int low, int high) {
        if (high < low) {
            return low;
        }
        int mid = low + (high - low)/2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rank(key, low, mid -1);
        } else if (cmp > 0) {
            return rank(key, mid + 1, high);
        } else {
            return mid;
        }
    }

    public int rank(K key) {
        int low = 0;
        int high = N-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            int cmp = key.compareTo(keys[mid]);

            if (cmp < 0) {
                high = mid -1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public K min() {
        return keys[0];
    }

    public K max() {
        return keys[N-1];
    }

    public K select(int k) {
        return keys[k];
    }
}
