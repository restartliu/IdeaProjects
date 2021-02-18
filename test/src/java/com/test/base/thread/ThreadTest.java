package com.test.base.thread;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
/*
        RunnerTest runnerTest = new RunnerTest();
        Thread thread = new Thread(runnerTest);
        thread.start();
*/
        RunThread runThread1 = new RunThread("test1");
        RunThread runThread2 = new RunThread("test2");
        runThread1.start();
        runThread2.start();
//        for (int i = 0; i < 10; i++) {
//            System.out.println("main thread:"+i);
//            Thread.sleep(500);
//        }
//        runThread.join();
//        System.out.println("test");
    }
}

class RunThread extends Thread{

    public RunThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(this.getName() + ":" + i);
//            if (i%10==0&&this.getName().equals("test1")) {
//                Thread.yield();
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}

class RunnerTest implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep((long)1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}