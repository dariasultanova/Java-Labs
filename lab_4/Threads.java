public class Threads implements Runnable {
    private static int threads_number;
    private static int max;
    private int current;
    private Number num;

    Threads(int current, Number num) {
        this.current = current;
        this.num = num;
    }

    public static void setThreadsNumber(int threads_number_) {
        threads_number = threads_number_;
    }

    @Override
    public void run() {
        while (Number.decrement_number > (threads_number - 1)) {
            synchronized (num) {
                while (current != max) {
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if ((max + 1) >= threads_number) {
                    max = 0;
                } else {
                    max++;
                }
                Number.decrement_number--;
                System.out.println(Thread.currentThread().getName() + "  " + Number.decrement_number);
                num.notifyAll();
            }
        }
    }
}
