package com.cute.leetcode.editor.cn;


public class Test {

    public static void main(String[] args) {
        String[] strs ={"dogw","racecar","car"};
        int minLenght = strs[1].length();
        for (int i = 1; i < strs.length; i++) {
            int length = strs[i].length();
            if (minLenght > length) {
                minLenght = length;
            }
        }
        System.out.println(strs[0].charAt(2));

    }


}
