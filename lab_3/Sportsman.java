public class Sportsman extends Thread {
    private int arg_;
    private Task task_;

    Sportsman(Task task, int arg) {
        task_ = task;
        arg_ = arg;
        this.setName("Sportsman");
    }

    public void run() {
        synchronized (task_) {
            for (int i = 0; i < arg_; i++) {

                task_.get(Thread.currentThread().getName());
                task_.notify();

                try {
                    task_.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
