package com.f4rrari.day01;

public class 九九乘法表 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%-4d", j, i, j*i);
            }
            System.out.println();
        }
    }
}
