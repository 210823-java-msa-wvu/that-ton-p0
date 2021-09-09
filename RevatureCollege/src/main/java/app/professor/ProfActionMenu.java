package app.professor;

import java.util.Scanner;

public class ProfActionMenu {
    public static void display() {

        Scanner scanner = new Scanner(System.in);
        Boolean running = true;

        while (running) {

            System.out.println("1) Students List");
            System.out.println("2) Students Schedule");
            System.out.println("3) Scholarship Applications");
            System.out.println("4) Students Tuition");
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
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    running = false;
                    break;
                }
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
