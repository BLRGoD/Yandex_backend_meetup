package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> stakan = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        List<String> symbol = new ArrayList<>();
        System.out.println();
        for(int i = 0; i < n; i++) {
            stakan.add(sc.nextLine());
        }
        int k = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < k; i++) {
            String[] temp = sc.nextLine().split(" ");
            count.add(Integer.parseInt(temp[1]));
            symbol.add(temp[2]);
        }

        for(int q = 0; q < k; q++) {
            for(int j = 0; j < count.get(q); j++) {
                stakan.set(n - 2, stakan.get(n - 2).replace(" ", symbol.get(q)));
                n--;
            }
        }

        for(String s : stakan)
            System.out.println(s);
    }
}