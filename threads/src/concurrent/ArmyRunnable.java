package concurrent;

//army threads
//to fight

public class ArmyRunnable implements Runnable {
    //volatile 保证线程可以正确读取其他线程的写入的值&&可见性
    volatile boolean keepRunning = true;
    public void run(){

        while (keepRunning){
            for (int i = 0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+" fight[" + i + "]");
                //make multiple fight
                Thread.yield();
            }
        }
        System.out.println("little "+Thread.currentThread().getName()+" end the fight");

        //下面两种方法一样的
        /*long time = System.currentTimeMillis();
        while(System.currentTimeMillis()-time<1000){} = Thread.sleep(1000);*/

        //另有，interrupt 负负得正，最好通过旗标方法来设置线程结束或开始 eg: keepRunning

    }

}
