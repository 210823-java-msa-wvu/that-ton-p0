package menu.student;

import services.StudentServices;

import java.util.Scanner;

public class StudentScholarMenu {
    private static StudentServices studentServices = new StudentServices();

    public static void display(Integer id) {

        Scanner scanner = new Scanner(System.in);
        Boolean running = true;


        while (running) {

            System.out.println();
            System.out.println("1) My Scholarship Information");
            System.out.println("2) Apply Scholarship");
            System.out.println("3) Back");

            Integer result = scanner.nextInt();

            boolean checkIdResponse = studentServices.checkScholarshipID(id);

            switch (result) {
                case 1: {
                    if (checkIdResponse) {
                        System.out.println(studentServices.getSchoInfo(id));
                        System.out.println();
                    }
                    else {
                        System.out.println("No record found with id " + id);
                        System.out.println();
                    }
                    break;
                }
                case 2: {
                    try {
                        if (checkIdResponse) {
                            boolean checkApply = studentServices.checkIsApply(id);
                            if(checkApply == false) {
                            System.out.println("Scholarship ID " + id + " Applied successfully");
                            System.out.println();
                            studentServices.applyScholarship(id, true);
                            }
                            else {
                                System.out.println("Scholarship ID " + id + " already applied, no need to apply again.");
                                System.out.println();
                                break;
                            }
                        } else {
                            studentServices.createNewApplication(id, id, true);
                            System.out.println("Scholarship ID " + id + " Applied successfully");
                            System.out.println();
                        }
                    }
                    catch (Exception e) {

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
