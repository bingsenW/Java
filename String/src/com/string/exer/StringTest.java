package com.string.exer;


/*
* 面试题
* */
public class StringTest {
    String str = new String("good");
    char[] ch = {'t','e','s','t'};
    //此处是值传递，引用类型传的是地址值，但是String是不可变的，所以是两个地址;ch[]是同一个地址
    public void change(String str,char ch[]){
        str = "test ok";
        ch[0]='b';
    }

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.change(stringTest.str,stringTest.ch);
        System.out.println(stringTest.str);//good
        System.out.println(stringTest.ch);//best
    }
}
