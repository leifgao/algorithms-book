package me.leifgao.algorithms.one.chapter.p1x3x2x1;

import edu.princeton.cs.introcs.StdOut;

import java.io.File;
import java.util.Scanner;

/**
 * Created by leif on 2017/9/20
 * 定容栈（数组实现）
 */
public class FixedCapacityArrayStack<Item> {

    private Item[] a;
    private int size;

    public FixedCapacityArrayStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    /**
     * 入栈
     * @param item
     */
    public void push(Item item) {
        a[size++] = item;
    }

    /**
     * 出栈
     * @return
     */
    public Item pop() {

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
     * 打印出栈内容(根据size)
     */
    public void printStack() {
        System.out.print("||");
        for (int i=0; i<size; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("||");
        System.out.println();
    }

    /**
     * 当打印出栈底层的整个数组时，会导致不是栈的内容打印
     */
    public void printStackInnerArray() {
        System.out.print("||");
        for (int i=0; i<this.a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("||");
        System.out.println();
    }

    public static void main(String[] args) throws Exception{
        //测试定容栈代码
        FixedCapacityArrayStack<String> s = new FixedCapacityArrayStack<>(100);

        Scanner scanner = new Scanner(new File("tobe.txt"));
        while (scanner.hasNext()) {
            String item = scanner.next();

            if (!item.equals("-")) {
                s.push(item);
            }else if (!s.isEmpty()) {
                StdOut.print(s.pop() + "\n");
            }
        }
        s.printStack();
        s.printStackInnerArray();
        StdOut.println("定容栈中留了" + s.size + "数据");
    }
}
