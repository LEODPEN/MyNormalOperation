package io;

import java.io.File;
import java.io.IOException;

public class IOUtilTest3 {

    public static void main(String[] args){
        try {
            IOUtil.copyFileByBuffer(new File("G:\\Desktop\\连城\\learnmore\\src\\io\\1.jpg"),new File("G:\\Desktop\\连城\\learnmore\\src\\io\\3.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.print("完成操作？");
        }
    }
}
