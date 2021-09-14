package menu.student;

import models.Student;

import services.StudentServices;

import java.util.Scanner;

public class StudentLoginMenu {
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
                        StudentMainMenu.display(stuEmail);
                    }
                    else {
                        System.out.println("Your email or password does not match.");
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.println("What is your student ID? ");
                        Integer id = scanner.nextInt();
                        scanner.nextLine();

                        boolean checkIdResponse = studentServices.checkStudentID(id);

                        if (checkIdResponse) {

                            System.out.println("Please enter your email, this will be your username: ");
                            String email = scanner.nextLine();

                            System.out.println("Please choose your password: ");
                            String pw = scanner.nextLine();

                            System.out.println("Please enter first name: ");
                            String fn = scanner.nextLine();

                            System.out.println("Please enter last name: ");
                            String ln = scanner.nextLine();

                            System.out.println("Please enter major: ");
                            String mj = scanner.nextLine();

                            studentServices.stuCreate(id, email, pw);
                            studentServices.createInformation(id, fn, ln, email, mj);
                            System.out.println("User " + email + " was created successfully!");
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input ID format!!!");
                        scanner.next();
                    }

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
