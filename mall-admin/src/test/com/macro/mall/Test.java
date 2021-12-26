package com.macro.mall;

import java.util.Arrays;

/**
 * @Auther: hf
 * @Date: 2021/7/26
 * @Desc:
 */
public class Test {

    public static void main(String[] args) {
        String s1 = "1.21";
        String s2 = "1.21.3.3.10";
        int result = compareVersion(s1, s2);
        System.out.println(result);
    }

    private static int compareVersion(String s1, String s2) {
        System.out.println(s1.equals(s2));
        if (s1 != null && s2 != null && s1.length() != 0 && s2.length() != 0 && s1.equals(s2)) {
            return 0;
        }
        String[] strArr1 = s1.split("\\.");
        String[] strArr2 = s2.split("\\.");
//若两个字符串数组位数相同，依次遍历比较即可
        if (strArr1.length == strArr2.length) {
            return compareNum(strArr1, strArr2);
        } else {
            int longStr = strArr1.length > strArr2.length ? strArr1.length : strArr2.length;
            int shortStr = strArr1.length < strArr2.length ? strArr1.length : strArr2.length;
            //若str1位数多于str2的位数，先判断前N位大小关系

            if (strArr1.length > strArr2.length) {
                //取出str1的前n位长度和str进行比较
                String[] newStrArr1 = Arrays.copyOf(strArr1, strArr2.length);
                //前n位的比较结果
                int compareResult = compareNum(newStrArr1, strArr2);
                //前n位相等，接着比较str1的大小
                if (compareResult == 0) {
                    return compareNumStr1(strArr1, longStr, shortStr);

                } else {
                    return compareResult;
                }
            } else {
                String[] newStrArr2 = Arrays.copyOf(strArr2, strArr1.length);
                //前n位的比较结果
                int compareResult = compareNum(strArr1, newStrArr2);
                if (compareResult == 0) {
                    //若前n位相同，接着比较后面
                    return compareNumStr2(strArr2, longStr, shortStr);

                } else {
                    return compareResult;
                }
            }

        }


    }

    /**
     * 前n位之后的数字比较，str2位数多于str1
     *
     * @param strArr2
     * @param longStr
     * @param shortStr
     * @return
     */
    private static int compareNumStr2(String[] strArr2, int longStr, int shortStr) {
        for (int i = shortStr; i < longStr; i++) {
            if (Integer.parseInt(strArr2[i]) > 0) {
                return -1;
            }
            if (Integer.parseInt(strArr2[i]) < 0) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * N位之后数字的比较,str1的位数多于str2
     *
     * @param strArr1
     * @param longStr
     * @param shortStr
     * @return
     */
    private static int compareNumStr1(String[] strArr1, int longStr, int shortStr) {


        for (int i = shortStr; i < longStr; i++) {
            if (Integer.parseInt(strArr1[i]) > 0) {
                return 1;
            }
            if (Integer.parseInt(strArr1[i]) < 0) {
                return -1;
            }
        }
        return 0;


    }

    /**
     * 前N位数字相同的比较
     *
     * @param strArr1
     * @param strArr2
     * @return
     */
    private static int compareNum(String[] strArr1, String[] strArr2) {
        for (int i = 0; i < strArr1.length; i++) {
            if (Integer.parseInt(strArr1[i]) > Integer.parseInt(strArr2[i])) {
                return 1;
            }
            if (Integer.parseInt(strArr1[i]) < Integer.parseInt(strArr2[i])) {
                return -1;
            }
        }
        return 0;
    }

}
