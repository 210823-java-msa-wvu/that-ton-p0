package menu.professor;

import models.Student;
import repositories.StudentRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfMainMenu {

    private static StudentRepo studentRepo = new StudentRepo();
    public static void display(String email) {

        List<Student> studentList = new ArrayList<>();
        studentList = studentRepo.getAll();

        Scanner scanner = new Scanner(System.in);
        Boolean running = true;

        while (running) {

            System.out.println("Welcome " + email);
            System.out.println();
            System.out.println("1) Students List");
            System.out.println("2) Scholarship Applications");
            System.out.println("3) Logout");

            Integer result = scanner.nextInt();

            switch (result) {
                case 1: {
                    System.out.println();
                    for (Student st : studentList) {
                        System.out.println(st);
                    }
                    System.out.println();
                    break;
                }
                case 2: {
                    ProfScholarMenu.display();
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
