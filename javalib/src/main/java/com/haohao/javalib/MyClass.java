package com.haohao.javalib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        //get8merge();
        //get9NewInt();
        //get10DifferentNum();
        //get12BackString();
        //get11BackInt();
        //get13BackSentence();
        //get14StrSort();
        //get15to2Num();
        get17TwoAddress();
    }
    private static void get20Password() {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNextLine()){
            String pw=scan.nextLine();

            System.out.println(tf(pw));
        }

    }

    public static String tf(String pw){
        if(pw.length()<=8){
            return ("NG");

        }

        for(int i=0;i<pw.length()-3;i++){//去除包含的子串
            if (pw.substring(i+3,pw.length()).contains(pw.substring(i,i+3))){
                return("NG");
            }
        }


        int []count =new int[4];
        for(int i=0;i<pw.length();i++){

            if('A'<=pw.charAt(i)&&pw.charAt(i)<='Z'){
                count[0]=1;
            }
            if('a'<=pw.charAt(i)&&pw.charAt(i)<='z'){
                count[1]=1;
            }
            if('0'<=pw.charAt(i)&&pw.charAt(i)<='9'){
                count[2]=1;
            }
            else{
                count[3]=1;
            }

        }
        if(count[0]+count[1]+count[2]+count[3]<3){
            return("NG");

        }

        return("OK");
    }

//纯粹的考代码实现能力
//记录个数，故使用Map，不需要排序故使用HashMap，根据题意是要循环输出，而且提交一次会有测试用例提示，
// 需要按照输入顺序输出，故使用LinkedHashMap
////在输出的时候，题目的意思是循环八个，但问题是必须记录全部错误个数，否则刚记录完后弹出了，
// 错误数就对不上了，跟操作系统里的缺页有那么点相似。
    private static void get19FileSubstring(){
        Scanner sc=new Scanner(System.in);
        Map<String, Integer> map=new LinkedHashMap<String, Integer>();
        while(sc.hasNext()){
            String str=sc.next();
            int linenum=sc.nextInt();
            String[] arr=str.split("\\\\");  //根据\切割
            String s=arr[arr.length-1];
            if(s.length()>16)  //截取
                s=s.substring(s.length()-16);
            String key=s+" "+linenum;
            int value=1;
            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else {
                map.put(key, value);
            }
        }
        int count=0;
        for(String string:map.keySet()){
            count++;
            if(count>(map.keySet().size()-8)) //输出最后八个记录
                System.out.println(string+" "+map.get(string));
        }
    }



    private static void get18Ip() {
        Scanner scanner = new Scanner(System.in);
        int typeA = 0;
        int typeB = 0;
        int typeC = 0;
        int typeD = 0;
        int typeE = 0;
        int errorIpOrMaskCode = 0;
        int privIp = 0;

        while (scanner.hasNext()) {
            String ipt = scanner.nextLine();
            String[] ipAndMaskCode = ipt.split("~");
            String ip = ipAndMaskCode[0];
            String maskCode = ipAndMaskCode[1];
            // 判断格式
            if (!isValidFormat(ip) || !isValidFormat(maskCode)) {
                errorIpOrMaskCode++;
                continue;
            }

            // 判断掩码是否错误
            if (!validMaskCode(maskCode)) {
                errorIpOrMaskCode++;
                continue;
            }

            // 判断ip类别
            String fnStr = ip.substring(0, ip.indexOf("."));
            int fn = Integer.valueOf(fnStr);
            if (fn >= 1 && fn < 127) {
                // A
                typeA++;
            } else if (fn >= 128 && fn < 192) {
                // B
                typeB++;
            } else if (fn >= 192 && fn < 224) {
                // C
                typeC++;
            } else if (fn >= 224 && fn < 240) {
                // D
                typeD++;
            } else if (fn >= 240 && fn <= 255) {
                // E
                typeE++;
            }

            // 判断是否是私网IP
            String ipSubStr = ip.substring(ip.indexOf(".") + 1);
            String snStr = ipSubStr.substring(0, ipSubStr.indexOf("."));
            int sn = Integer.valueOf(snStr);
            if (fn == 10 || (fn == 172 && sn >= 16 && sn <= 31) || (fn == 192 && sn == 168)) {
                privIp++;
            }
//          System.out.printf("%d %d%n", fn, sn);

        }
        scanner.close();

        System.out.printf("%d %d %d %d %d %d %d%n", typeA, typeB, typeC, typeD, typeE, errorIpOrMaskCode, privIp);

    }

    /**
     * 判断ip和掩码是否是xxx.xxx.xxx.xxx格式Ø
     *
     * @param ip
     * @return
     */
    private static boolean isValidFormat(String ip) {
        boolean res = true;
        if (ip == null || "".equals(ip))
            return false;
        Pattern pattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");
        Matcher matcher = pattern.matcher(ip);

        if (matcher.matches()) {
            String[] nums = ip.split("\\.");
            for (String num : nums) {
                int n = Integer.valueOf(num);
                if (n < 0 || n > 255) {
                    res = false;
                    break;
                }
            }
        } else {
            res = false;
        }

        return res;
    }

    /**
     * 判断掩码是否是前面全为1后面全为0 的格式
     *
     * @param maskCode
     * @return
     */
    private static boolean validMaskCode(String maskCode) {
        boolean res = true;
        String[] nums = maskCode.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            int n = Integer.valueOf(num);
            sb.append(binaryString(n));
        }
        int firstIndexOf0 = sb.indexOf("0");
        int lastIndexOf1 = sb.lastIndexOf("1");
        if (firstIndexOf0 < lastIndexOf1) {
            res = false;
        }
        return res;
    }

    /**
     * 将整数转成对应的八位二进制字符串
     *
     * @param num
     * @return
     */
    private static String binaryString(int num) {
        StringBuilder result = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            result.append(val);
            num <<= 1;
        }
        return result.toString();
    }


    private static void get17TwoAddress() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            int x = 0;
            int y = 0;
            String[] tokens = scan.nextLine().split(";");
            for (int i = 0; i < tokens.length; i++) {
                try {
                    int b = Integer.parseInt(tokens[i].substring(1, tokens[i].length()));
                    if (tokens[i].charAt(0) == 'A') {
                        x -= b;
                    }
                    if (tokens[i].charAt(0) == 'W') {
                        y += b;
                    }
                    if (tokens[i].charAt(0) == 'S') {
                        y -= b;
                    }
                    if (tokens[i].charAt(0) == 'D') {
                        x += b;
                    }


                } catch (Exception e) {
                    continue;
                }
            }
            System.out.println(x + "," + y);

        }

    }

    private static void get16ShopGG() {
        Scanner scanner = new Scanner(System.in);
        // 总钱数
        int N = scanner.nextInt();
        // 购买物品个数
        int m = scanner.nextInt();
        int[] f = new int[N + 1];
        // 分组，goods[i][0]为主件，goods[i][1]为附件1，goods[i][2]为附件2
        Good[][] goods1 = new Good[60][4];

        for (int i = 1; i <= m; i++) {
            int v = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();

            Good t = new Good(v, v * p);
            if (q == 0) {
                goods1[i][0] = t;
            } else {
                if (goods1[q][1] == null) {
                    goods1[q][1] = t;
                } else {
                    goods1[q][2] = t;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = N; j >= 0 && goods1[i][0] != null; j--) {
                //以下代码从分组中选择价值最大的。共五种情况：不选主件，选主件，选附件1和主件，选附件2和主件，选附件1和附件2和主件
                Good master = goods1[i][0];
                int max = f[j];
                if (j >= master.v && max < f[j - master.v] + master.vp) {
                    max = f[j - master.v] + master.vp;
                }
                int vt;
                if (goods1[i][1] != null) {
                    if (j >= (vt = master.v + goods1[i][1].v)
                            && max < f[j - vt] + master.vp + goods1[i][1].vp) {
                        max = f[j - vt] + master.vp + goods1[i][1].vp;
                    }
                }
                if (goods1[i][2] != null) {
                    if (j >= (vt = master.v + goods1[i][1].v + goods1[i][2].v)
                            && max < f[j - vt] + master.vp + goods1[i][1].vp + goods1[i][2].vp) {
                        max = f[j - vt] + master.vp + goods1[i][1].vp + goods1[i][2].vp;
                    }
                }
                f[j] = max;
            }
        }

        System.out.println(f[N]);

    }

    static class Good {
        int v;
        int vp;

        public Good(int v, int vp) {
            this.v = v;
            this.vp = vp;
        }
    }

    private static void get15to2Num() {
        Scanner str = new Scanner(System.in);
        int n = str.nextInt();
        String se = Integer.toBinaryString(n);
        char[] ch = se.toCharArray();
        int count = 0;
        for (int i = 0; i < se.length(); i++) {
            if (ch[i] == '1') {
                count++;
            }
        }
        System.out.println(count);
        //get7Over();
       TestJava.getPasswordOk();
    }

    private static void get14StrSort() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] ss = new String[num];
        for (int i = 0; i < num; i++) {
            ss[i] = sc.next();
        }
        Arrays.sort(ss);
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }

    private static void get13BackSentence() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] s1 = s.split("[\\s]+");
            StringBuffer buffer = new StringBuffer();
            for (int i = s1.length - 1; i >= 0; i--) {
                if (i == 0) buffer.append(s1[i]);
                else buffer.append(s1[i] + " ");
            }
            System.out.println(buffer.toString());
        }
    }

    private static void get11BackInt() {//11
        int n = new Scanner(System.in).nextInt();
        String str = String.valueOf(n);


        StringBuffer sb = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }

    private static void get12BackString() {//12
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder b = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            b.append(str.charAt(i));
        }
        System.out.println(b);
    }

    private static void get10DifferentNum() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String ss = str.charAt(0) + "";
            for (int i = 1; i < str.length(); i++) {
                if (str.substring(0, i).indexOf(str.charAt(i)) < 0) {//
                    ss = ss + str.charAt(i);
                }
            }
            System.out.println(ss.length());
        }
        sc.close();
    }

    private static void get9NewInt() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            char[] chars = scan.nextLine().toCharArray();
            ArrayList<Character> list = new ArrayList<Character>();
            for (int i = chars.length - 1; i >= 0; i--) {
                if (!list.contains(chars[i])) {
                    list.add(chars[i]);
                }
            }
            for (char c : list) {
                System.out.print(c);
            }

        }
    }

    private static void get8merge() {
        Scanner str = new Scanner(System.in);
        SortedMap<Integer, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(str.nextLine());
        for (int i = 0; i < n; i++) {
            String[] mid = str.nextLine().split("\\s+");
            int key = Integer.parseInt(mid[0]);
            int value = Integer.parseInt(mid[1]);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + value);
            } else {
                map.put(key, value);
            }
        }
        for (SortedMap.Entry<Integer, Integer> e : map.entrySet()) {
            StringBuilder builder = new StringBuilder();
            builder.append(e.getKey()).append(" ").append(e.getValue()).append("\r");
            System.out.println(builder.toString());
        }
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
