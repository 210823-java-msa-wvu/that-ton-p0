package app;

import app.professor.ProfMenu;
import app.student.StudentMenu;

import java.util.Scanner;

public class MainMenu {
    public static void display(){

        Scanner scanner = new Scanner(System.in);
        Boolean running = true;

        while(running) {

            System.out.println("Welcome to Revature College!!! Revature is the leading provider of entry-level tech talent powering global leaders.");
            System.out.println("1) Professor Page");
            System.out.println("2) Student Page");
            System.out.println("3) Exit");

            Integer result = scanner.nextInt();

            switch (result){
                case 1: {
                    ProfMenu.display();
                    break;
                }
                case 2: {
                    StudentMenu.display();
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
