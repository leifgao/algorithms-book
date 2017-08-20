package me.leifgao.algorithms.two.chapter.pointTwo;

import me.leifgao.algorithms.two.chapter.pointOne.AbstractSortExample;

/**
 * Created by leif on 2017/8/20
 */
public class MergeBuSort extends AbstractSortExample{

    private static Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz=1; sz<N; sz += sz) {
            for (int low=0; low<N-sz; low+=sz+sz) {
                merge(a, low, low+sz-1, Math.min(low+sz+sz-1, N-1));
            }
        }
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

    public static void main(String[] args) {
        Integer[] a = {5,4,3,2,1};
        MergeBuSort mergeBuSort = new MergeBuSort();
        mergeBuSort.sort(a);
    }
}
