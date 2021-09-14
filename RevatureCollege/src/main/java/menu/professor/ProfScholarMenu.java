package menu.professor;

import exceptions.WrongInputException;
import services.ProfServices;

import java.util.InputMismatchException;
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
                    try {
                        System.out.println("Enter student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        boolean checkIdResponse = profServices.checkScholarshipID(id);
                        if (checkIdResponse) {
                            System.out.println("Approve or Reject?");
                            String dc = scanner.nextLine();

                            if (dc.toLowerCase().equals("approve")) {
                                System.out.println("Enter award amount: ");
                                double award = scanner.nextDouble();
                                profServices.decision(id, award, dc);
                                System.out.println("Successfully updated!!!");
                            } else if (dc.toLowerCase().equals("reject")) {
                                profServices.decision(id, 0.0, "Reject");
                                System.out.println("Successfully updated!!!");
                            } else {
                                System.out.println("Wrong input!!!");
                            }
                        }
                    }catch (Exception e) {
                        System.out.println("Wrong input format!!!");
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
