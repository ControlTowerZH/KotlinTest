package com.haohao.javalib;

import java.util.Scanner;
import java.util.TreeSet;

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
//        int i = 0;
//        while (i < 5) {
//            i++;
//            System.out.println("输出i=" + i);
//        }
        System.out.println("开始");
//        while (scanner.hasNextLine()) {
//            String s1 = scanner.nextLine();
//            //int a = scanner.nextInt();
//            System.out.println("输出的line为：" + s1);
//            //System.out.println("输出的int为：" + a);
//        }
//        while (scanner.hasNextInt()) {
//            int b = scanner.nextInt();
//            sum = sum + b;
//            i++;
//            System.out.println("输出的b为：" + b);
//        }
//        System.out.println("结束" + sum / i);
//        scanner.close();
        //getLastStr();
        //get2();
        //get3Tree();
        //get4String();
        //get5go2();
        //get6long();
        //get7Over();
       TestJava.getPasswordOk();
    }

    private static void get7Over() {
        Scanner scanner = new Scanner(System.in);
        double num;
        int n =0;
        while (scanner.hasNextDouble()){
            num = scanner.nextDouble();
            num+=0.5;
            n=(int )num;
            System.out.println(n);
        }

    }

    private static void get1LastStr(){
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()){
            String str =scanner.nextLine();
            String [] arr= str.split(" ");
            System.out.println(arr[arr.length-1].length());
        }
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            System.out.println(s.length()-1-s.lastIndexOf(" "));
        }
    }

    private static void get2(){
        Scanner scanner =new Scanner(System.in);

        String str= scanner.nextLine();
        String str1= scanner.nextLine();
        char c= str1.charAt(0);
        System.out.println("c="+c);
        int sum=0;
        for (int i=0;i<str.length();i++){
            if (str.toUpperCase().charAt(i)==c||str.toLowerCase().charAt(i)==c){
                System.out.println("str="+str.toUpperCase().charAt(i));
                sum++;
            }
        }
        System.out.println(sum);
    }

    private static void get3Tree(){
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()){
            TreeSet<Integer> set =new TreeSet<Integer>();
            int n = scanner.nextInt();
            if (n > 0) {
                for (int i=0;i<n;i++){
                    set.add(scanner.nextInt());
                }
            }
            for (Integer i:set){
                System.out.println(i);
            }
        }
    }
    private static void get4String(){
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s =scanner.nextLine();
            while (s.length()>8){
                System.out.println(s.substring(0,8));
                s=s.substring(8);
            }
            if (s.length()<8&&s.length()>0){
                s=s+"00000000";
                System.out.println(s.substring(0,8));
            }
        }
    }
    private static void get5go2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next().substring(2);
            System.out.println(Integer.parseInt(str,16));
        }
    }

    private static void get6long(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()){
            long num= scanner.nextLong();

            long t =num;
            for (int i=2;i<=t;i++){
                while (num%i==0){
                    num =num/i;
                    System.out.println(i+" ");
                }
            }
        }
    }

}
