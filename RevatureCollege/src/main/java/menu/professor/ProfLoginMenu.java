package menu.professor;

import models.ProfUser;
import services.ProfServices;

import java.util.Scanner;

public class ProfLoginMenu {
    public static void display() {

        Scanner scanner = new Scanner(System.in);
        ProfServices profServices = new ProfServices();

        Boolean running = true;

        while(running) {

            System.out.println();
            System.out.println("1) Professor login");
            System.out.println("2) Signup new account");
            System.out.println("3) Back");

            Integer result = scanner.nextInt();

            switch (result) {
                case 1: {
                    scanner.nextLine();

                    System.out.println("Email: ");
                    String profEmail = scanner.nextLine();

                    System.out.println("Password: ");
                    String profPassword = scanner.nextLine();

                    boolean signInResponse = profServices.profLogin(profEmail, profPassword);

                    if (signInResponse) {
                        ProfMainMenu.display(profEmail);
                    }
                    else {
                        System.out.println("Your email or password does not match.");
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.println("What is your ID? ");
                        Integer id = scanner.nextInt();
                        scanner.nextLine();

                        boolean checkIdResponse = profServices.checkProfId(id);

                        if (checkIdResponse) {
                            System.out.println("Please enter your first name: ");
                            String fn = scanner.nextLine();

                            System.out.println("Please enter your last name: ");
                            String ln = scanner.nextLine();

                            System.out.println("Please enter your email, this will be your username: ");
                            String email = scanner.nextLine();

                            System.out.println("Please choose your password: ");
                            String pw = scanner.nextLine();

                            profServices.profCreate(id, email, pw);
                            profServices.createInformation(id, fn, ln, email);
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
