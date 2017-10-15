package me.leifgao.algorithms.one.chapter.p1x3x3x8;

/**
 * Created by leif on 2017/10/15
 * 动态扩展栈（链表实现）
 */
public class Stack<Item> {

    private Node first;
    private int size;

    private class Node {
        Item value;
        Node next;
    }

    public boolean isEmpty() {

        return first == null;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.value = item;
        first.next = oldFirst;
        size++;
    }

    public Item pop() {
        Node oldFirst = first;
        first = first.next;
        size--;
        return oldFirst.value;
    }

    public static void main(String[] args) {

    }
}
