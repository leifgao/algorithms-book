package me.leifgao.algorithms.two.chapter.pointThree;

import edu.princeton.cs.introcs.StdRandom;
import me.leifgao.algorithms.two.chapter.pointOne.AbstractSortExample;

/**
 * Created by leif on 2017/8/20
 */
public class QuickSort extends AbstractSortExample{
    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high<=low) {
            return;
        }
        int j = partition(a, low, high);
        sort(a, low, j-1);
        sort(a, j+1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        Comparable mid = a[low];
        int i = low;
        int j = high + 1;
        while(true) {
            while (less(a[++i], mid)) {
                if (i == high) {
                    break;
                }
            }
            while (less(mid, a[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i>=j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }
}
