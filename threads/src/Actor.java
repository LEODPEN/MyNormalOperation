public class Actor extends Thread {
    public static void main(String[] args) {
        Thread actor = new Actor();
        actor.setName("Mr.thread");
        actor.start();
        Thread actressThread = new Thread(new Actress(),"Ms.Runnable");
        actressThread.start();
    }

    public void run() {
        System.out.println(getName() + "是一个演员");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(getName() + "登台演出:" + (++count));

            if (count == 100) {
                keepRunning = false;
            }

            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(getName() + "演出结束!");
    }

}

class Actress implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName()+"是一个演员");
        int count=0;
        boolean keepRunning=true;
        while(keepRunning){
        System.out.println(Thread.currentThread().getName()+"登台演出:"+(++count));

        if(count==100){
        keepRunning=false;
        }

        if(count%10==0){
        try{
        Thread.sleep(1000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
        }
        }

        System.out.println(Thread.currentThread().getName()+"演出结束!");
        }
        }
