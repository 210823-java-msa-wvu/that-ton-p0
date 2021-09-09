package app.professor;

import services.ProfServices;

import java.util.Scanner;

public class ProfMenu {
    public static void display() {

        Scanner scanner = new Scanner(System.in);
        ProfServices profServices = new ProfServices();
        Boolean running = true;

        while(running) {

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
                        System.out.println("Successfully logged in..");
                        ProfActionMenu.display();
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
