package com.haohao.javalib.list;

/**
 * Description :节点
 *
 * @author Hao Zhao
 * @date 2020/3/15
 */
public class Node {

     Object data;
     Node next;

    public Node(){
        super();
    }
    public Node(Object object){
        super();
        data =object;
    }

    public Node(Object object,Node node){
        super();
        data =object;
        next= node;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
