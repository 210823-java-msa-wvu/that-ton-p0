package app.student;

import java.util.Scanner;

public class StudentActionMenu {
    public static void display() {

        Scanner scanner = new Scanner(System.in);
        Boolean running = true;

        while (running) {

            System.out.println("1) My Information");
            System.out.println("4) Scholarship");
            System.out.println("5) Logout");

            Integer result = scanner.nextInt();

            switch (result) {
                case 1: {
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    running = false;
                    break;
                }
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
