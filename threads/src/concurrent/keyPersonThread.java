package concurrent;

public class keyPersonThread extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName()+" begin to fight");

        for(int i = 0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+" fuck the dogs!");
        }


        System.out.println(Thread.currentThread().getName()+" end the fight");
    }
}
