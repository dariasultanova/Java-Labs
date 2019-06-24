package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class Student {
    String name;
    int day, month, year;
    Student(String n, int d, int m, int y)
    {
        name = n;
        day = d;
        month = m;
        year = y;
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.printf("Input parameters: %s %s%n", args[0], args[1]);

        if (args.length != 2) {
            System.err.println("The number of parameters must be 2");
            return;
        }

        int count, month;
        try {
            count = Integer.parseInt(args[0]);
            month = Integer.parseInt(args[1]);
            if (count <= 0)
                throw new IllegalArgumentException();
            if (month < 1 || month > 12)
                throw new IllegalArgumentException();
        }
        catch (Exception e) {
            System.err.println("Incorrect input parameters");
            return;
        }

        ArrayList<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Дарья/Desktop/Java/javalabs/5var/lab_1/students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e){
            System.err.println("File not found");
            return;
        }

        ArrayList<Student> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            list.add(new Student(names.get(random.nextInt(names.size())),
                    random.nextInt(30) + 1,
                    random.nextInt(12) + 1,
                    random.nextInt(6) + 1995)
            );
        }

        System.out.println("Students list: ");
        for (Student s : list)
            System.out.printf("%-12s \t%d.%d.%d\n", s.name, s.day, s.month, s.year);

        boolean flag = false;
        System.out.println("Students list by the month number: ");
        for (Student s : list) {
            if(s.month == month) {
                flag = true;
                System.out.printf("%-12s \t%d.%d.%d\n", s.name, s.day, s.month, s.year);
            }
        }
        if (!flag) {
            System.out.println("No students with this month");
        }
    }
}
