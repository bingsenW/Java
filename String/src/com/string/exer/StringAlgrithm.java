package com.string.exer;

import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 1.模拟一个trim方法，去除字符串两端的空格。
 *
 * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
 *
 * 3.获取一个字符串在另一个字符串中出现的次数。
      比如：获取“ab”在 “cdabkkcadkabkebfkabkskab”
      中出现的次数

4.获取两个字符串中最大相同子串。比如：
   str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
   提示：将短的那个串进行长度依次递减的子串与较长
   的串比较。

5.对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
提示：
1）字符串变成字符数组。
2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
3）将排序后的数组变成字符串。

/**
 * @program: String
 * @Date: 2021/4/19 10:20
 * @Author: Mr.Deng
 * @Description:
 */
public class StringAlgrithm {


    public void mTrim(String input) {

        int start = 0;
        int end = input.length() - 1;
        while (start < end && input.charAt(start) == ' ') {
            start++;
        }
        while (start < end && input.charAt(end) == ' ') {
            end--;
        }
        System.out.println(input.substring(start, end + 1));
    }



    public void reverse(String input, int start, int end) {

        char temp;
        char[] reverse = input.toCharArray();
        for (int i = start, j = end; i < j; i++, j--) {
            temp = reverse[i];
            reverse[i] = reverse[j];
            reverse[j] = temp;
        }
        System.out.println(new String(reverse));
    }

    public void revese1(String input, int start, int end) {
        String sub = input.substring(0, start);
        for (int i = end; i >= start; i--) {
            sub += input.charAt(end);
        }
        sub += input.substring(end + 1);
        System.out.println(sub);
    }
    public void revese2(String input,int start,int end){

            StringBuilder sub = new StringBuilder(input.length());
            sub.append(input.substring(0,start));
            for (int i = end; i >=start ; i--) {
                sub.append(input.charAt(i));
            }

            sub.append(input.substring(end+1));
            System.out.println(sub.toString());


    }
    public int getCount(String str1,String str2){
        if(str1.length()>=str2.length()){
            int count =0;
            int index=0;
            while((index = str1.indexOf(str2,index))!=-1){

                index += str2.length();
                count++;
            }
            return count;
        }else {
            return 0;
        }
    }
    public void Strsort(String input){
        char[] a = input.toCharArray();
        Arrays.sort(a);
        System.out.println(new String(a));
    }

    public String KMP_one(String str1,String str2){
       if(str1 !=null &&str2!=null){
           String maxstr = str1.length()>str2.length() ? str1:str2;
           String minstr = str1.length()>str2.length() ? str2:str1;
           int length = minstr.length();
           for (int i = 0; i <length ; i++) {
               for (int x = 0,y=length-i; y <=length ; x++,y++) {
                   if(maxstr.contains(minstr.substring(x,y))) {
                       return minstr.substring(x, y);
                   }
               }
           }
       }
       return null;
    }
    public ArrayList KMP_mul(String str1, String str2){
        if(str1 !=null &&str2!=null){
            ArrayList arrayList = new ArrayList();
            String maxstr = str1.length()>str2.length() ? str1:str2;
            String minstr = str1.length()>str2.length() ? str2:str1;
            int length = minstr.length();
            for (int i = 0; i <length ; i++) {
                for (int x = 0,y=length-i; y <=length ; x++,y++) {
                    if(maxstr.contains(minstr.substring(x,y))) {
                        arrayList.add(minstr.substring(x, y));
                    }
                }
                if (arrayList.isEmpty()==false){
                    break;
                }
            }
            return arrayList;
        }
        return null;
    }
    @Test
    public void testTrim() {
        String str1 = "abcwerthelloyuiodef";
        String str2 ="cvhellobnmiodef";
        System.out.println(KMP_mul(str1,str2).toString());
        //mTrim(" ao d dw  ");
        // reverse("abcdefg", 1, 5);
        //revese2("adadvcfdbfb",0,3);
    }
}