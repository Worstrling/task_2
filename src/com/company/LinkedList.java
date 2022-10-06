package com.company;

public class LinkedList<T> {
    public static class LinkedListNodeException extends Exception {
        public LinkedListNodeException(String message) {
            super(message);
        }
    }

    private class LinkedListNode {
        public T value;
        public LinkedListNode next;

        public LinkedListNode(T value, LinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public LinkedListNode(T value) {
            this(value, null);

        }


    }

    private LinkedListNode head;
    private LinkedListNode tail;
    private int size;

    public void addFirst(T value) {
        head = new LinkedListNode(value, head);
        tail = new LinkedListNode(value, tail);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(T value) {
        if (size == 0) {
            head = tail = new LinkedListNode(value);

        } else {
            tail.next = new LinkedListNode(value);
            tail = tail.next;
        }
        size++;

    }

    private void EmptyError() throws Exception {
        if (size == 0) {
            throw new LinkedListNodeException("Empty list!");
        }
    }

    public void removeFirst() throws Exception {
        EmptyError();
        head = head.next;
        if (size == 1) {
            tail = null;

        }
        size--;

    }

    public LinkedListNode getNode(int index) {
        LinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void removeLast() throws Exception {
        EmptyError();
        if (size == 1) {
            head = tail = null;
        } else {
            tail = getNode(size - 2);
            tail.next = null;
        }

    }

    public void removeIndex(int index) throws LinkedListNodeException {
        if (index > 0 || index > size) {
            throw new LinkedListNodeException("Invalid index!");

        }
        if (size == 1) {
            head = tail = null;
        } else {
            LinkedListNode temp = getNode(index - 1);
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;

            }
        }

    }

    public T get(int index) throws Exception {
        EmptyError();
        return getNode(index).value;


    }

    public T getFirst() throws Exception {
        EmptyError();
        return head.value;

    }

    public int getSize() {
        return size;
    }

    public T getTail() {
        return tail.value;
    }

    public void removeN_K(int n, int k) throws Exception {
        LinkedListNode temp_n = getNode(n - 1);
        LinkedListNode temp_k = getNode(k);
        if (n > size || k > size || n >= k || k == 0) {
            throw new LinkedListNodeException("Invalid n or k!");
        }
        if (n == 0) {
            head = temp_k.next;
            size = size - k - 1;
        } else {
            if (k == size) {
                size = size - (k - n) - 1;
            } else {
                temp_n.next = temp_k.next;
                size = size - (k - n) - 1;
            }
        }
    }
}