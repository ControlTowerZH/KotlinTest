package com.haohao.javalib.single;

/**
 * Description :静态内部类
 *
 * @author Hao Zhao
 * @date 2020/3/15
 */
public class S {

    private S(){
    }

    public static S getInstance(){
        return S1.instance;
    }

    private static class S1{
        private static final S instance =new S();
    }
}
