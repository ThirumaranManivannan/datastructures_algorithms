package ds.datastructures.thread;

public class ThreadTest implements Runnable{
    public int count = 0;
    @Override
    public void run() {
        System.out.println("thread started........");
        try{
            while(count < 5){
                System.out.println("count = "+ count);
                Thread.sleep(5000);
                count++;
            }
        }catch(InterruptedException e){
            System.out.println("thread interrupted");
        }
        System.out.println("thread finished......");
    }

    public static void main(String[] args){
        ThreadTest t = new ThreadTest();
        Thread thr = new Thread(t);
        thr.start();
    }
}
