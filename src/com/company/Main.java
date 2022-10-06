package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
       LinkedList<Integer> list= new LinkedList<Integer>();
        list.addFirst(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.removeN_K(0,3);
        for(int i = 0; i<list.getSize(); i++){
            System.out.println(list.get(i));

        }

    }
}
