public class Main {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Invalid number of arguments");
            return;
        }

        int threads_number;
        try {
            threads_number = Integer.parseInt(args[0]);
            if (threads_number < 1) {
                System.err.println("The number of threads must be greater than zero");
                return;
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid argument (not a number): " + args[0]);
            return;
        }

        Number num = new Number();
        try {
            Number.decrement_number = Integer.parseInt(args[1]);
            if (Number.decrement_number < 1) {
                System.err.println("The number for decrement must be greater than zero");
                return;
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid argument (not a number): " + args[1]);
            return;
        }

        System.out.printf("Input parameters: %s  %s%n", args[0], args[1]);

        Threads.setThreadsNumber(threads_number);

        for (int i = 0; i < threads_number; i++) {
            new Thread(new Threads(i, num)).start();
        }
    }
}
