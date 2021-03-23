package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static class Test {
        private List<Integer> list = new ArrayList<>();
    }

    public static void main(String[] args) {
        Test t = new Test();
        Object obj = new Object();
        new Thread(() -> {
            while (true) {
                synchronized (obj){
                    try {
                        obj.wait();
                        System.out.println("线程2:" + t.list.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                synchronized (obj){
                    t.list.add(12);
                    obj.notify();
                }
                System.out.println("线程1:" + t.list.size());
            }
        }).start();
    }
}


