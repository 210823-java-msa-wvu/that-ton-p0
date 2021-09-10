package app.professor;

import services.ProfServices;

import java.util.Scanner;

public class ProfScholarMenu {

    private static ProfServices profServices = new ProfServices();

    public static void display() {

        Scanner scanner = new Scanner(System.in);
        Boolean running = true;


        while (running) {

            System.out.println("1) Application List");
            System.out.println("2) Application Decision");
            System.out.println("3) Back");

            Integer result = scanner.nextInt();

            switch (result) {
                case 1: {
                    profServices.scholarshipList();
                    break;
                }
                case 2: {
                    System.out.println("Enter scholarship application ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Approve or Reject?");
                    String dc = scanner.nextLine();

                    if(dc.equals("Approve")) {
                        System.out.println("Enter award amount: ");
                        double award = scanner.nextDouble();
                        profServices.decision(id,award,dc);
                        System.out.println("Successfully updated!!!");
                    }
                    else {
                        profServices.decision(id,0.0,"Reject");
                        System.out.println("Successfully updated!!!");
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
