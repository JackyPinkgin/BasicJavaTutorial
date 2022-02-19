package personaltrain;

/**
 * 2022/2/17
 */
public class Test0217 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        Thread thread3 = new Thread(myThread);

        thread1.setName("线程1");
        thread2.setName("线程2");
        thread3.setName("线程3");

        thread1.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class MyThread implements Runnable {
    private int ticket = 1000;
//    final Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notifyAll();

                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}
