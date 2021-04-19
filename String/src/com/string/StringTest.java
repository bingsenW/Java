package com.string;

import org.junit.Test;
/***
 *String的使用
 * 单元测试
 */

public class StringTest {

    /*
    * String:使用一对""表示
    * String声明为final，不可被继承
    * String实现了Serializable接口：表示字符串是支持序列化的
    * String实现了Comparable接口：String可以比较大小
    * String在内部定义了final char[] value用于存储字符串数据
    * String代表不可变的字符序列。简称：不可变性
    *      体现：对字符串重新赋值时，需要重新指定内存区域进行赋值
    * 通过字面量的方式(区别于new)给一个字符串值，此时的字符串声明在字符串常量池中
    * 字符串常量池中是不会存储相同内容的字符
    */

    @Test
    public void test1(){
        String s1 = "abc";
        String s2 = "abc";
        s1 = "hello";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1==s2);

        String s3 = "abc";
        s3 +="def";
        System.out.println(s3);
        String s4 = s2.replace("a","m");
        System.out.println(s4);
    }

    /*
    * String的实例化方式
    * 1.通过字面量定义的方式
    * 2.通过new+构造器的方式
    *面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象？
    *       两个，一个是堆空间中new结构，一个是char[]对应的常量池的数据abc
    * */

    @Test
    public void  test2(){
        String s1 = "javaEE";
        String s2 = "javaEE";
        String s3 = new String("javaEE");
        s3 = s3.replace("j","a");
        String s4 = new String("javaEE");
        System.out.println(System.identityHashCode(s1));

        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));


        Person p1 = new Person("TOM",12);
        Person p2 = new Person("TOM",12);
        System.out.println(System.identityHashCode(p1));
        System.out.println(System.identityHashCode(p2));
        System.out.println(System.identityHashCode(p1.name) ==System.identityHashCode(p2.name));

    }


    /*
    *结论：常量与常量拼接结果在常量池；只要其中有一个是变量，结果就在堆中
    * 如果拼接的结果调用intern()方法，返回值就在常量池
    * */
    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE"+"hadoop";
        String s5 = "javaEE"+s2;
        String s6 = s1+"hadoop";
        String s7 = s1+s2;
        String s8 = s3.intern();//返回值得到的是常量值在常量池中
        System.out.println(s3 ==s4);//True
        System.out.println(s3 ==s5);//false
        System.out.println(s3 ==s6);//false
        System.out.println(s3 ==s7);//false
        System.out.println(s8 == s3);//true

    }
}
