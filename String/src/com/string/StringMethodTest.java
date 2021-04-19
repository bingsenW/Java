package com.string;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Locale;

public class StringMethodTest {

        /*
int length()：返回字符串的长度： return value.length
char charAt(int index)： 返回某索引处的字符return value[index]
boolean isEmpty()：判断是否是空字符串：return value.length == 0
String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
String trim()：返回字符串的副本，忽略前导空白和尾部空白
boolean equals(Object obj)：比较字符串的内容是否相同
boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
int compareTo(String anotherString)：比较两个字符串的大小
String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。

     */
    @Test
    public void test1(){
        String s1 = "helloworld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.isEmpty());
        System.out.println(s1.toUpperCase());
        String s2 = "  he llow orl   ";
        System.out.println(s2.trim());
        System.out.println(s2);
        System.out.println(s2.concat("111"));
        System.out.println(s1.equals(s1.toUpperCase()));
        System.out.println(s1.equalsIgnoreCase(s1.toUpperCase()));

        String s3 = "bbc";
        String s4 = new String("abh");
        System.out.println(s3.compareTo(s4));
        String s5 ="你好，李焕英";
        System.out.println(s5.substring(2));
        System.out.println(s5.substring(3,5));
    }
    /*
boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始

boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索

注：indexOf和lastIndexOf方法如果未找到都是返回-1

 */
    @Test
    public void test2(){
        String s1 = "helloworld";
        boolean b1 = s1.endsWith("l");//false
        System.out.println(b1);
        System.out.println(s1.startsWith("He"));
        System.out.println(s1.startsWith("ll",2));
        System.out.println(s1.contains("woa"));
        System.out.println(s1.indexOf("lo"));
        System.out.println(s1.lastIndexOf("l"));

        System.out.println(s1.indexOf("lo",4));
        System.out.println(s1.lastIndexOf("ll",0));
    }
    /*
替换：
String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
匹配:
boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
切片：
String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。

     */
    @Test
    public void test3(){
        String s1 = "你好，李焕英";
        System.out.println(s1.replace("李","王"));
        System.out.println(s1.replace("李焕","王"));

        String s2 = "12hello32world3java3212mysql233";
        System.out.println(s2.replaceAll("\\d+",","));
        System.out.println(s2.replaceAll("\\d+",",").replaceAll("^,|,$",""));

        s2 = "12345";
        System.out.println(s2.matches("\\d+"));
        String tel = "0571-1233457";
        System.out.println(tel.matches("0571-\\d{6,7}"));

        String s3 = "12|334|332";
        String[] s3s = s3.split("\\|");
        for (int i = 0; i < s3s.length; i++) {
            System.out.println(s3s[i]);
        }



    }

}
