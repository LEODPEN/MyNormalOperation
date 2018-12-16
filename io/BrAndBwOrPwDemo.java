package io;

import java.io.*;

public class BrAndBwOrPwDemo {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("G:\\Desktop\\连城\\learnmore\\src\\io\\file")));
        /*BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("G:\\Desktop\\连城\\learnmore\\src\\io\\file3")));
        */
        PrintWriter pw = new PrintWriter("G:\\\\Desktop\\\\连城\\\\learnmore\\\\src\\\\io\\\\file4");

        String line;
        while((line = br.readLine())!=null){
            System.out.println(line);//一次读一行，并不能实现换行
            /*bw.write(line);
            //单独写出换行操作
            bw.newLine();
            bw.flush();*/
            pw.println(line);
            pw.flush();
        }
    }
}
