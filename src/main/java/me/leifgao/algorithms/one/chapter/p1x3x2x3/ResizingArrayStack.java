package me.leifgao.algorithms.one.chapter.p1x3x2x3;

import java.util.Iterator;

/**
 * Created by leif on 2017/9/27
 * 动态扩展栈（数组实现）
 */
public class ResizingArrayStack<Item> implements Iterable {

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

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = size;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

    }

    public static void main(String[] args) {
        ResizingArrayStack<String> resizingArrayStack = new ResizingArrayStack<>();
        resizingArrayStack.push("1");
        resizingArrayStack.push("2");
        resizingArrayStack.push("3");
        resizingArrayStack.pop();

        for (Object s : resizingArrayStack) {
            System.out.println(s);
        }
    }
}
