package me.leifgao.algorithms.one.chapter;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Arrays;

/**
 * Created by leif on 2017/8/14
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] whiteArray = new int[]{1,2,3,4,5};
        Arrays.sort(whiteArray);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whiteArray) < 0) {
                StdOut.println(key);
            }
        }
    }

    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
