package com.github.adrianosiqueira.sortalgorithmbenchmark.algorithms;

import java.util.Comparator;

public class TreeSort<T> extends SortAlgorithm<T> {

    private Comparator<T> comparator;
    private Node<T>       root                = null;
    private int           finalInsertionIndex = 0;

    @Override
    public void sort(T[] array, Comparator<T> comparator) {
        this.comparator = comparator;

        insertInTree(array);
        inOrderRecursive(root, array);
    }

    private void inOrderRecursive(Node<T> root, T[] array) {
        if (root != null) {
            inOrderRecursive(root.left, array);

            array[finalInsertionIndex] = root.key;
            finalInsertionIndex++;

            inOrderRecursive(root.right, array);
        }
    }

    private void insert(T key) {
        root = insertRecursive(root, key);
    }

    private void insertInTree(T[] array) {
        for (T j : array) {
            insert(j);
        }
    }

    private Node<T> insertRecursive(Node<T> root, T key) {
        if (root == null) {
            root = new Node<>(key);
            return root;
        }

        if (comparator.compare(key, root.key) <= 0) {
            root.left = insertRecursive(root.left, key);
        } else if (comparator.compare(key, root.key) > 0) {
            root.right = insertRecursive(root.right, key);
        }

        return root;
    }

    private static class Node<T> {
        public T       key;
        public Node<T> left;
        public Node<T> right;

        public Node(T item) {
            key   = item;
            left  = null;
            right = null;
        }
    }
}
