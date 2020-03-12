package com.serions.searching;

import java.util.Stack;

public class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;
    public static final int FRONT = 1;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeafNode(int pos) {
        return (pos >= (size / 2) && pos <= size);
    }

    // swap nodes of the heap
    private void swap(int fpos, int spos) {
        int temp;
        temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }

    // heapify the node at pos
    private void minHeapify(int pos) {
        // if node is not a leaf node and greater than any of is children
        if (!isLeafNode(pos)) {
            if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                // swap with the left child and heapify
                if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    // swap with the right child and heapify
                    swap(pos, rightChild(pos));
                    minHeapify(pos);
                }
            }
        }
    }

    // inserts a node to the heap
    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }
        heap[++size] = element;
        int current = size;

        while(heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

   public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i] + " LEFT: " + heap[2 * i] + " RIGHT: " + heap[2 * i + 1]);
            System.out.println();
        }
   }

   // Remove root
   public int pop() {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return popped;
   }

   public int peek() {
        return heap[FRONT];
   }

   // build the min heap using the min Heapify
   public void minHeap() {
        for (int pos = size / 2; pos >= 1; pos--) {
            minHeapify(pos);
        }
   }

    public static void main(String[] args) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();

        minHeap.print();
        System.out.println("The Min val is " + minHeap.peek());
    }
}
