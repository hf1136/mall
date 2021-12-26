package com.macro.mall;

import io.swagger.models.auth.In;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

class Test2 {

    public static void main(String[] args) throws java.lang.Exception {
        int i = 5;
        int j = 10;
        System.out.println( ~j);

        System.out.println("hi");
        String s1 = "32.3.26.34.1.0.0.0";
        String s2 = "32.3.12.34.1";
        int result = compareVersion3(s1, s2);
        System.out.println(result);
        TreeSet

    }

    private static int compareVersion(String str1, String str2) {
        String[] arr1 = str1.split("\\.");
        String[] arr2 = str2.split("\\.");
        int max = Math.max(arr1.length, arr2.length);
        for (int i = 0; i < max; i++) {
            if (!getNum(arr1, i).equals(getNum(arr2, i))) {
                return Integer.parseInt(getNum(arr1, i)) > Integer.parseInt(getNum(arr2, i)) ? 1 : -1;
            }
        }
        return 0;
    }

    private static String getNum(String[] arr, int index) {
        return index < arr.length ? arr[index] : "0";
    }

    private static int compareVersion2(String str1, String str2) {
        String[] strArr1 = str1.split("\\.");
        String[] strArr2 = str2.split("\\.");
        int length = Math.max(strArr1.length, strArr2.length);
        for (int i = 0; i < length; i++) {
            int arr1 = strArr1.length > i ? Integer.parseInt(strArr1[i]) : 0;
            int arr2 = strArr2.length > i ? Integer.parseInt(strArr2[i]) : 0;
            if (arr1 != arr2) {
                return arr1 > arr2 ? 1 : -1;
            }
        }
        return 0;
    }
    private static int compareVersion3(String s1, String s2){
        String[] strArr1 = s1.split("\\.");
        String[] strArr2 = s2.split("\\.");
        int length = Math.max(strArr1.length, strArr2.length);
        for (int i = 0; i < length; i++) {
            String str1 = getString(strArr1, i);
            String str2 = getString(strArr2, i);
            if(!str1.equals(str2)){
                return (Integer.parseInt(str1) > Integer.parseInt(str2)) ? 1 : -1;
            }
        }
        return 0;
    }

    private static String getString(String[] strArr, int i) {
        List<String> strings = Arrays.asList(strArr);
        return strArr.length > i ? strArr[i] : "0";
    }


}