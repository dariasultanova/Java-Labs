public class Main {
    static private Task task = new Task();

    public static void main(String[] args) {

        if(args.length != 1) {
            System.err.println("Invalid number of parameters");
            return;
        }

        System.out.printf("Input parameters: %s\n\n", args[0]);

        int num;
        try {
            num = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Invalid argument: " + args[0]);
            return;
        }

        new Trainer(task, num).start();
        new Sportsman(task, num).start();
    }
}