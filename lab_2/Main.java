import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.printf("Input parameters: %s %s %s%n", args[0], args[1], args[2]);

        try {
            if ((args.length != 3)
                    || (!(args[0].equals("EUR")) && !(args[0].equals("USD")))
                    || (!(args[1].equals("BUY")) && !(args[1].equals("SELL")))) {
                System.err.println("1 arg: [EUR|USD] 2 arg: [BUY|SELL] 3 arg: number");
                return;
            }

            int count;
            try {
                count = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid argument: " + args[2]);
                return;
            }

            String field_name = args[0] + "_" + args[1];

            ArrayList<Field> arrayField = new ArrayList<>();

            arrayField.add(Bank1.class.getField(field_name));
            arrayField.add(Bank2.class.getField(field_name));
            arrayField.add(Bank3.class.getField(field_name));
            arrayField.add(Bank4.class.getField(field_name));

            Field best_field = arrayField.get(0);

            Method comp = (args[1].equals("SELL")
                    ? Main.class.getMethod("great", Comparable.class, Comparable.class)
                    : Main.class.getMethod("less", Comparable.class, Comparable.class));

            for (Field current: arrayField) {
                if((boolean) comp.invoke(Main.class, best_field.get(null), current.get(null))) {
                    best_field = current;
                }
            }

            System.out.println("Best Bank: "
                    + best_field.getDeclaringClass().getSimpleName()
                    + "\nPrice: " + best_field.get(null));

            ExRates ratesOfBanks = new ExRates();

            System.out.println(ExRates.class.getMethod(args[1].toLowerCase(), int.class, double.class)
                    .invoke(ratesOfBanks, count, best_field.get(null)));

        } catch (Exception err) {
            err.printStackTrace();
            return;
        }
    }

    public static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) > 0;
    }

    public static <T extends Comparable<T>> boolean great(T a, T b) {
        return a.compareTo(b) < 0;
    }
}
