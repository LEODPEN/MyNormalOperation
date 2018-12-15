package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//需要注意的是编码问题！！！！
public class IsrAndOswDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("G:\\Desktop\\连城\\learnmore\\src\\io\\file");
        InputStreamReader isr = new InputStreamReader(in);//默认项目的编码
        /*int c;
        while((c = isr.read())!=-1){
            System.out.print((char)c);
        }*/
        char[] buffer = new char[8*1024];//更快
        int c;
        /*批量读取，放入buffer这个字符数组，从第0个位置开始放置，最多放buffer.length个
        返回的是读到的字符的个数
         */
        while((c=isr.read(buffer,0,buffer.length))!=-1){
            String s =new String(buffer,0,c);
            System.out.print(s);
        }
        isr.close();
    }
}
