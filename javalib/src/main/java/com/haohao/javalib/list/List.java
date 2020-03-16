package com.haohao.javalib.list;

/**
 * Description :
 *
 * @author Hao Zhao
 * @date 2020/3/15
 */
public interface List {

    int size();

    Object get(int i);

    boolean isEmpty();

    boolean contains(Object e);

    int indexOf(Object e);

    void add(int i,Object e);

    void add(Object e);
}
