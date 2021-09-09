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
                    System.out.println("What is your ID? ");
                    Integer id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Please enter your email: ");
                    String email = scanner.nextLine();

                    System.out.println("Please choose your password: ");
                    String pw = scanner.nextLine();

                    studentServices.stuCreate(id,email,pw);
                    System.out.println("User " + email + " was created successfully!");
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
