package me.leifgao.algorithms.two.chapter;

/**
 * Created by leif on 2017/8/19
 */
public class InsertionSort extends AbstractSortExample{


    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i=1; i<N; i++) {
            for (int j =i; j >0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
    }
}
