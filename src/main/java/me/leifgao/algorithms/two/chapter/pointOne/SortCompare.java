package me.leifgao.algorithms.two.chapter.pointOne;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.Stopwatch;

/**
 * Created by leif on 2017/8/19
 */
public class SortCompare {

    public static void main(String[] args) {

        String alg1= "me.leifgao.algorithms.two.chapter.InsertionSort";
        String alg2 = "me.leifgao.algorithms.two.chapter.ShellSort";
        int N = 100000;
        int T = 1;
        double alg1Time = timeRandomInput(alg1, N, T);
        System.out.println(alg1 + "的运行时间是:" + alg1Time);
        double alg2Time = timeRandomInput(alg2, N, T);
        System.out.println(alg2 + "的运行时间是:" + alg2Time);
        System.out.println(alg2 + "is" + alg1Time/alg2Time);

    }

    private static double time(String algClazz, Double[] a) {
        //用反射调用排序方法
        try {
            Stopwatch timer = new Stopwatch();
            Class algClass = Class.forName(algClazz);
            AbstractSortExample abstractSortExample = (AbstractSortExample) algClass.newInstance();
            abstractSortExample.sort(a);
            return timer.elapsedTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    private static double timeRandomInput(String alg, int N, int T) {
        //N表示数组大小，T表示数组数量
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t=0; t<T; t++) {
            for (int i=0; i<N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }
}
