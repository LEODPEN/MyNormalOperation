package io;

import java.io.IOException;
public class IOUtilTest1 {
    public static void main(String[] args){
        try {
            IOUtil.printHex("G:\\Desktop\\连城\\learnmore\\src\\io\\1.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
