package me.leifgao.algorithms.two.chapter;

import edu.princeton.cs.introcs.In;

/**
 * Created by leif on 2017/8/18
 */
public class SelectionSort extends AbstractSortExample {


    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i=0; i<N; i++) {
            int min = i;
            for (int j=i+1; j<N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings(args[0]);

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(a);
        show(a);
    }
}
