package com.wf.sort;

import java.util.Arrays;

public class SelectSort {

    public static void sort(int a []){
        int length = a.length;
        for (int i = 0; i < length; i++){
            int select = a [i];
            for (int j = i+1; j < length;j++){
                if (select > a[j]){
                    int tmp = select;
                    select = a [j];
                    a [j] = tmp;
                }
            }
            a [i] = select;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void sort1(int a []){
        int length = a.length;
        for (int i = 0; i < length; i++){
            int k = i;
            for (int j = i+1; j < length && a [k] > a [j]; j++){
                k = j;
            }
            if (k != i){
                int tmp = a [i];
                a [i] = a [k];
                a [k] = tmp;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int [] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        sort(arr);
        sort1(arr);
    }
}
