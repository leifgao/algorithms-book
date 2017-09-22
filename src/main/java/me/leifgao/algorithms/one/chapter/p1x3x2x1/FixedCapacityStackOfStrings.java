package me.leifgao.algorithms.one.chapter.p1x3x2x1;

import edu.princeton.cs.introcs.StdOut;

import java.io.File;
import java.util.Scanner;

/**
 * Created by leif on 2017/9/20
 * 定容栈
 */
public class FixedCapacityStackOfStrings {

    private String[] a;
    private int size;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    /**
     * 入栈
     * @param item
     */
    public void push(String item) {
        a[size++] = item;
    }

    /**
     * 出栈
     * @return
     */
    public String pop() {

        return a[--size];
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {

        return this.size ==0;
    }

    /**
     * 栈大小
     * @return
     */
    public int size() {

        return this.size;
    }

    /**
     * 打印出栈内容
     */
    public void printStack() {
        System.out.print("||");
        for (int i=0; i<size; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("||");
        System.out.println();
    }

    public static void main(String[] args) throws Exception{
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);

        Scanner scanner = new Scanner(new File("tobe.txt"));
        while (scanner.hasNext()) {
            String item = scanner.next();

            if (!item.equals("-")) {
                s.push(item);
            }else if (!s.isEmpty()) {
                StdOut.print(s.pop() + "\n");
            }

            s.printStack();
        }
        StdOut.println("定容栈中留了" + s.size + "数据");
    }
}
