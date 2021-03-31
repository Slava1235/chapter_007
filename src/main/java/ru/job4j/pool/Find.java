package ru.job4j.pool;

public class Find {
    public static Integer linearSearch(int[] array,int from , int to, int elementToSearch) {
        for (int index = from; index < to; index++) {
            if (array[index] == elementToSearch)
                return index;
        }
        return -1;
    }
}
