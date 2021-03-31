package ru.job4j.pool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FindIndex extends RecursiveTask<Integer> {
    private final int[] array;
    private final int from;
    private final int to;
    private final int elementToSearch;

    public FindIndex(int[] array, int from, int to, int elementToSearch) {
        this.array = array;
        this.from = from;
        this.to = to;
        this.elementToSearch = elementToSearch;
    }

    @Override
    protected Integer compute() {
        int result;
        if (to - from < 10) {
            result = Find.linearSearch(array, from, to, elementToSearch);
            return result;
        }
        int mid = (from + to) / 2;
        FindIndex leftSort = new FindIndex(array, from, mid, elementToSearch);
        FindIndex rightSort = new FindIndex(array, mid + 1, to, elementToSearch);
        leftSort.fork();
        rightSort.fork();
        int left = leftSort.join();
        int right = rightSort.join();
        if (left == right) {
            return -1;
        } else {
            return Integer.max(left, right);
        }
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(forkJoinPool.invoke(new FindIndex(ar, 0, ar.length - 1, 4)));
    }
}