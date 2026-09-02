package com.f4rrari.day01;

import java.util.Scanner;

public class 字符菱形 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入菱形的行数（奇数）：");
        int n = scanner.nextInt();

        // 判断是否为奇数，如果是偶数则提示并退出
        if (n % 2 == 0) {
            System.out.println("请输入奇数！");
            return; // 结束程序
        }

        int mid = n / 2 + 1;

        for (int i = 1; i <= n; i++) {
            int spaces = Math.abs(mid - i);
            int stars = 2 * (mid - spaces) - 1;

            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close(); // 关闭扫描器
    }
}