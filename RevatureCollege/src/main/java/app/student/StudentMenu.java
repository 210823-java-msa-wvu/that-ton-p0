package app.student;

import services.StudentServices;

import java.util.Scanner;

public class StudentMenu {
    public static void display() {

        Scanner scanner = new Scanner(System.in);
        StudentServices studentServices = new StudentServices();
        Boolean running = true;

        while(running) {

            System.out.println("1) Student login");
            System.out.println("2) Signup new account");
            System.out.println("3) Back");

            Integer result = scanner.nextInt();

            switch (result) {
                case 1: {
                    scanner.nextLine();

                    System.out.println("Email: ");
                    String stuEmail = scanner.nextLine();

                    System.out.println("Password: ");
                    String stuPassword = scanner.nextLine();

                    boolean signInResponse = studentServices.studentLogin(stuEmail,stuPassword);

                    if (signInResponse) {
                        System.out.println("Successfully logged in..");
                        StudentActionMenu.display();
                    }
                    else {
                        System.out.println("Your email or password does not match.");
                    }
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
