package com.haohao.javalib.list;

/**
 * Description :
 *
 * @author Hao Zhao
 * @date 2020/3/15
 */
public class SingleLinkedList implements List{

    private Node head =new Node();//头结点，不存储数据
    private  int size;//节点元素个数

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        Node p= head;
        for (int j =0;j<=i;j++){
            p=p.next;
        }
        return p.data;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public void add(int i, Object e) {
        if (i<0||i>size){
            System.out.print("数组越界异常");
            return;
        }
        //找前一个节点，
        Node p= head;
        for (int j =0;j<i;j++){
            p=p.next;
        }
        //创建一个新节点
        Node newNode = new Node();
        newNode.data=e;
        newNode.next=p.next;
        p.next=newNode;

        size++;
    }

    @Override
    public void add(Object e) {
        this.add(size,e);
    }

    @Override
    public String toString() {
        if (size==0){
            return "[]";
        }
        StringBuilder builder =new StringBuilder("[");
        Node p =head.next;
        for (int i=0;i<size;i++){
            if (i!=size-1){
                builder.append(p.data).append(",");
            }else {
                builder.append(p.data);
            }
            p=p.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
