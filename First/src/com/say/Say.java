package com.say;


import java.util.ArrayList;

public class Say {


    public static final int NUM = 1;


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);
        for (Object o : list) {
            
        }
        for (int i = 0; i < list.size(); i++) {
            
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            
        }
        if(list==null){
            System.out.println("null");
        }
        System.out.println("zxc");

    }



}
