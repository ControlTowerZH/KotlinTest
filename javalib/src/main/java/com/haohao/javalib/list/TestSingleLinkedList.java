package com.haohao.javalib.list;

/**
 * Description :
 *
 * @author Hao Zhao
 * @date 2020/3/15
 */
public class TestSingleLinkedList {

    public static void main(String[] args){
        List list =new SingleLinkedList();

        list.add(123);
        list.add(321);
        list.add(456);
        list.add(678);
        list.add(789);

        list.add(0,666);

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(3));
        System.out.println(list.toString());
    }
}
