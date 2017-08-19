
package me.leifgao.algorithms.two.chapter;

import edu.princeton.cs.introcs.StdRandom;

/**
 * Created by leif on 2017/8/19
 */
public class ShellSort extends AbstractSortExample{


    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h<N/3) {
            h = 3*h + 1;
        }

        while (h>=1) {
            for (int i=h; i<N; i++) {
                for (int j=i; j>=h && less(a[j],a[j-h]); j -=h) {
                    exch(a, j, j-h);
                }
            }
            h = h/3;
        }
    }




    public static void main(String[] args) {
        Double[] a = new Double[100000];
        for (int t=0; t<a.length; t++) {
            a[t] = StdRandom.uniform();
        }

        ShellSort shellSort = new ShellSort();
        shellSort.sort(a);

    }
}


