package com.haohao.kotlintest.java;

import java.util.Random;

public class TestJava {




    public static void main(String[] args) {

        for (int i =0;i<10;i++){
            //10为边界最大为10
            int random = new Random().nextInt(10);
            System.out.println("random"+random);
        }
    }
}
