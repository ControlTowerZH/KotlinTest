package com.haohao.javalib.single;

/**
 * Description : 懒汉
 *
 * @author Hao Zhao
 * @date 2020/3/15
 */
public class E {
    private static  E mInstance;

    private E(){};

    public static  E getInstance(){
        if (mInstance==null){
            mInstance=new E();
        }
        return mInstance;
    }

    public static void createSomething(){
        System.out.print(" E.createSomething()");
    }
    public static void main(String[]args){
        E.createSomething();
    }
}
