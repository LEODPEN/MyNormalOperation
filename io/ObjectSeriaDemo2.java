package io;
import java.io.*;
/*
 *对子类对象进行反序列化操作时，
 *如果其父类没有实现反序列化接口
 *那么其父类的构造函数会被调用
 */

public class ObjectSeriaDemo2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("demo/obj1.dat")
        );
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("demo/obj1.dat")
        );
        Foo2 foo2 = new Foo2();
        oos.writeObject(foo2);
        oos.flush();
        oos.close();
        Foo2 foo2New = (Foo2)ois.readObject();
        System.out.println(foo2New);
        ois.close();
    }
}
/*一个类实现了序列化接口，那么其子类都可以进行序列化*/
class Foo implements Serializable{
    public Foo(){
        System.out.println("foo...");
    }
}
class Foo1 extends Foo{
    public Foo1(){
        System.out.println("foo1...");
    }
}
class Foo2 extends Foo1{
    public Foo2(){
        System.out.println("foo2...");
    }
}

