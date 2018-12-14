package io;
import java.util.*;
public class EncodeDemo {
    public static void main(String[] args){
        String s = "德玛西亚ABC";
        byte[] bytes1 = s.getBytes();//转换成字节序列用的是项目默认的编码（此处是utf-8）
        //可以转换：eg: byte[] bytes = s.getBytes("utf-16be");
        for (byte b : bytes1){
            //把字节（转换成了int）以16进制的方式显示.
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }
        String str = new String(bytes1);
        System.out.println(str);
    }
}
