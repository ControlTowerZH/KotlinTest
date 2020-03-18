package com.haohao.javalib.single;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class queue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();//输入数
            int t = input;//被除数
            int u = 0;//余数
            Deque<Integer> deque = new LinkedList<>();
            do {
                u = t % 2;
                t = t / 2;
                deque.push(u);
            } while (t > 0);

            System.out.print(input + "的二进制是");

            while (!deque.isEmpty()) {
                System.out.print(deque.pop());
            }
            System.out.println();
        }
    }
}
