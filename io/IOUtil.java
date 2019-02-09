package io;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.*;

public class IOUtil {
    public static void  copyFile(File srcFile,File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new  IllegalArgumentException("文件"+srcFile+"不存在");//参数有问题就抛出这个异常就好了
        }
        if (!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile+"不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);//进行读操作
        FileOutputStream out = new FileOutputStream(destFile);//进行写操作
        //批量读写
        byte[] buf = new byte[8*1024];
        int b;
        while((b=in.read(buf,0,buf.length))!=-1){
            out.write(buf,0,b);
            out.flush();//最好有此句,对字节流不加也没关系
        }
        in.close();
        out.close();
    }

}
