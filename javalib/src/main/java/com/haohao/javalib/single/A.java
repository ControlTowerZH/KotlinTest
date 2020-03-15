package com.haohao.javalib.single;

/**
 * Description : 饿汉
 *
 * @author Hao Zhao
 * @date 2020/3/15
 */
public class A {
    private static final A mInstance =new A();
    private A(){
    }
    public static A getInstance(){
        return mInstance;
    }

    public static void createSomething(){

    }
    public static void main(String[]args){
        A.createSomething();
    }
}
