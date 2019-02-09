package concurrent;


//the stage of the fight between pig and dog
public class stage extends Thread{

    public void run(){
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

        armyTaskOfPig.keepRunning = false;
        armyTaskOfDog.keepRunning = false;

        try {
            armyOfDog.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        new stage().start();

    }
}
