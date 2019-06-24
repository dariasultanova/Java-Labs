public class Trainer extends Thread {
    private int num_, arg_;
    private Task task_;

    Trainer(Task task, int arg) {
        task_ = task;
        arg_ = arg;
        this.setName("Trainer");
    }

    public void run() {
        synchronized (task_) {
            for (int i = 0; i < arg_; i++) {

                num_ = i + 1;
                task_.set(num_, Thread.currentThread().getName());

                try {
                    task_.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task_.notify();
            }
        }
    }
}