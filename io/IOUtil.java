package io;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.*;

public class IOUtil {
    /**读取指定文件内容，按照16进制输出到控制台
     * 并且每输出10个byte换行
     * 单个处理
     * 单字节读取不适合大文件，大文件效率很低
     */
    public static void printHex(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;
        while((b = in.read())!=-1) {
            if (b <= 0xf) {
                //单位数前面补0操作
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + " ");
            if (i++ % 10 == 9) {
                System.out.println();
            }
        }
        in.close();
    }
//批量读取，对大文件而言效率高，也是我们最常用的读文件的方式
    public static void  printHexByByteArray(String fileName)throws IOException{
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[20*1024];
        /**从in批量读取字节，放入到buf这个字节数组中
         * 从第0个位置开始放，最多放buf.length个
         * 返回的是读到的字节的个数
         */
        int bytes = in.read(buf,0,buf.length);//一次性读完，说明字节数组足够大
        for (int i = 0; i < bytes; i++) {
            if (buf[i]<=0xf){
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(buf[i]&0xff)+" ");
            //bytes8字节，int32字节，避免数据转换错误，将高24位清零
        }
        in.close();
    }

    public static void  copyFile(File srcFile,File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new  IllegalArgumentException("文件"+srcFile+"不存在");
        }
        if (!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile+"不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
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
