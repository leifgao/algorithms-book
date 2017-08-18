package me.leifgao.algorithms.two.chapter;

import edu.princeton.cs.introcs.StdOut;

import java.util.List;

/**
 * Created by leif on 2017/8/18
 */
public abstract class AbstractSortExample {

    public abstract void sort(Comparable[] a);

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T> void show(Comparable[] a) {
        for (Comparable comparable : a) {
            StdOut.print(comparable + " ");
        }
        StdOut.println();
    }

    public static <T> void show(List<T> a) {
        for (T comparable : a) {
            StdOut.print(comparable + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }



}
