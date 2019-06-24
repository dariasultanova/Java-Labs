public class Task {
    private int number_;

    public void set(int num, String name) {
        number_ = num;
        System.out.printf("%s set task %d\n", name, number_);
    }

    public void get(String name) {
        System.out.printf("%s get task %d\n", name, number_);
    }
}
