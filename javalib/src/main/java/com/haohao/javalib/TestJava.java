package com.haohao.javalib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description :
 *
 * @author Hao Zhao
 * @date 2020/3/13
 */
public class TestJava {


    public static void get11NMumset(){
        Scanner sc = new Scanner(System.in);
        String str="";
        String str1="";
        while(sc.hasNextInt()){
            char[] char1= sc.nextLine().toCharArray();
            for(int i=char1.length-1;i>=0;i--){
                System.out.print(char1[i]);
            }
        }
    }

    public static void  getPasswordOk(){
        Scanner sc =new Scanner (System.in);
        List<String> list =new ArrayList<>();
        List<String> list2 =new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.trim().equals("")){
                for (int i=0;i<list.size();i++) {
                    System.out.print(list.get(i)+" ");
                }
                System.out.println("");
                for (String s:list2){
                    System.out.print(s+" ");
                }
                return;
            }
            String other =delA(line);
           if (other.trim().equals("")){
               list.add(line);
           }else {
               list2.add(line);
           }
        }
        sc.close();
    }

    public static String delNum(String str){
        char[] ch= str.toCharArray();
        String n =null;
//        for (int i=0;i<ch.length;i++){
//            if (ch[i]>='0'&&ch[i]<='9') {
//                 ch[i]=' ';
//            }
//            //n=n+ch[i];
//            if (n==null){
//                n=Character.toString(ch[i]);
//            }else {
//                n=n+ch[i];
//            }
//        }
        n=String.valueOf(ch);
        System.out.print("==="+n.trim());
        return Arrays.toString(ch);
    }

    public static String delA(String str){
        Pattern p1=Pattern.compile("[0-9]");
        Matcher m =p1.matcher(str);
        String a=m.replaceAll("").trim();

        Pattern p2=Pattern.compile("[a-zA-Z]");
        Matcher m2 =p2.matcher(a);
        String a2=m2.replaceAll("").trim();
        return a2;
    }

}
