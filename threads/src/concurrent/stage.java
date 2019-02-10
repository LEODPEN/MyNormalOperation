package concurrent;



//the stage of the fight between pig and dog
public class stage extends Thread{

    public void run(){

        System.out.println("begin the fight between pigs and dogs.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArmyRunnable armyTaskOfPig = new ArmyRunnable();
        ArmyRunnable armyTaskOfDog = new ArmyRunnable();

        //使用runnable接口创建线程
        Thread armyOfPig = new Thread(armyTaskOfPig,"pigs");
        Thread armyOfDog = new Thread(armyTaskOfDog,"dogs");

        //fight begin
        armyOfPig.start();
        armyOfDog.start();

        //the thread of stage sleep so that we can lay emphasis on the fight.
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("the big dog and pig are joining the stage.");

        Thread mrPeiqi = new keyPersonThread();
        mrPeiqi.setName("PeiQi");

        armyTaskOfPig.keepRunning = false;
        armyTaskOfDog.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mrPeiqi.start();

        try {
            mrPeiqi.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end the whole fight!");
    }

    public static void main(String[] args){

        new stage().start();

    }
}
