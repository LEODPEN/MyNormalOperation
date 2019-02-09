package io;

import java.io.File;
import java.io.IOException;

public class IOUtilTest2 {

    public static void main(String[] args){
        try {
            IOUtil.copyFile(new File("/Users/pengfeng/Desktop/1917987.pdf"), new File("/Users/pengfeng/Desktop/1917987(1).pdf"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
