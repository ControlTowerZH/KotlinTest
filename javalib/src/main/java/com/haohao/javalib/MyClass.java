package com.haohao.javalib;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0;
        int m = 0;
//         while(scanner.hasNextDouble()){
//             double x= scanner.nextDouble();
//             m=m+1;
//             sum=sum+x;
//         }
//         System.out.println(m+"个数的和为"+sum);
//         System.out.println(m+"个数的平均值为"+(sum/m));
//         scanner.close();
        int i = 0;
        while (i < 5) {
            i++;
            System.out.println("输出i=" + i);
        }
        System.out.println("开始");
//        while (scanner.hasNextLine()) {
//            String s1 = scanner.nextLine();
//            //int a = scanner.nextInt();
//            System.out.println("输出的line为：" + s1);
//            //System.out.println("输出的int为：" + a);
//        }
        while (scanner.hasNextInt()) {
            int b = scanner.nextInt();
            sum = sum + b;
            i++;
            System.out.println("输出的b为：" + b);
        }
        System.out.println("结束" + sum / i);
        scanner.close();
    }
}
