package me.leifgao.algorithms.one.chapter;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.Stopwatch;

/**
 * Created by leif on 2017/8/16
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Stopwatch timer = new Stopwatch();
        StdOut.println(count(a));
        double time = timer.elapsedTime();
        System.out.println(time);
    }

    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                for (int k=j+1; k<N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
