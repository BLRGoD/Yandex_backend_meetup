package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Quicksort {
    static int partition(List<Long> array, int low, int high) {
        long pivot = array.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array.get(j) <= pivot) {

                i++;

                long temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }
        }
        long temp = array.get(i + 1);
        array.set(i + 1, array.get(high));
        array.set(high, temp);

        return (i + 1);
    }
    static void quickSort(List<Long> array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
}
public class Task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), res = 0;
        List<Long> Ai = new ArrayList<>();
        List<Long> Bi = new ArrayList<>();
        List<Long> platforms = new ArrayList<>();
        for(int i = 0; i < n; i++)
            Ai.add(sc.nextLong());
        for(int i = 0; i < m; i++)
            Bi.add(sc.nextLong());
        long max = Ai.get(n - 1);
        platforms.add(max);
        for(int i = n - 2; i >= 0; i--) {
            long temp = Ai.get(i);
            if(temp >= max) {
                platforms.add(temp - max);
                max = temp;
            }
            else {
                platforms.add((long)0);
            }
        }
        Quicksort.quickSort(Bi, 0, Bi.size() - 1);
        Quicksort.quickSort(platforms, 0, platforms.size() - 1);

        int c = Bi.size() - 1;
        for(int i = platforms.size() - 1; i >= 0; i--) {
            if(c < 0) break;
            if(Bi.get(c) <= platforms.get(i)) {
                res++;
            }
            else {
                i++;
            }
            c--;
        }
        System.out.println(res);
    }
}
