package com.string;

import org.junit.Test;

public class StringBufferBuilderTest {
    /*
    * String StringBuffer StringBuilder异同
    * String:不可变的字符序列,底层都是char[]存储
    * StringBuffer:可变的字符序列；线程安全的，效率低，底层都是char[]存储
    * StringBuilder:可变的字符序列，线程不安全，效率高，底层都是char[]存储
    *
    //问题1. System.out.println(sb2.length());//3
    //问题2. 扩容问题:如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组。
             默认情况下，扩容为原来容量的2倍 + 2，同时将原有数组中的元素复制到新的数组中。

            指导意义：开发中建议大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)
    * */
    @Test
    public void test1(){
        String str =new String(); //new char[0];
        String str1 = new String("ABC");//new char[]{'A','B','C'};
        StringBuffer sb = new StringBuffer();//new char[16];底层创建了长度为16的char数组
        sb.append('a');//char[0]='a'
        sb.append('b');//char[1]='b'
        StringBuffer sb1=  new StringBuffer("abc");//new char[19]  "abc".length+16
    }
        /*
    StringBuffer的常用方法：
StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
StringBuffer delete(int start,int end)：删除指定位置的内容
StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
StringBuffer insert(int offset, xxx)：在指定位置插入xxx
StringBuffer reverse() ：把当前字符序列逆转
public int indexOf(String str)
public String substring(int start,int end):返回一个从start开始到end索引结束的左闭右开区间的子字符串
public int length()
public char charAt(int n )
public void setCharAt(int n ,char ch)

        总结：
        增：append(xxx)
        删：delete(int start,int end)
        改：setCharAt(int n ,char ch) / replace(int start, int end, String str)
        查：charAt(int n )
        插：insert(int offset, xxx)
        长度：length();
        *遍历：for() + charAt() / toString()
     */
    @Test
    public void test2(){
        StringBuffer s = new StringBuffer("abc");
        s.append(1);
        s.append("1");
        System.out.println(s);
        s.delete(0,2);
        System.out.println(s);
        s.setCharAt(0,'o');
        System.out.println(s);
        s.insert(0,"hello");
        System.out.println(s);
        s.replace(0,3,"pp");
        System.out.println(s);
        System.out.println(s.reverse());
        System.out.println(s.length());
    }
    /*
对比String、StringBuffer、StringBuilder三者的效率：
从高到低排列：StringBuilder > StringBuffer > String
 */
    @Test
    public void test3(){
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer Buffer = new StringBuffer("");
        StringBuilder Builder = new StringBuilder("");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text+=i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String执行时间:"+(endTime-startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            Buffer.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Buffer执行时间:"+(endTime-startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            Builder.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Builder执行时间:"+(endTime-startTime));
    }
}
