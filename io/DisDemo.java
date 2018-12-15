package io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DisDemo {

    public static void main(String[] args)throws IOException{

        String file = "demo/dos.dat";
        IOUtil.printHex(file);
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        int i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();//其实就是in.read()四次然后拼接
        System.out.println(i);
        long I = dis.readLong();
        System.out.println(I);
        double d = dis.readDouble();
        System.out.println(d);
        String s = dis.readUTF();
        System.out.println(s);

        dis.hashCode();
    }
}
