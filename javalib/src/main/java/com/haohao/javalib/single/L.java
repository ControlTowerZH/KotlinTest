package com.haohao.javalib.single;

/**
 * Description : 懒汉 线程安全
 *
 * @author Hao Zhao
 * @date 2020/3/15
 */
public class L {
    private static volatile L mInstance;

    private L(){};

    public static synchronized L getInstance(){
        if (mInstance==null){
            mInstance=new L();
        }
        return mInstance;
    }

    public static  L getInstance1(){
        if (mInstance==null) {
            synchronized (L.class) {
                if (mInstance == null) {
                    mInstance = new L();//不是原子操作，JVN指令重排序
                }
            }
        }
        return mInstance;
    }

    public static void createSomething(){
        System.out.print(" E.createSomething()");
    }
    public static void main(String[]args){
        L.createSomething();
    }
}
