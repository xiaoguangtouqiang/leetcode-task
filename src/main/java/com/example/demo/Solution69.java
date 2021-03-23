package com.example.demo;

public class Solution69 {
    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ins = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid <= x) {
                ins = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ins;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(16));
    }
}
