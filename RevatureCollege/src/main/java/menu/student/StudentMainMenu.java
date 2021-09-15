package menu.student;

import services.StudentServices;

import java.util.Scanner;

public class StudentMainMenu {
    private static StudentServices studentServices = new StudentServices();

    public static void display(String email) {

        Scanner scanner = new Scanner(System.in);
        Boolean running = true;


        while (running) {

            System.out.println("Welcome " + email);
            System.out.println();
            System.out.println("1) My Information");
            System.out.println("2) Scholarship");
            System.out.println("3) Logout");

            Integer result = scanner.nextInt();

            switch (result) {
                case 1: {
                    System.out.println(studentServices.getStudent(email));
                    System.out.println();
                    break;
                }
                case 2: {
                    StudentScholarMenu.display(studentServices.getID(email));
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
