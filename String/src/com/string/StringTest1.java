package com.string;


import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类和其他结构之间的转换
 *
 * */
public class StringTest1 {
     @Test
    public void test1(){
         String s1 = "123";
      //   int num = (int)s1;//错误
        int num = Integer.parseInt(s1);
        String s2 = String.valueOf(num);
        String s3 = num +"";
         System.out.println(s1 == s3);
         System.out.println(s1 ==s2);
     }

     //String与char[]之间的转化
    //String -->char[] str.toCharArray()
    //char[] -->string 调用String的构造器
    //String 与 byte[]之间的转换
    //String -->byte[] str.getbytes()
    //byte[] -->string 调用String的构造器
    @Test
    public void test2() throws UnsupportedEncodingException {
         String str = "abc123中国";
         char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println(new String(a));
        byte[] bytes = str.getBytes();//进行编码
        byte[] bytes1 = str.getBytes("gbk");
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));
        System.out.println(new String(bytes1));//出现乱码，编码与解码格式不一致，utf-8 gbk
        System.out.println(new String(bytes1,"gbk"));//没有出现乱码，编码与解码格式一致，gbk gbk
     }
}
