package menu.student;

import services.StudentServices;

import java.util.Scanner;

public class StudentScholarMenu {
    private static StudentServices studentServices = new StudentServices();

    public static void display(Integer id) {

        Scanner scanner = new Scanner(System.in);
        Boolean running = true;


        while (running) {

            System.out.println("1) My Scholarship Information");
            System.out.println("2) Apply Scholarship");
            System.out.println("3) Create New Application");
            System.out.println("4) Back");

            Integer result = scanner.nextInt();

            switch (result) {
                case 1: {
                    System.out.println(studentServices.getSchoInfo(id));
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.println("Applied successfully");
                    System.out.println();
                    studentServices.applyScholarship(id, true);
                    break;
                }
                case 3: {
                    studentServices.createNewApplication(id,id, true);
                    System.out.println("Your new application is created successfully!!!");
                    break;
                }
                case 4: {
                    running = false;
                    break;
                }
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
