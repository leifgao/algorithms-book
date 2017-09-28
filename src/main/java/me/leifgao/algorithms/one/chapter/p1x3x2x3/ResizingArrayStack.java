package me.leifgao.algorithms.one.chapter.p1x3x2x3;

/**
 * Created by leif on 2017/9/27
 * 动态扩展栈（数组实现）
 */
public class ResizingArrayStack<Item> {

    private Item[] a; //数组实现动态栈
    private int size; //动态扩展栈大小

    private static final int DEFAULT_SIZE = 100;


    public ResizingArrayStack() {
        this(DEFAULT_SIZE);
    }

    public ResizingArrayStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public Item pop() {
        Item result = a[--size];
        a[size] = null;
        if (size > 0 && size == a.length/4) {
            resize(a.length/2);
        }
        return result;
    }

    public  void push(Item item) {
        if (size == a.length) {
            resize(a.length * 2);
        }
        a[size++] = item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
}
