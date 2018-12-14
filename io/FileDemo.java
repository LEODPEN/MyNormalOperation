package io;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class FileDemo {

    public static void main(String[] args){
        File file = new File("G:\\Desktop\\连城\\learnmore\\src\\io\\file");
        //System.out.println(file.exists());
        if (!file.exists())
            file.mkdir();//如果多级目录则用file.mkdirs();
        else {
            //一些有用的相关api;
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getParent());
            System.out.println((file.getName()));
        }
        //else
            //file.delete();
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        File file2 = new File("G:\\Desktop\\连城\\learnmore\\src\\io\\file2");
        if (!file2.exists()){
            try{
                file2.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else file2.delete();
    }
}
