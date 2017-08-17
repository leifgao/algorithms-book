package me.leifgao.algorithms.one.chapter;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.Stopwatch;

import java.util.Arrays;

/**
 * Created by leif on 2017/8/17
 */
public class ThreeSumFast {

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Stopwatch timer = new Stopwatch();
        StdOut.println(count(a));
        double time = timer.elapsedTime();
        System.out.println("fast算法时间:" + time);
    }


    public static int count(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                if (BinarySearch.rank(-a[i]-a[j], a) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
