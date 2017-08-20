package me.leifgao.algorithms.two.chapter.pointTwo;

import me.leifgao.algorithms.two.chapter.pointOne.AbstractSortExample;

/**
 * Created by leif on 2017/8/20
 */
public class MergeSort extends AbstractSortExample{
    private static Comparable[] aux;

    public  void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    public static void sort(Comparable[] a, int low, int high) {
        if (high <=low) {
            return;
        }
        int mid = low + (high-low)/2;
        sort(a, low, mid);
        sort(a, mid+1, high);
        merge(a, low, mid, high);
    }

    public static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low, j = mid+1;
        for (int k=low; k<=high; k++) {
            aux[k] = a[k];
        }
        for (int k=low; k<=high; k++) {
            if (i>mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
