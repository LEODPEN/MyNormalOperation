package io;

import java.io.File;
import java.io.IOException;

public class IOUtilTest2 {

    public static void main(String[] args){
        try {
            IOUtil.copyFile(new File("G:\\Desktop\\连城\\learnmore\\src\\io\\1.jpg"), new File("G:\\Desktop\\连城\\learnmore\\src\\io\\2.jpg"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
