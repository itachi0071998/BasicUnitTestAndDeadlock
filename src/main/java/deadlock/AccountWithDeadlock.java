package deadlock;

import java.sql.Time;

public class AccountWithDeadlock {
    private static  Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static class Task implements Runnable{

        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("thread-1 took lock1");
                depositAmount();
                System.out.println("thread-1 waiting for lock2");

                synchronized (lock2) {
                    System.out.println("thread-1 took both lock1 and lock2");
                }
            }
        }
    }
    public static class Task2 implements Runnable{

        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("thread-2 took lock2");
                printReport();
                System.out.println("thread-2waiting for lock1");

                synchronized (lock1) {
                    System.out.println("thread-2 took both lock1 and lock2");
                }
            }
        }
    }
    public static void depositAmount() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("depositing");
    }
    public static void printReport(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("printing");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task2());
        t1.start();
        t2.start();
    }
}
